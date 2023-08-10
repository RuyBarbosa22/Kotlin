package sptech.school.herancaagregacao

open class Desenvolvedor(
    var nome: String,
    var qtdHorasTrabalhadas: Int,
    var valorHoraTrabalhada: Double
) {

        open fun getSalario(): Double {
            return qtdHorasTrabalhadas * valorHoraTrabalhada
        }

        override fun toString(): String {
            return "Desenvolvedor(nome='$nome', qtdHorasTrabalhadas=$qtdHorasTrabalhadas, valorHoraTrabalhada=$valorHoraTrabalhada, salario=${getSalario()})"
        }
}