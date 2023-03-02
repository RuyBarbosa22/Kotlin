package sptech.projeto04votacao

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/votacao")
class VotacaoController {

    val eleicao = Eleicao()

    @PostMapping
    fun iniciarVotacao(): String {
        eleicao.iniciar()
        return "votação iniciada"
    }


    @PostMapping("/voto/{numero}")
    fun registrarVoto(@PathVariable numero: Int): String {
        return eleicao.votar(numero)
    }

    @GetMapping
    fun resultado(): Eleicao {
        return eleicao
    }

    @PostMapping("/candidato")
    fun registrarCandidato(@RequestBody novoCandidato: Candidato): Candidato {
        eleicao.cadastrarCandidato(novoCandidato)
        return novoCandidato
    }


}