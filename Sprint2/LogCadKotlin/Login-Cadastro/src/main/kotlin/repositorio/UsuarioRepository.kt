package repositorio

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UsuarioRepository (val jdbcTemplate: JdbcTemplate) {

    fun cadastro(usuario: Usuario) {
        jdbcTemplate.update(
            """
            insert into Carro (nome, email, tel, senha) values
            (?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha
        )
    }

    fun entrar(): List<Usuario> {
        return jdbcTemplate.query(
            "select Usuario.nome, Usuario.email from Usuario;",
            BeanPropertyRowMapper(Usuario::class.java)
        )
    }


}
