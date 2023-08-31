class Professor (
    cpf: String,
    nome: String,
    var qtdAulas: Int,
    var valorAula: Double
): Funcionario(cpf, nome), Bonificavel {

    override fun calcularSalario(): Double {
        return qtdAulas*valorAula*4.5
    }

    override fun getValorBonus(): Double {
        return calcularSalario() * 1.15
    }

    override fun toString(): String {
        return "Professor(qtdAulas=$qtdAulas, valorAula=$valorAula)"
    }


}
