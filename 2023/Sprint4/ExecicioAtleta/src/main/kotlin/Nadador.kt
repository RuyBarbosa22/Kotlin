class Nadador (
    nome: String,
    idade: Int,
    esporte: String,
    var estiloNado: String
): Atleta(nome, idade, esporte) {
    fun nadar(): String {
        return "O atleta $nome esta nadando"
    }

    override fun getNome(): String {
        return nome
    }

    override fun setNome(nomeNovo: String) {
        nome = nomeNovo
    }

    override fun getIdade(): Int {
        return idade
    }

    override fun setIdade(idadeNova: Int) {
        idade = idadeNova
    }

    override fun getEsporte(): String {
        return esporte
    }

    override fun setEsporte(esporteNovo: String) {
        esporte = esporteNovo
    }

    override fun treinar(): Void {
        TODO("Not yet implemented")
    }

    override fun competir(): Void {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "Nadador(estiloNado='$estiloNado')"
    }

}