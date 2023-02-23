package sptech.projeto03

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/brinquedos")
class BrinquedoController {
    val brinquedos = mutableListOf<Brinquedo>()
    var contadorBrinquedos = 0

    @GetMapping // URL: localhost:8080/brinquedos - Método Get
    fun get(): List<Brinquedo> {
        return brinquedos
    }

    @PostMapping // URL: localhost:8080/brinquedos - Método Post
    fun post(@RequestBody novoBrinquedo: Brinquedo): Brinquedo {
        contadorBrinquedos++
        novoBrinquedo.codigo = brinquedos.size + 1
        brinquedos.add(novoBrinquedo)
        return novoBrinquedo
    }

    @DeleteMapping("/{codigo}")
    fun delete(@PathVariable codigo: Int): String {
        brinquedos.remove(brinquedos.filter { it.codigo == codigo }[0])
        return  "Brinquedo $codigo excluido com sucesso"
    }

    @GetMapping("/codigo")
    fun get(@PathVariable codigo: Int): Brinquedo? {
        for(brinquedo in brinquedos) {
            if (brinquedo.codigo == codigo) {
                return brinquedo
            }
        }
        return null
    }

    @PutMapping("/{codigo}")
    fun put(@PathVariable codigo: Int, @RequestBody brinquedo: Brinquedo): Brinquedo? {
        if (brinquedos.count { it.codigo == codigo } > 0) {
            delete(codigo)
            brinquedo.codigo = codigo
            brinquedos.add(brinquedo)
            return brinquedo
        }
        return null
    }
}