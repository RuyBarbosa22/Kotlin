package dominio

data class Expediente(
    var id: Int,
    var HrEntrada: String,
    var HrSaida: String,
    var fk_empresa: Int
) {
    constructor() : this(0,"","",0)
}
