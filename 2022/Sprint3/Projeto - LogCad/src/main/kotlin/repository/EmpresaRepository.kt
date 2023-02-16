package repository

import dominio.Empresa
import dominio.Expediente
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class EmpresaRepository(val jdbcTemplate: JdbcTemplate) {

    fun cadastro(empresa: Empresa){
        jdbcTemplate.update(
            """
            insert into empresa (nome, email, cnpj, cep, estado, numero, senha, codEmpresa) values
            (?,?,?,?,?,?,?,?)
        """, empresa.nome, empresa.email, empresa.cnpj, empresa.cep, empresa.estado, empresa.numero, empresa.senha, empresa.codEmpresa
        )
    }

    fun validacaoLogin1(emailLog: String, senhaLog: String): Boolean {
        val selectLogin = jdbcTemplate.queryForObject(
            "select count (*) from empresa where email = ? and senha = ?",  // "?" será substituido pelo id
            Int::class.java, emailLog, senhaLog
        )
        return selectLogin == 0
    }
    fun validacaoLogin2(emailLog: String, senhaLog: String): Boolean {
        val selectLogin = jdbcTemplate.queryForObject(
            "select count (*) from empresa where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Empresa::class.java), emailLog, senhaLog
        )
        return selectLogin != null
    }



    fun isNumeric(telCad: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return telCad.matches(regex)
    }

    fun validaEmpresa1 (emailLog: String): Boolean {
        val valida = jdbcTemplate.queryForObject(
            "select count(*) from empresa where email = ?",
            Int::class.java, emailLog
        )
        return valida == 0
    }
    fun validaEmpresa2 (emailLog: String): Empresa {
        val valida = jdbcTemplate.queryForObject(
            "select * from empresa where email = ?",
            BeanPropertyRowMapper(Empresa::class.java), emailLog
        )
        return valida
    }
    fun novoExpediente(expediente: Expediente, empresa: Empresa){
        jdbcTemplate.update(
            """
            insert into expediente (HrEntrada, HrSaida, fk_empresa) values
            (?,?,?)
        """, expediente.HrEntrada, expediente.HrSaida, empresa.id
        )
    }
}











