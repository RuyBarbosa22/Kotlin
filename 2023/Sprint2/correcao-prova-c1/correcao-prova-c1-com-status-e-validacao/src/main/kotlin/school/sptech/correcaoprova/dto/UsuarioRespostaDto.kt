package school.sptech.correcaoprova.dto

import school.sptech.correcaoprova.Usuario

data class UsuarioRespostaDto (
    var login: String,
    var nome: String,
    var autenticado: Boolean,
    var acessos: Int,
){

    constructor(usuario: Usuario): this (
        usuario.login,
        usuario.nome,
        usuario.autenticado,
        usuario.acessos
    )
}