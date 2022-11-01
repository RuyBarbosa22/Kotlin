package dominio

import kotlin.math.round

class Carro(
    val modelo: String,
    private var ligado: Boolean,
    private var velocidade: Double
) {
    fun ligarCarro() {
        ligado = true
    }

    fun desligarCarro() {
        ligado = false
        velocidade = 0.0
    }

    fun acelerar(): Double {
        if (ligado) {
            if (velocidade == 0.0) {
                velocidade = 10.0
            } else {
                velocidade += velocidade * 0.10
            }
            if (velocidade > 110.0) {
                velocidade = 110.0
            }
        }
        return velocidade
    }

    fun freiar(): Double {
        if (ligado) {
            velocidade -= 3
            if (velocidade < 0.0) {
                velocidade = 0.0
            }
        }
        return velocidade
    }

    fun verVelocidade(): Double {
        return velocidade
    }
}


