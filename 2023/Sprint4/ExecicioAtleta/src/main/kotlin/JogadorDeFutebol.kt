class JogadorDeFutebol (
    nome: String,
    idade: Int,
    esporte: String,
    var golsMarcados: Int
): Atleta(nome, idade, esporte){

    fun jogarFutebol(): String {
        return "O atleta $nome está jogando"
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
        return "JogadorDeFutebol(golsMarcados=$golsMarcados)"
    }

}