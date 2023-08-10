package exemploFuncionario

class Empresa {
    private val funcionarios = mutableListOf<Funcionario>()

    //variavel que cria funcionario e add na lista
    fun addFunc(f:Funcionario) {
        this.funcionarios.add(f)
    }

    fun getTodos() {
        println("Todos os funcionários")

        for (funcionario in funcionarios) {
            println(funcionario)
        }

        println("")
    }

    fun exibeTotalSalario() {
        var soma = 0.0

        for (funcionario in funcionarios) {
            soma+= funcionario.calcSalario()

            println("\n A soma dos salários é: $soma")
        }
    }

    fun exibeHoristas() {
        println("Funcionários horistas")

        for (funcionario in funcionarios) {
            if (funcionario is Horista) {
                println(funcionario)
            }
        }

        println(" ")
    }
}