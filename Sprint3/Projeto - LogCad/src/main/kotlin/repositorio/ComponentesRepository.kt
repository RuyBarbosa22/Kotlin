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
            insert into cpu_dinamica_kotlin (pct_uso, freq_uso, dataHora) values
            (?,?,?)
        """, cpu.pctUsoCpu, cpu.freqUsoCpu, cpu.dataHora
        )
    }

    fun inserirRam(ram: RAM){
        jdbcTemplate.update(
            """
            insert into memoria_dinamica_kotlin (mem_total, mem_usando, mem_livre, dataHora) values
            (?,?,?,?)
        """, ram.totalRam, ram.usadoRam, ram.livreRam, ram.dataHora
        )
    }

    fun inserirDisco(disco: Disco){
        jdbcTemplate.update(
            """
            insert into disco_dinamico_kotlin (total, qtdDisco, dataHora) values
            (?,?,?)
        """, disco.totalDisco, disco.qtdDisco, disco.dataHora
        )
    }

    fun inserirMaquina(maquina: Maquina){
        jdbcTemplate.update(
            """
            insert into computador_kotlin (sistema_operacional, disco_total, cpu_nucleos_logicos, cpu_nucleos_fisicos, memoria_total) values
            (?,?,?,?,?)
        """, maquina.SO, maquina.totalDisco, maquina.nucleoL, maquina.nucleoF, maquina.totalRam
        )
    }
    }
