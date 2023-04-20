package provaProgWeb.prova

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/carros")
class CarroController (val repository: CarroRepository) {

    @GetMapping("/populares")
    fun getMelhores(): ResponseEntity<List<Carro>> {
        val resultado = repository.findByPrecoLessThan(40000.0)

        if (resultado.isNotEmpty()) {
            return ResponseEntity.status(200).body(resultado) //quando é body retorna um JSon
        }
        return ResponseEntity.status(204).build() //quando é build não retorna Json
    }
}