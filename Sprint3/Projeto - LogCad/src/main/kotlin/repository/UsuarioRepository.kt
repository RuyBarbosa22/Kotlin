package repository

import dominio.Empresa
import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UsuarioRepository(private val jdbcTemplate: JdbcTemplate) {

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

    fun cadUsuario(usuario: Usuario) {
        jdbcTemplate.update(
            """
            insert into dbo.Usuario (nome, email, tel, senha, codEmpresa, fk_empresa) values
            (?,?,?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha, usuario.codEmpresa, usuario.fkEmpresa
        )
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

    fun validaEmpresa(usuario: Usuario): Empresa {
        val dadosEmp = jdbcTemplate.queryForObject(
            "select * from empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Empresa::class.java), usuario.codEmpresa
        )
        return dadosEmp
    }

    fun identificaUser(email: String, senha: String): Usuario {
        val usuario = jdbcTemplate.queryForObject(
            "select * from Usuario where email = ? and senha = ?",
            BeanPropertyRowMapper(Usuario::class.java), email, senha
        )
        return usuario
    }
}