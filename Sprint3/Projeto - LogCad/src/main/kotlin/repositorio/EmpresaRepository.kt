package repositorio

import dominio.Empresa
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

    fun validacaoLogin(emailLog: String, senhaLog: String): Boolean {
        val selectLogin = jdbcTemplate.queryForObject(
            "select * from empresa where email = ? and senha = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Empresa::class.java), emailLog, senhaLog
        )
        return selectLogin != null
    }



    fun isNumeric(telCad: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return telCad.matches(regex)
    }


    fun validaFk (codEmpresaCad: String): Empresa? {
        val valida = jdbcTemplate.queryForObject(
            "select * from empresa where codEmpresa = ?",
            BeanPropertyRowMapper(Empresa::class.java), codEmpresaCad
        )
        return valida
    }
}





