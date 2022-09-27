package config
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    //Puxando as variáveis do nosso objeto para evitar a repetição de código na conexão do banco

    jdbcTemplate.execute("""
        create table Pais (
        id int auto_increment,
        nome varchar(25) not null,
        populacao int not null
        )
    """)

}