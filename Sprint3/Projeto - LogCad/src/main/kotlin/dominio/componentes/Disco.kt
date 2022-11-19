package dominio.componentes

import java.time.LocalDateTime

data class Disco (
    var totalDisco: Double,
    var qtdDisco: Int

        ) {
    constructor(): this (0.0,0)
}