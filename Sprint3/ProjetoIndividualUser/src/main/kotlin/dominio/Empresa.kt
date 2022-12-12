package dominio

data class Empresa(
    var id: Int,
    var nome: String,
    var email: String,
    var cnpj: String,
    var cep: String,
    var estado: String,
    var numero: String,
    var senha: String,
    var codEmpresa: String
) {
    constructor() : this(0,"","","", "","", "", "", "")
}

