package dominio.componentes

import java.time.LocalDateTime

data class CPU (
    var pctUsoCpu: Double,
    var freqUsoCpu: Double
        ) {
    constructor(): this (0.0,0.0)
}