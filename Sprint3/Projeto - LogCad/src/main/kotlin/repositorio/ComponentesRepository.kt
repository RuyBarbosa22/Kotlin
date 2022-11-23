package repositorio

import dominio.Empresa
import dominio.Usuario
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
            insert into dbo.computador_kotlin (serialNumber, sistema_operacional, disco_total, cpu_nucleos_logicos, cpu_nucleos_fisicos, memoria_total, fk_empresa) values
            (?,?,?,?,?,?,?)
        """,  maquina.id, maquina.SO, maquina.totalDisco, maquina.nucleoL, maquina.nucleoF, maquina.totalRam, maquina.fk_empresa
        )
    }

    fun validaMaquina(maquina: Maquina): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select count (*) from computador_kotlin where serialNumber = ?",
            BeanPropertyRowMapper(Int::class.java), maquina.id
        )
        return validaCod == 0
    }

    fun existeVerificaEmpresa(empresa: Empresa): Boolean {
        val validaCod = jdbcTemplate.queryForObject(
            "select count(*) from computador_kotlin where serialNumber = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Int::class.java), empresa.id
        )

        return validaCod == 1
    }
    fun verificaEmpresa(empresa: Empresa): Maquina? {
        return jdbcTemplate.queryForObject(
            "select * from computador_kotlin where serialNumber = ?",  // "?" será substituido pelo id
            BeanPropertyRowMapper(Maquina::class.java), empresa.id
        )
    }

    }
