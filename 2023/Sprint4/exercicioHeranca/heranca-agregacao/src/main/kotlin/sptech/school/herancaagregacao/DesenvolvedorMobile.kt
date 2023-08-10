package sptech.school.herancaagregacao

class DesenvolvedorMobile(
    nome: String,
    qtdHorasTrabalhadas: Int,
    valorHoraTrabalhada: Double,
    var qtdHorasTrabalhadasMobile: Int,
    var valorHoraTrabalhadaMobile: Double,
): Desenvolvedor( nome, qtdHorasTrabalhadas, valorHoraTrabalhada) {

    override fun getSalario(): Double {
        return super.getSalario() + (qtdHorasTrabalhadasMobile * valorHoraTrabalhadaMobile)
    }

    override fun toString(): String {
        return "DesenvolvedorMobile(qtdHorasTrabalhadasMobile=$qtdHorasTrabalhadasMobile, valorHoraTrabalhadaMobile=$valorHoraTrabalhadaMobile) ${super.toString()}"
    }

}