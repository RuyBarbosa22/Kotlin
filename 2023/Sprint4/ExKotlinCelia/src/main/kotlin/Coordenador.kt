class Coordenador (
    cpf: String,
    nome: String,
    var qtdHrCoordenacaoSmn: Int,
    var valorHoraCoordenacao: Double,
    var qtdCursos: Int
): Funcionario(cpf, nome), Bonificavel {

    override fun calcularSalario(): Double {
        return (qtdHrCoordenacaoSmn * valorHoraCoordenacao * 4.5) + (qtdCursos *500)
    }

    override fun getValorBonus(): Double {
        return calcularSalario() * 1.2
    }

    override fun toString(): String {
        return "Coordenador(qtdHrCoordenacaoSmn=$qtdHrCoordenacaoSmn, valorHoraCoordenacao=$valorHoraCoordenacao, qtdCursos=$qtdCursos)"
    }




}
