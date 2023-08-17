package main

abstract class Aluno(
    private var nome:String,
    private var ra:Int,
) {

    abstract fun calcularMedia():Double

    val getRA: Int
        get() = ra

    override fun toString(): String {
        return "Aluno(nome='$nome', ra=$ra)"
    }
}