package pratica.sptech

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tenis")
class TenisController (val repository: TenisRepository) {

    @GetMapping("/melhores")
    fun getMelhores(): ResponseEntity<List<Tenis>> {
        val resultado = repository.findByNotaGreaterThan(8.5)

        if (resultado.isNotEmpty()) {
            return ResponseEntity.status(200).body(resultado) //quando é body retorna um JSon
        }
        return ResponseEntity.status(204).build() //quando é build não retorna Json
    }

    //codigo se refere ao Id
    @PatchMapping("/{codigo}/nao-mais-bonito")
    fun patchBonito(@PathVariable codigo: Int): ResponseEntity<Void> {
        if (repository.existsById(codigo)) { // valida se existe um tenis com esse codigo
            val tenisRecuperado = repository.findById(codigo).get() // pega o valor do Json
            tenisRecuperado.bonito = false // altera o valor do parametro do Json
            repository.save(tenisRecuperado) // atualiza o valor no banco
            return ResponseEntity.status(200).build()
        } else {
            return ResponseEntity.status(404).build()
        }
    }
}