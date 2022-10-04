package config
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    //Puxando as variáveis do nosso objeto para evitar a repetição de código na conexão do banco

    jdbcTemplate.execute("""
        create table Carro (
        id int auto_increment,
        modelo varchar(25) not null,
        ano int not null,
        potencia decimal(5,1) not null
        )
    """)

}