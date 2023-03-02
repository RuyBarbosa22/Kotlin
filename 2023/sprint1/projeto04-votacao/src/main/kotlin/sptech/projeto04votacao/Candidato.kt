package sptech.projeto04votacao

data class Candidato (
        val numero: Int,
        val nome: String,
        var votos: Int = 0,
        var valido: Boolean = false
) {

}
