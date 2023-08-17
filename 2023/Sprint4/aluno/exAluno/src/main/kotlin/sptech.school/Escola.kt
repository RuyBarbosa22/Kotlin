package main

class Escola(
    private var nome:String
) {

    private val alunos = mutableListOf<Aluno>()

    fun addAluno(aluno: Aluno){
        this.alunos.add(aluno)
    }

    fun getAprovados(){
        for (aluno in alunos){
            if (aluno.calcularMedia() >= 6.0){
                println(aluno)
            }
            println()
        }
    }

    fun getTodos(){
        println("Todos os Alunos:")
        for (aluno in alunos){
            println(aluno)
        }
        println()
    }

    fun getAlunoGraduacao(){
        for (aluno in alunos){
            if (aluno is AlunoGraduacao){
                println(aluno)
            }
            println()
        }
    }

    fun getAluno(ra:Int){
        val find = alunos.find { it.getRA == ra }
        if (find != null){
            println(find)
        } else {
            println("Aluno não encontrado.")
        }
    }


}