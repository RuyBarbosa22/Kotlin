package repository

import dominio.Empresa
import dominio.Expediente
import dominio.Usuario
import dominio.componentes.CPU
import dominio.componentes.Maquina
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

    fun validaEmpresa(usuario: Usuario): Empresa {
        val dadosEmp = jdbcTemplate.queryForObject(
            "select * from empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Empresa::class.java), usuario.codEmpresa
        )
        return dadosEmp
    }

    fun validaFkEmpresa1(empresa: Empresa): Boolean {
        val fkExiste = jdbcTemplate.queryForObject(
            "select count (*) from expediente where fk_empresa = ?",
            Int::class.java, empresa.id
        )
        return fkExiste == 0
    }

    fun validaFkEmpresa2(empresa: Empresa): Expediente {
        val horario = jdbcTemplate.queryForObject(
            "select * from expediente where fk_empresa = ?",
            BeanPropertyRowMapper(Expediente::class.java), empresa.id
        )
        return horario
    }

    fun identificaUser(email: String, senha: String): Usuario {
        val usuario = jdbcTemplate.queryForObject(
            "select * from Usuario where email = ? and senha = ?",
            BeanPropertyRowMapper(Usuario::class.java), email, senha
        )
        return usuario
    }

    fun alerta(maquina: Maquina, empresa: Empresa, usuario: Usuario) {
        jdbcTemplate.update(
            """
            insert into alerta_atividade (nomeUsuario, horaAlerta, fk_empresa, fk_computador, fk_usuario) values
            (?,current_timestamp,?,?,?)
        """, usuario.nome, empresa.id, maquina.id, usuario.id
        )
    }


}

