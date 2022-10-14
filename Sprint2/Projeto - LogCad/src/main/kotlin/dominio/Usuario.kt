package dominio

data class Usuario(
    var id: Int,
    var nome: String,
    var email: String,
    var tel: String,
    var senha: String
) {
    constructor() : this(0,"","","", "")
}

