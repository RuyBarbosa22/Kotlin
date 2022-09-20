import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

fun main() {
    val dataSource = BasicDataSource()

    // Aqui fazemos a conexãoc com o banco, e passamos as credênciais
    dataSource.driverClassName = "org.h2.Driver" // nome do banco
    dataSource.url = "jdbc:h2:C:\\Users\\Aluno\\Documents\\Yoshi\\Projeto8 -JDBC01\\MeuBancoH2"  //Caminho/localização do banco
    dataSource.username = "sa" // nome de usuário
    dataSource.password = "" // senha de acesso

    // Os valores de "URL" e "driverClassName" são fornecidos na documentação do banco de dados (JDBC)

    val jdbcTemplate = JdbcTemplate(dataSource)

    // método execute() -> executa qualquer tipo de instrução SQL
    // Se existir mais de uma instrução (create/insert) é necessário usar o ";" no final da instrução
    jdbcTemplate.execute("""
        create table DbMusica (
            id int primary key,
            nome varchar(20) not null
        )
    """)

}