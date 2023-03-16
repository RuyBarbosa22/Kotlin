package sptech.prova

data class Usuario(
        val login:String,
        var senha:String,
        val nome:String,
        var dicaSenha:String,
        var ativo:Boolean = false,
        var autenticado:Boolean = false,
        var acesso:Int = 0
){

}

