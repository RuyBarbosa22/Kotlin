package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/herois")
class HeroiController {

    val herois = mutableListOf<Heroi>()

    @GetMapping("/novo/{nome}/{forca}")
    fun cadastrar(@PathVariable nome: String,
                  @PathVariable forca: Double): String {

        val novoHeroi = Heroi()
        novoHeroi.nome = nome
        novoHeroi.forca = forca

        herois.add(novoHeroi)
        return "Heroi cadastrado com sucesso"
    }

    @GetMapping
    fun listar(): List<Heroi> {
        return herois
    }
}