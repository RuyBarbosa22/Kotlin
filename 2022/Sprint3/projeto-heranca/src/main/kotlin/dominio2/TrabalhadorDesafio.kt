package dominio2

import dominio2.ContaDesafio

class TrabalhadorDesafio() : ContaDesafio("Roberto", 780.0) {

    override fun depositar(valor: Double) {
        val add = valor - (valor * 0.01)
        super.depositar(add)
    }
}