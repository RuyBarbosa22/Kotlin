package repositorio

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

@Suppress("UNREACHABLE_CODE")
class UsuarioRepository(private val jdbcTemplate: JdbcTemplate) {

    fun validar(usuario: Usuario): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select * from dbo.empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Usuario::class.java), usuario.codEmpresa
        )
        return validaCod != null
    }

    fun cadUsuario(usuario: Usuario) {
        jdbcTemplate.update(
            """
            insert into dbo.Usuario (nome, email, tel, senha, codEmpresa, fk_empresa) values
            (?,?,?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha, usuario.codEmpresa, usuario.fkEmpresa
        )
    }

    fun validacaoLogin(email: String, senha: String): Boolean {
        return jdbcTemplate.queryForObject(
            "select * from dbo.Usuario where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), email, senha
        ) != null
    }
}