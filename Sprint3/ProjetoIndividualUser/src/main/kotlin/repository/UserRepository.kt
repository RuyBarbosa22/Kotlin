package repository

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UserRepository(private val jdbcTemplate: JdbcTemplate) {

    fun validar1(usuario: Usuario): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select count (*) from dbo.empresa where codEmpresa = ?",
            Int::class.java, usuario.codEmpresa
        )
        return validaCod == 0
    }
    fun validar2(usuario: Usuario): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select * from dbo.empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Usuario::class.java), usuario.codEmpresa
        )
        return validaCod != null
    }

    fun validacaoLogin1(email: String, senha: String): Boolean {
        val retorno = jdbcTemplate.queryForObject(
            "select count (*) from dbo.Usuario where email = ? and senha = ?",  // "?" será substituido pelo id
            Int::class.java, email, senha
        )
        return retorno == 0
    }

    fun validacaoLogin2(email: String, senha: String): Boolean {
        return jdbcTemplate.queryForObject(
            "select * from dbo.Usuario where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), email, senha
        ) != null
    }
}

