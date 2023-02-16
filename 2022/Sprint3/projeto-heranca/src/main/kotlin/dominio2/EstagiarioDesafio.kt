package dominio2

import dominio2.ContaDesafio

// Classes/arquivos.kt com "desafio" eram desafios do Yoshi XD
// Ele passou um desafio com coisa que ele n tinha explicado e nem valeu

class EstagiarioDesafio() : ContaDesafio("Ruy", 150.0) {

    override fun depositar(valor: Double) {
        super.depositar(valor*1.05)
    }


}