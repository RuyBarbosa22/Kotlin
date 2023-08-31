abstract class Atleta (
    var nome: String,
    var idade: Int,
    var esporte: String
) {
    abstract fun getNome(): String

    abstract fun setNome(nome: String)

    abstract fun getIdade(): Int

    abstract fun setIdade(idade: Int)

    abstract fun getEsporte(): String

    abstract fun setEsporte(esporte: String)

    abstract fun treinar(): Void

    abstract fun competir(): Void

    override fun toString(): String {
        return "Atleta(nome='$nome', idade=$idade, esporte='$esporte')"
    }
}
