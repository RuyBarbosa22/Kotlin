data class Pokemon(
    var id: Int,
    var nome: String,
    var forca: Double,
    var solto: Boolean
){
    constructor() : this(0,"", 0.0,false)
}