package sptech.projeto03

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/frutas")
class FrutasController {

    val frutas = mutableListOf<Frutas>()

    @GetMapping // URL: localhost:8080/brinquedos - Método Get
    fun get(): List<Frutas> {
        return frutas
    }

    @GetMapping("/{id}")
    fun get(@PathVariable idFruta: Int): Frutas? {
        for (fruta in frutas) {
            if (fruta.codigo == idFruta) {
                return fruta
            }
        }
        return null
    }

    @PostMapping // URL: localhost:8080/brinquedos - Método Post
    fun post(@RequestBody novaFruta: Frutas): Frutas {
        novaFruta.codigo = frutas.size + 1
        frutas.add(novaFruta)
        return novaFruta
    }

    @DeleteMapping("/deletar/{idFruta}")
    fun delete(@PathVariable idFruta: Int): String {
        frutas.remove(frutas.filter { it.codigo == idFruta }[0])
        return  "Fruta $idFruta excluida com sucesso"
    }
}