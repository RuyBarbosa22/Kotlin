fun main(args: Array<String>) {

        val secretaria = Secretario("129476789", "Marta", 3200.0, 150.0)
        val professor = Professor("987654937", "Pedro", 18, 60.0)
        val coordenador = Coordenador("654321857", "Maria", 10, 62.0, 4)

        val controleBonus = ControleBonus()

        controleBonus.addFuncionario(professor)
        controleBonus.addFuncionario(coordenador)

        println("Funcionários com bônus:")
        controleBonus.exibirFuncionarios()

        println("Total de bônus: ${controleBonus.calcularTotalBonus()}")
}