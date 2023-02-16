package config

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

class Conexao {

    fun getJdbcTemplate():JdbcTemplate {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
        dataSource.url = "jdbc:sqlserver://kotlin-na-azure.database.windows.net:1433;database=Kotlin"
        dataSource.username = "Admin-Kotlin"
        dataSource.password = "1sis@grupo5"

        val jdbcTemplate = JdbcTemplate(dataSource)
        return jdbcTemplate
    }
}