package dominio.componentes

import java.time.LocalDateTime

data class RAM(
    var totalRam: Double,
    var usadoRam: Double,
    var livreRam: Double,
    var dataHora: String
) {
    constructor(): this (0.0,0.0,0.0, "")
}