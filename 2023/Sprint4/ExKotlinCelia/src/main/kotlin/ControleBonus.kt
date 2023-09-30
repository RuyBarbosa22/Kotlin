    class ControleBonus (
    ) {
        private val funcComBonus = mutableListOf<Bonificavel>()

        fun addFuncionario(funcionario: Bonificavel) {
            funcComBonus.add(funcionario)
        }

        fun exibirFuncionarios() {
            for (funcionario in funcComBonus) {
                println(funcionario)
            }
        }

        fun calcularTotalBonus(): Double {
            var totalBonus = 0.0
            for (funcionario in funcComBonus) {
                totalBonus += funcionario.getValorBonus()
            }
            return totalBonus
        }
    }