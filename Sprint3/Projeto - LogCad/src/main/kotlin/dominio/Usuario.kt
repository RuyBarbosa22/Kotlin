package dominio

data class Usuario(
    var nome: String,
    var email: String,
    var tel: String,
    var senha: String,
    var codEmpresa: String,
    var fkEmpresa: Int
) {
    constructor() : this("","","", "","", 1)
}
