import org.springframework.jdbc.core.BeanPropertyRowMapper
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {

    for (i in 1..3){
        var nomePoke = showInputDialog("Nome do Pokemon")
        var forcaPoke = showInputDialog("Nível de força").toDouble()
        var respostaSolto = showInputDialog("Ele está solto? \r\n 1 - Sim \r\n 2 - Não").toInt()
        var soltoPoke: Boolean = false

        soltoPoke = respostaSolto == 1

        Pokemon(i, nomePoke, forcaPoke, soltoPoke)

        val jdbcTemplate = Conexao().getJdbcTemplate()
        val pokemonsInseridos = jdbcTemplate.update("""
            insert into pokemon (id, nome, forca, solto) 
            values
            (${i}, '${nomePoke}', ${forcaPoke}, ${soltoPoke})
        """)

        val pokemons = jdbcTemplate.queryForList("select * from pokemon")

        println(pokemons)


        val listaPokemons:List<Pokemon> = jdbcTemplate.query(
            "select * from pokemon",
            BeanPropertyRowMapper(Pokemon::class.java)
        )
        listaPokemons.forEach {
            showMessageDialog(null, "pokemon ${it.id} /r/n ${it.nome} /r/n ${it.forca} /r/n ${if (it.solto) "Sim" else "Não"}")
        }


    }

}