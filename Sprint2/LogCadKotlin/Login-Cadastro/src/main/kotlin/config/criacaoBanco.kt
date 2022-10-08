package config
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    //Criando banco e tabela de Usuário

    jdbcTemplate.execute("""
        create table Usuario (
        id int primary key auto_increment,
        nome varchar (30) not null,
        email varchar (30) not null unique,
        tel varchar (11) not null unique,
        senha varchar (20) not null
        );
    """)

}