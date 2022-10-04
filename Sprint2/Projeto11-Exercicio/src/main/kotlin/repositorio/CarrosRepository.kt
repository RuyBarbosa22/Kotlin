package repositorio


import dominio.Carro
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import java.beans.BeanProperty

class CarrosRepository(val jdbcTemplate: JdbcTemplate) {

    fun inserir(carro: Carro){
        jdbcTemplate.update("""
            insert into Carro (modelo,ano,potencia) values
            (?,?,?)
        """, carro.modelo, carro.ano, carro.potencia)
    }

    fun Listar():List<Carro> {
        return jdbcTemplate.query("select * from Carro",
            BeanPropertyRowMapper(Carro::class.java))
    }

    fun selectEspecifico(rever:Int):Boolean {
        val carro = jdbcTemplate.queryForObject(
            "select * from Carro where id = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Carro::class.java),rever)
        return carro != null
    }

        fun select(rever:Int):Carro {
            val select = jdbcTemplate.queryForObject(
                "select * from Carro where id = ?",  // "?" será substituido pelo id
                BeanPropertyRowMapper(Carro::class.java), rever
            )
            return select
        }


    fun selectOrdenado():Carro {
        val select = jdbcTemplate.queryForObject(
            "select * from Carro where ano >= 2019 order by potencia",
            BeanPropertyRowMapper(Carro::class.java)
        )
        return select
    }

    fun selectOrdenado2():Carro {
        val select = jdbcTemplate.queryForObject(
            "select * from Carro where ano >= 2019 and potencia > 1.5, order by potencia",
            BeanPropertyRowMapper(Carro::class.java)
        )
        return select
    }
}