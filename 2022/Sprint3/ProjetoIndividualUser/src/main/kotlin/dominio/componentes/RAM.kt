package dominio.componentes

data class RAM(
    var totalRam: Double,
    var usadoRam: Double,
    var livreRam: Double,
    var dataHora: String,
    var fk_computador: Int
) {
    constructor(): this (0.0,0.0,0.0, "", 1)
}