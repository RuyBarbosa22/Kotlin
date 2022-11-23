package dominio

data class Usuario(
    var id: String?,
    var nome: String,
    var email: String,
    var tel: String,
    var senha: String,
    var codEmpresa: String,
    var fkEmpresa: String
) {
    constructor() : this("","","", "","", "", "")
}
