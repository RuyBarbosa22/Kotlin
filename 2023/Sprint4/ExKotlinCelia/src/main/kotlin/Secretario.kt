class Secretario(
    cpf: String,
    nome: String,
    var salario: Double,
    var extra: Double
): Funcionario(cpf, nome) {

    override fun calcularSalario(): Double {
        return salario+extra
    }

    override fun toString(): String {
        return "Secretario(extra=$extra) ${super.toString()}"
    }



}