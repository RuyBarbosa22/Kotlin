package exemploFuncionario

class Vendedor (
    cpf: String,
    nome: String,
    var vendas: Double,
    var taxa: Double

): Funcionario(cpf, nome) {

    override fun calcSalario(): Double {
        return vendas*taxa
    }

    override fun toString(): String {
        return "Vendedor(vendas=$vendas, taxa=$taxa ${super.toString()})"
    }
}