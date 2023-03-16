package sptech.prova

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

        val usuarios = mutableListOf<Usuario>()

        @PostMapping
        fun post(@RequestBody novo: Usuario): String {
            if (usuarios.count { it.login == novo.login } > 0) {
                return "O LOGIN ${novo.nome} já existe no sistema"
            } else {
                usuarios.add(novo)
                novo.ativo = true
                return "Usuário LOGIN ${novo.nome} cadastrado com sucesso"

            }
        }
 //  cadastro ok

    @GetMapping
    fun get(): List<UsuarioResponse> {
        val listaResposta = usuarios.map { UsuarioResponse(it) }
        return listaResposta
    }
// lista ok

    @DeleteMapping("/{login}")
    fun delete(@PathVariable login:String):String {
        if (usuarios.count { it.ativo == true} > 0 ) {
            usuarios.remove(usuarios.filter { it.login == login }[0])
            return "Usuario $login desativo"
        } else {
            return "Usuário $login não encontrado no sistema ou já esta desativado"
        }
    }
// desativar conta ok

    @PostMapping("/autenticacao")
    fun autenticar(@RequestBody usuario: UsuarioAutRequest):String {
        val userEncontrado = usuarios.filter { it.login == usuario.login && it.senha == usuario.senha }

        if (userEncontrado.isEmpty()) {
            return "Usuário ${usuario.login} não encontrado"
        } else {
                if (userEncontrado[0].ativo == true) {
                    userEncontrado[0].acesso++
                    userEncontrado[0].autenticado = true
                    return "O Usuario ${usuario.login} autenticado com sucesso"
                } else {
                    return "O Usuario ${usuario.login} não está ativo"
                }
            }
        }



    @DeleteMapping("/autenticacao/{login}")
    fun desautenticar(@PathVariable login:String):String {
        val userEncontrado = usuarios.filter { it.login == login }

        if (userEncontrado.isEmpty()) {
            return "Usuário $login não encontrado"
        } else {
            userEncontrado[0].autenticado = false
            return "Usuário $login fez LOGOFF com sucesso"
        }
    }


        @PatchMapping("/senha/{login}")
        fun patch(@RequestBody usuario: UsuariosRequest, @PathVariable login : String):String {
            val userEncontrado = usuarios.firstOrNull{ it.login == login }
            if (userEncontrado!=null) {
                userEncontrado.senha = usuario.senha
                userEncontrado.dicaSenha = usuario.dicaSenha
                return "Senha do usuário $login alterada com sucesso"
            } else {
                return "Usuário $login não encontrado "
            }
        }

}