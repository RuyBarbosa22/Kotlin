package app

import dominio.Carro

fun main() {
    val carro1 = Carro("BMW 340i", false, 0.0)

    carro1.ligarCarro()
    carro1.acelerar()
    carro1.freiar()
    println("%.1f".format(carro1.verVelocidade()))
}