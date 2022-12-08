package dominio.componentes

data class Maquina (
    var id: Int,
    var serialNumber: String,
    var sistema_operacional: String,
    var disco_total: Double,
    var cpu_nucleos_logicos: Int,
    var cpu_nucleos_fisicos: Int,
    var memoria_total: Double,
    var fk_empresa: Int

        ) {
    constructor(): this (0,"","", 0.0, 0,0,0.0,1)
}