package main

class AlunoFundamental(
    nome:String,
    ra:Int,
    private var nota1:Double,
    private var nota2:Double,
    private var nota3:Double,
    private var nota4:Double,
):Aluno(nome,ra) {

        override fun calcularMedia():Double {
            return nota1 + nota2 + nota3 + nota4 / 4
        }

    override fun toString(): String {
        return "AlunoFundamental(nota1=$nota1, nota2=$nota2, nota3=$nota3, nota4=$nota4)"
    }


}