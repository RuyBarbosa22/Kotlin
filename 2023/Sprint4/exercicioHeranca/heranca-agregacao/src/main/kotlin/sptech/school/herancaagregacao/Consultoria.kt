package sptech.school.herancaagregacao

class Consultoria(
    var nome:String,
    var vagas: Int
) {
    private val desenvolvedores = mutableListOf<Desenvolvedor>()

    fun existePorNome(nome: String): Boolean {
        return desenvolvedores.any { it.nome == nome }
    }

    fun contratar(Desenvolvedor :Desenvolvedor):String{
        if(vagas > 0){
            desenvolvedores.add(Desenvolvedor)
            vagas--
            return "Contratado com sucesso!"
        }else{
            println("Sem vagas disponíveis!")
            return "Sem vagas disponíveis!"
        }
    }

    fun getQuantidadeDesenvolvedores(): Int {
        return desenvolvedores.size
    }

    fun getQuantidadeDesenvolvedoresMobile(): Int {
        var quantidade = 0

        for (desenvolvedor in desenvolvedores) {
            if (desenvolvedor is DesenvolvedorMobile) {
                quantidade++
            }
        }

        return quantidade
    }

    fun getTotalSalarios(): Double {
        var total = 0.0

        for (desenvolvedor in desenvolvedores) {
            total += desenvolvedor.getSalario()
        }

        return total
    }

    fun buscarDesenvolvedorPorNome(nome: String): Desenvolvedor? {
        for (desenvolvedor in desenvolvedores) {
            if (desenvolvedor.nome == nome) {
                return desenvolvedor
            }
        }

        return null
    }

    override fun toString(): String {
        return "Consultoria(nome='$nome', vagas=$vagas, desenvolvedores=$desenvolvedores)"
    }


}