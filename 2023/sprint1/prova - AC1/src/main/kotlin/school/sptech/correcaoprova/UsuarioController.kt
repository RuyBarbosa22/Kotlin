package school.sptech.correcaoprova

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import school.sptech.correcaoprova.dto.UsuarioLoginDto
import school.sptech.correcaoprova.dto.UsuarioRespostaDto
import school.sptech.correcaoprova.dto.UsuarioSenhaRequisicaoDto
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    val usuarios = mutableListOf<Usuario>()

    @PostMapping
    fun criar(@RequestBody @Valid novoUsuario: Usuario): ResponseEntity<UsuarioRespostaDto> {
        val usuarioExistente =
            usuarios.firstOrNull { it.login == novoUsuario.login }

        if (usuarioExistente != null) {
            throw ResponseStatusException(
                409,
                "O login ${novoUsuario.login} já existe no sistema",
                null
            )
        }

        usuarios.add(novoUsuario)

        val novoUsarioDto = UsuarioRespostaDto(novoUsuario)

        return ResponseEntity.status(201).body(novoUsarioDto)
    }

    @DeleteMapping("/{login}")
    fun desativa(@PathVariable login: String): ResponseEntity<Void> {
        val usuarioExistente =
            usuarios.firstOrNull {
                it.login == login
            }

//        val usuarioExistente =
//            usuarios.firstOrNull { it.login == login
//            } ?: return "Usuário ${login} não encontrado"

        if (usuarioExistente == null) {
            throw ResponseStatusException(404, null, null)
        }

        usuarioExistente.ativo = false
        usuarioExistente.autenticado = false
        return ResponseEntity.status(200).build()
        // também estaria certo: return ResponseEntity.status(204).build()
    }

    @GetMapping
    fun list(): ResponseEntity<List<UsuarioRespostaDto>> {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(usuarios.map { UsuarioRespostaDto(it) })
    }

    @PostMapping("/autenticacao")
    fun autenticar(@RequestBody usuarioLogin: UsuarioLoginDto): ResponseEntity<UsuarioRespostaDto> {
        val usuarioExistente =
            usuarios.firstOrNull {
                it.login == usuarioLogin.login &&
                        it.senha == usuarioLogin.senha
            }

        if (usuarioExistente != null) {
            if (usuarioExistente.ativo) {
                usuarioExistente.autenticado = true
//                usuarioExistente.acessos++
                usuarioExistente.acessos += 1

                val usuarioRespostaDto = UsuarioRespostaDto(usuarioExistente)
                return ResponseEntity.status(200).body(usuarioRespostaDto)
            }

            throw ResponseStatusException(
                403,
                "Usuário ${usuarioLogin.login} não está ativo",
                null
            )
        }

        // poderia ser 404 também
        throw ResponseStatusException(
            401,
            "Usuário ${usuarioLogin.login} não encontrado",
            null
        )
    }

    @DeleteMapping("/autenticacao/{login}")
    fun desautenticar(@PathVariable login: String): ResponseEntity<Void> {
        val usuarioExistente =
            usuarios.firstOrNull {
                it.login == login
            } ?: throw ResponseStatusException(401,"Usuário não encontrado", null)
        // poderia ser 404 também

        usuarioExistente.autenticado = false
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("/senha/{login}")
    fun atualizaSenha(
        @PathVariable login: String,
        @RequestBody usuarioSenha: UsuarioSenhaRequisicaoDto
    ): ResponseEntity<Void> {
        val usuarioExistente =
            usuarios.firstOrNull {
                it.login == login
            } ?: throw ResponseStatusException(401,"Usuário não encontrado", null)
        // poderia ser 404 também

        usuarioExistente.senha = usuarioSenha.senha
        usuarioExistente.dicaSenha = usuarioSenha.dicaSenha

        return ResponseEntity.status(200).build()
    }

}