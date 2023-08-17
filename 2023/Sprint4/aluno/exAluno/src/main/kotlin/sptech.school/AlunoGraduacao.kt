package main

class AlunoGraduacao(
    nome:String,
    ra:Int,
    private var nota1:Double,
    private var nota2:Double,
):Aluno(nome,ra) {

    override fun calcularMedia():Double {
        return nota1 * 0.4 + nota2 * 0.6
    }

    override fun toString(): String {
        return "AlunoGraduacao:(${super.toString()}, media=${calcularMedia()})"
    }


}