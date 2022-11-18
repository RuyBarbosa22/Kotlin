package dominio.componentes

import java.time.LocalDateTime

data class CPU (
    var pctUsoCpu: Double,
    var freqUsoCpu: Double,
    var dataHora: LocalDateTime
        ) {
    constructor(): this (0.0,0.0, LocalDateTime.now())
}