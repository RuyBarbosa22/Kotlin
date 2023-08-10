package exemploFuncionario

class Engenheiro (
    cpf: String,
    nome: String,
    var salario: Double
): Funcionario(cpf, nome){

    override fun calcSalario(): Double {
        return salario
    }

    override fun toString(): String {
        return "Engenheiro(salario=$salario, nome=$nome, salario=$salario ${super.toString()})"
    }
}