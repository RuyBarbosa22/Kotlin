package repositorio

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UsuarioRepository (val jdbcTemplate: JdbcTemplate) {

    fun cadastro(usuario: Usuario) {
        jdbcTemplate.update(
            """
            insert into Usuario (nome, email, tel, senha) values
            (?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha
        )
    }

    fun validacaoEmail(emailLog: String): Boolean {
        val emailUsuario = jdbcTemplate.queryForObject(
            "select * from Usuario where email = ?;",
            BeanPropertyRowMapper(Usuario::class.java)
        )
        return emailUsuario != null
    }


    fun validacaoSenha(senhaLog: String): Boolean {
        val senhaUsuario = jdbcTemplate.queryForObject(
            "select * from Usuario where senha = ?;",
            BeanPropertyRowMapper(Usuario::class.java)
        )
        return senhaUsuario != null
    }

}
