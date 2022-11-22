package repositorio

import dominio.Empresa
import dominio.Usuario
import dominio.componentes.CPU
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

@Suppress("UNREACHABLE_CODE")
class UsuarioRepository(private val jdbcTemplate: JdbcTemplate) {

    fun validar(codEmpresaCad: String): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select * from empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Usuario::class.java), codEmpresaCad
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

    fun validacaoLogin(usuario: Usuario): Boolean {
        val selectLoginUser = jdbcTemplate.queryForObject(
            "select * from empresa where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), usuario.email, usuario.senha
        )
        return selectLoginUser != null
    }
}