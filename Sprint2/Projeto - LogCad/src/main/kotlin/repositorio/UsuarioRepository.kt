package repositorio

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UsuarioRepository(val jdbcTemplate: JdbcTemplate) {

    fun cadastro(usuario: Usuario): String{
        jdbcTemplate.update(
            """
            insert into Usuario (nome, email, tel, senha) values
            (?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha
        )
        return cadastro(usuario)
    }

    fun isNumeric(telCad: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return telCad.matches(regex)
    }

    fun validacaoEmail(emailLog: String): Boolean {
        val selectEmail = jdbcTemplate.queryForObject(
            "select * from Usuario where email like ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), emailLog
        )
        return selectEmail != null
    }

    fun validacaoSenha(senhaLog: String): Boolean {
        val selectSenha = jdbcTemplate.queryForObject(
            "select * from Usuario where senha like ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), senhaLog
        )
        return selectSenha != null
    }

}





