package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/votos")
class VotarController {

    var candidato1 = 0
    var candidato2 = 0
    var nulos = 0

    @GetMapping("/candidato/{voto}")
    fun votar(@PathVariable voto: Int): String {
        if (voto > 2 || voto < 1) {
            nulos += 1
            return "Voto NULO"
        } else {
            if (voto == 1) {
                candidato1 += voto
                return "Voto para candidato 1 confirmado"
            } else {
                candidato2 += voto - 1
                return "Voto para candidato 2 confirmado"
            }
        }
    }

    @GetMapping("/resultado")
    fun resultado(): String {
        return "Total de votos: ${candidato2+candidato1+nulos} <br>" +
                "Candidato 1: $candidato1 <br>" +
                "Candidato 2: $candidato2 <br>" +
                "Nulos: $nulos"
    }
}