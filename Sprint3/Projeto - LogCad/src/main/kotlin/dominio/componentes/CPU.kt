package dominio.componentes

import java.time.LocalDateTime

data class CPU (
    var pctUsoCpu: Double,
    var freqUsoCpu: Double,
    var dataHora: String
    ){
    constructor(): this (0.0,0.0, "")
}