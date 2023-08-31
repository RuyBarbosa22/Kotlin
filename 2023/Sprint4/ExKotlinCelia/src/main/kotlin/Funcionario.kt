abstract class Funcionario (
    var cpf: String,
    var nome: String
) {
    abstract fun calcularSalario(): Double

    override fun toString(): String {
        return "Funcionario(cpf='$cpf', nome='$nome')"
    }


}