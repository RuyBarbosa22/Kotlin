package config

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

class Conexao {
    val driverClassName = "org.h2.Driver"
    val url = "jdbc:h2:./banco-Log-Cad"
    val username = "grupo5"
    val password = "GHR2022"

    fun getJdbcTemplate():JdbcTemplate {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = driverClassName
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password
        val jdbcTemplate = JdbcTemplate(dataSource)
        return jdbcTemplate
    }
}