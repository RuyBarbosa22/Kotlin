package sptech.projeto04votacao

class Eleicao {

    val votacao = mutableListOf<Candidato>()

    fun iniciar() {
        val candidatoBranco = Candidato(0, "Branco")
        val candidatoNulo = Candidato(-1, "Nulo")
        if (!votacao.contains(candidatoBranco)) {
            votacao.add(candidatoBranco)
        }
        if (!votacao.contains(candidatoNulo)) {
            votacao.add(candidatoNulo)
        }

    }

    fun cadastrarCandidato(novoCandidato: Candidato) {
        novoCandidato.valido = true
        if (!votacao.contains(novoCandidato)) {
            votacao.add(novoCandidato)
        }
    }

    fun votar(numero: Int): String {
        if (votacao.isEmpty()) {
            return "votação ainda não foi iniciada"
        }

        val encontrado = votacao.filter { it.numero == numero }
        return if (encontrado.isNotEmpty()) {
            encontrado[0].votos++
            "Votos registrados para ${encontrado[0].nome}"
        } else {
            votacao.filter { it.numero == -1 }[0].votos++
            "Candidato não encontrado! Voto nulo"
        }
    }

    fun getTotalVotos(): Int {
        return votacao.sumOf { it.votos }
    }

    fun getVotosValidos(): Int {
        return votacao.sumOf { if (it.valido) it.votos else 0 }
    }

    fun hasVotosValidos(): Boolean {
        return getVotosValidos()> 0
    }

}