package dominio.componentes

data class Disco (
    var totalDisco: Double,
    var qtdDisco: Int,
    var dataHora: String,
    var fk_computador: Int

) {
    constructor(): this (0.0,0, "", 1)
}