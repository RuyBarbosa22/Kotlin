package dominio.componentes

import java.time.LocalDateTime

data class Maquina (
    var id: String,
    var SO: String,
    var totalDisco: Double,
    var nucleoL: Int,
    var nucleoF: Int,
    var totalRam: Double,
    var dataHora: String,
    var fk_empresa: Int

        ) {
    constructor(): this ("","", 0.0, 0,0,0.0, "", 1)
}