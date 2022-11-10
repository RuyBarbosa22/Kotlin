package repositorio

import dominio.Usuario
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class UsuarioRepository(val jdbcTemplate: JdbcTemplate) {

    fun cadastro(usuario: Usuario){
        jdbcTemplate.update(
            """
            insert into Usuario (nome, email, tel, senha) values
            (?,?,?,?)
        """, usuario.nome, usuario.email, usuario.tel, usuario.senha
        )
    }

    fun validacaoLogin(emailLog: String, senhaLog: String): Boolean {
        val selectLogin = jdbcTemplate.queryForObject(
            "select * from Usuario where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Usuario::class.java), emailLog, senhaLog
        )
        return selectLogin != null
    }



    fun isNumeric(telCad: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return telCad.matches(regex)
    }

}





