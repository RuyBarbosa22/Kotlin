package repositorio

import dominio.Pais
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import java.beans.BeanProperty

class PaisRepository(val jdbcTemplate: JdbcTemplate) {

    fun inserir(pais: Pais){
        jdbcTemplate.update("""
            insert into Pais (nome,populacao) values
            ('${pais.nome}', ${pais.populacao})
        """)
    }

    fun excluirTodos() {
        jdbcTemplate.update("delete from Pais")
    }

    fun Listar():List<Pais> {
        return jdbcTemplate.query("select * from Pais",
                    BeanPropertyRowMapper(Pais::class.java))
    }

    fun recuperar(id:Int):Pais {
        val pais = jdbcTemplate.queryForObject(
            "select * from Pais where id = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Pais::class.java),id)
                return pais
    }

    fun excluir(id:Int):Int {
        val excluidos = jdbcTemplate.update("delete from Pais where id = ?", id)
            return excluidos

    }

}