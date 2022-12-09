package dominio

data class Expediente(
    var HrEntrada: String,
    var HrSaida: String,
    var fkEmpresa: Int
) {
    constructor() : this("","", 0)
}
