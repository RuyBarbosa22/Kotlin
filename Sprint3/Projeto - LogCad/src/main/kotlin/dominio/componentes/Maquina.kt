package dominio.componentes

import java.time.LocalDateTime

data class Maquina (
    var SO: String,
    var totalDisco: Double,
    var nucleoL: Int,
    var nucleoF: Int,
    var totalRam: Double,
    var dataHora: LocalDateTime
        ) {
    constructor(): this ("", 0.0, 0,0,0.0, LocalDateTime.now())
}