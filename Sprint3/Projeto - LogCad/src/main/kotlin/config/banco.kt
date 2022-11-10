package config
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    jdbcTemplate.execute("""
        
        create table Usuario (
        id int primary key identity (1,1),
        nome varchar (30),
        email varchar (30),
        tel varchar (11),
        senha varchar (20) 
        );
    """)

}