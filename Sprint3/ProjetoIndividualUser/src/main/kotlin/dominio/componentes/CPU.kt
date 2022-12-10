package dominio.componentes

data class CPU (
    var pctUsoCpu: Double,
    var freqUsoCpu: Double,
    var dataHora: String,
    var fk_computador: Int
){
    constructor(): this (0.0,0.0, "", 1)
}