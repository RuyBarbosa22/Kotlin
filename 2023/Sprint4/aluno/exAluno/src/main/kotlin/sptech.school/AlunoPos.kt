package main

class AlunoPos(
    nome:String,
    ra:Int,
    private var nota1:Double,
    private var nota2:Double,
    private var notaMonografia:Double,
):Aluno(nome, ra) {

    override fun calcularMedia(): Double {
        return nota1 + nota2 + notaMonografia / 3
    }

    override fun toString(): String {
        return "AlunoPos:(${super.toString()}, notaMonografia=$notaMonografia)"
    }


}