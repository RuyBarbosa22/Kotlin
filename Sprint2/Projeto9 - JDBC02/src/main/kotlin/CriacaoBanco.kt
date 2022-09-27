
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    //Puxando as variáveis do nosso objeto para evitar a repetição de código na conexão do banco

    jdbcTemplate.execute("""
        create table pokemon (
        id int primary key,
        nome varchar(40),
        forca decimal  (5,0),
        solto boolean
        )
    """)

}