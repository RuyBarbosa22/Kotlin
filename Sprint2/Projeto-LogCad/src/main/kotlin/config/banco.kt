package config
fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()

    jdbcTemplate.execute("""
        
        create table if not exists Usuario (
        id int primary key auto_increment,
        nome varchar (30),
        email varchar (30),
        tel varchar (11),
        senha varchar (20) 
        );
        
        insert into Usuario (nome, email, tel, senha) values
        ('Ruy', 'ruy@gmail.com', '11946706513', '123');
    """)

}