import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

fun main() {
    val dataSource = BasicDataSource()

    val jdbcTemplate = JdbcTemplate(dataSource)

    // Aqui fazemos a conexãoc com o banco, e passamos as credênciais
    dataSource.driverClassName = "org.h2.Driver" // nome do banco
    dataSource.url = "jdbc:h2:C:\\Users\\Aluno\\Documents\\Yoshi\\Projeto8 -JDBC01\\MeuBancoH2"  //Caminho/localização do banco
    dataSource.username = "sa" // nome de usuário
    dataSource.password = "" // senha de acesso

    // método update() -> para executar apenas DML (insert, update, delete)
    // caso atribuido a uma variavel, a variável recebe um número de linhas afetadas (Int)
    val linhasAfetadas =  jdbcTemplate.update("""
        insert into DbMusica (id, nome) values
        (1,'Ruy'), (2,'Hugo'), (3,'Felps')
    """)

    println("$linhasAfetadas linhas inseridas")


}