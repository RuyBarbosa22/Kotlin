package repositorio

import dominio.Empresa
import dominio.componentes.CPU
import dominio.componentes.Disco
import dominio.componentes.Maquina
import dominio.componentes.RAM
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class ComponentesRepository(val jdbcTemplate: JdbcTemplate) {

    fun inserirCpu(cpu: CPU){
        jdbcTemplate.update(
            """
            insert into dbo.cpu_dinamica_kotlin (pct_uso, freq_uso, dataHora, fk_computador_kotlin) values
            (?,?,?,?)
        """, cpu.pctUsoCpu, cpu.freqUsoCpu, cpu.dataHora, 201
        )
    }

    fun inserirRam(ram: RAM){
        jdbcTemplate.update(
            """
            insert into dbo.memoria_dinamica_kotlin (mem_total, mem_usando, mem_livre, dataHora, fk_computador_kotlin) values
            (?,?,?,?,?)
        """, ram.totalRam, ram.usadoRam, ram.livreRam, 201
        )
    }

    fun inserirDisco(disco: Disco){
        jdbcTemplate.update(
            """
            insert into dbo.disco_dinamico_kotlin (total, qtdDisco, dataHora, fk_computador_kotlin) values
            (?,?,?,?)
        """, disco.totalDisco, disco.qtdDisco, 201
        )
    }

    fun inserirMaquina(maquina: Maquina){
        jdbcTemplate.update(
            """
            insert into dbo.computador_kotlin (sistema_operacional, disco_total, cpu_nucleos_logicos, cpu_nucleos_fisicos, memoria_total, fk_empresa) values
            (?,?,?,?,?,?)
        """, maquina.SO, maquina.totalDisco, maquina.nucleoL, maquina.nucleoF, maquina.totalRam, 1
        )
    }
    }
