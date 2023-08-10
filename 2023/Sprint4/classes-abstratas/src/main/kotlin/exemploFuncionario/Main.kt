package exemploFuncionario

import exemploFuncionario.Empresa
import exemploFuncionario.Engenheiro
import exemploFuncionario.Funcionario
import exemploFuncionario.Vendedor

fun main(args: Array<String>) {

    val f1 = Engenheiro("51139399874", "Wandão ostentação", 10_000.0)
    val f2 = Vendedor("65574888765", "Antonietta pericla", 24_000.0, 0.70)
    val f3 = Horista("86695999476", "Tonhão do canhão", 66, 15.0)

    val empresa = Empresa()
    empresa.addFunc(f1)
    empresa.addFunc(f2)
    empresa.addFunc(f3)
    empresa.getTodos()
    println(f1)
}