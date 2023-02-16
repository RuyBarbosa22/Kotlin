package repositorio

import dominio.componentes.CPU
import dominio.componentes.Disco
import dominio.componentes.Maquina
import dominio.componentes.RAM
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class ComponentesRepository(val jdbcTemplate: JdbcTemplate) {

    fun inserirCpu(cpu: CPU) {
        jdbcTemplate.update(
            """
            insert into dbo.cpu_dinamica_kotlin (pct_uso, freq_uso, dataHora, fk_computador) values
            (?,?,?,?)
        """, cpu.pctUsoCpu, cpu.freqUsoCpu, cpu.dataHora, cpu.fk_computador
        )
    }

    fun inserirRam(ram: RAM) {
        jdbcTemplate.update(
            """
            insert into dbo.memoria_dinamica_kotlin (mem_total, mem_usando, mem_livre, dataHora, fk_computador) values
            (?,?,?,?,?)
        """, ram.totalRam, ram.usadoRam, ram.livreRam, ram.dataHora, ram.fk_computador
        )
    }

    fun inserirDisco(disco: Disco) {
        jdbcTemplate.update(
            """
            insert into dbo.disco_dinamico_kotlin (total, qtdDisco, dataHora, fk_computador) values
            (?,?,?,?)
        """, disco.totalDisco, disco.qtdDisco, disco.dataHora, disco.fk_computador
        )
    }

    fun validaMaquina(maquina: Maquina): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select count (*) from computador_kotlin where serialNumber = ?",
            Int::class.java, maquina.serialNumber
        )
        return validaCod == 0
    }

    fun identificaMaquina(idMachine: String): Maquina {
        val identificaMaquina = jdbcTemplate.queryForObject(
            "select * from [dbo].[computador_kotlin] where [dbo].[computador_kotlin].serialNumber = ?",
            BeanPropertyRowMapper(Maquina::class.java), idMachine
        )
        return identificaMaquina
    }
}