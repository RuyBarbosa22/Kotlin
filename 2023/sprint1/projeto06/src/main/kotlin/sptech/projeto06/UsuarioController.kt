package sptech.projeto06

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    val usuarios = mutableListOf<Usuario>()

    @PostMapping
    fun post(@RequestBody novo:Usuario): ResponseEntity<Usuario> {
        if (novo.login.length < 4) {
/*
Aqui estamos LANÇANDO UMA EXCEÇÃO
do tipo ResponseStatusException,
indicando o status de resposta e a mensagem de erro.

Só usamos essa técnica para situações não desejadas do EndPoint
(ex: erro de validação, dado não encontrado etc)
 */
            throw ResponseStatusException(400, "Login deve ter 4+ letras", null)
        }
        if (novo.senha.length < 6) {
            throw ResponseStatusException(400, "Senha deve ter 6+ letras", null)
        }
        if (usuarios.count { it.login == novo.login } > 0) {
            throw ResponseStatusException(409, "Login já existe no sistema", null)
        }
        usuarios.add(novo)
        return ResponseEntity.status(201).body(novo)
    }

    @GetMapping
    fun get(): ResponseEntity<List<Usuario>> {
        if (usuarios.isEmpty()) {
            // .build() indica que o corpo será vazio
            return ResponseEntity.status(204).build()
// por que não usamos throw ResponseStatusException aqui?
// porque não foi um erro. A consulta simplesmente não tinha dados
        }
        return ResponseEntity.status(200).body(usuarios)
    }

    @GetMapping("/{login}")
    fun get(@PathVariable login:String): ResponseEntity<Usuario> {
        val usuarioEncontrado = usuarios.firstOrNull { it.login == login }

        if (usuarioEncontrado == null) {
            throw ResponseStatusException(404, "Login não encontrado", null)
        }

        return ResponseEntity.status(200).body(usuarioEncontrado)
    }
}

