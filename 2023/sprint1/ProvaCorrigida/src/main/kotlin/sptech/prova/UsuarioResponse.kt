package sptech.prova

data class UsuarioResponse(

val login:String,
val nome:String,
var autenticado:Boolean = false,
var acesso:Int = 0

){

    constructor(usuario:Usuario): this(
    usuario.login,
    usuario.nome,
    usuario.autenticado,
    usuario.acesso
    )
}

