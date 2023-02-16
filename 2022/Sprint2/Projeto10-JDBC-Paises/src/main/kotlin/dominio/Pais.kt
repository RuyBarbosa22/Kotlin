package dominio

data class Pais(
    var id: Int,
    var nome: String,
    var populacao: Int
) {
    constructor() : this(0,"",0)
}