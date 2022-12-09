package app

import app.dominio.componentes.CPU
import app.dominio.componentes.Disco
import com.github.britooo.looca.api.core.Looca
import com.lordcodes.turtle.shellRun
import com.microsoft.sqlserver.jdbc.StringUtils
import config.Conexao
import dominio.Usuario
import app.dominio.componentes.Maquina
import app.dominio.componentes.RAM
import repositorio.ComponentesRepository
import repository.UserRepository
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.JOptionPane
import kotlin.concurrent.schedule

fun main() {

    fun verExpediente() {

    }

    fun disco(maquina: Maquina) {

        //imports de classe e jdbc
        val jdbcTemplate = Conexao().getJdbcTemplate()
        val componentes = ComponentesRepository(jdbcTemplate)

        // Variaveis para inserção de data/hora
        val agora = LocalDateTime.now()
        val formatoDH = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        val agoraBonito = agora.format(formatoDH)

        val looca = Looca()

        // DISCO
        val loocaDisco = looca.grupoDeDiscos
        val disco = Disco()
        disco.qtdDisco = loocaDisco.quantidadeDeDiscos
        disco.totalDisco = loocaDisco.tamanhoTotal.toDouble() / 1024 / 1024 / 1024
        disco.dataHora = agoraBonito
        disco.fk_computador = maquina.id
        componentes.inserirDisco(disco)
    }

    fun cpu(maquina: Maquina) {

        //imports de classe e jdbc
        val jdbcTemplate = Conexao().getJdbcTemplate()
        val componentes = ComponentesRepository(jdbcTemplate)

        // Variaveis para inserção de data/hora
        val agora = LocalDateTime.now()
        val formatoDH = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        val agoraBonito = agora.format(formatoDH)

        val looca = Looca()

        // CPU
        val loocaCPU = looca.processador
        val cpu = CPU()
        cpu.freqUsoCpu = loocaCPU.frequencia.toDouble() / 1024 / 1024 / 1024
        cpu.pctUsoCpu = loocaCPU.uso
        cpu.dataHora = agoraBonito
        cpu.fk_computador = maquina.id
        componentes.inserirCpu(cpu)
    }

    fun ram(maquina: Maquina) {

        //imports de classe e jdbc
        val jdbcTemplate = Conexao().getJdbcTemplate()
        val componentes = ComponentesRepository(jdbcTemplate)

        // Variaveis para inserção de data/hora
        val agora = LocalDateTime.now()
        val formatoDH = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
        val agoraBonito = agora.format(formatoDH)

        val looca = Looca()

        // RAM
        val loocaRam = looca.memoria
        val ram = RAM()
        ram.usadoRam = loocaRam.emUso.toDouble() / 1024 / 1024 / 1024
        ram.livreRam = loocaRam.total - loocaRam.emUso.toDouble() / 1024 / 1024 / 1024
        ram.totalRam = loocaRam.total.toDouble() / 1024 / 1024 / 1024
        ram.dataHora = agoraBonito
        ram.fk_computador = maquina.id
        componentes.inserirRam(ram)
    }

    fun monitorarComponentes(maquina: Maquina) {

        println(maquina)
        println("dentro de monitorarComponentes()")

        println(maquina)
        disco(maquina)
        cpu(maquina)
        ram(maquina)
    }

    fun monitorarUser() {

        val jdbcTemplate = Conexao().getJdbcTemplate()
        val looca = Looca()
        val maquina = Maquina()
        maquina.serialNumber = looca.processador.id
        val componentes = ComponentesRepository(jdbcTemplate)

        if (componentes.validaMaquina(maquina)) {
            JOptionPane.showMessageDialog(
                null, """
                        Seu computador não esta cadastrado!
                    Peça para que um administrador da sua empresa 
                               cadastre sua máquina.
                    """.trimIndent()
            )
            return
        } else {

            var resp = JOptionPane.showInputDialog(
                """
                Unidade de medida de tempo:
                1 - segundos
                2 - minutos
                3 - horas
            """.trimIndent()
            )

            while (true) {
                if (resp == "1") {
                    resp = "segundos"
                    break
                } else if (resp == "2") {
                    resp = "minutos"
                    break
                } else if (resp == "3") {
                    resp = "horas"
                    break
                } else {
                    JOptionPane.showMessageDialog(null, "Opção inválida!")
                }
            }

            var resp2 = JOptionPane.showInputDialog(
                """
                        De quantos em quantos $resp você deseja gravar
                        os dados das máquinas?
                    """.trimIndent()
            ).toLong()

            while (true) {
                if (resp == "segundos") {
                    resp2 *= 1000
                    break
                } else if (resp == "minutos") {
                    resp2 = (resp2 * 60) * 1000
                    break
                } else if (!StringUtils.isNumeric(resp2.toString())) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!")
                } else {
                    resp2 = ((resp2 * 60) * 60) * 1000
                    break
                }
            }

            val resp3 = JOptionPane.showInputDialog(
                """
                Quantas vezes deseja monitorar?
            """.trimIndent()
            ).toInt()

            while (true) {
                if (!StringUtils.isNumeric(resp3.toString())) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!")
                } else if (resp3 < 1) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!")
                } else {
                    break
                }
            }

            fun monitorar(repeticao: Int, realizados: Int) {
                if (realizados < repeticao) {
                    monitorarComponentes(maquina)
                    Timer().schedule(resp2) {
                        monitorar(repeticao, realizados + 1)
                    }
                }
            }
            monitorar(resp3, 0)
        }
    }


    fun loginUsuario() {

        val jdbcTemplate = Conexao().getJdbcTemplate()
        val usuario = Usuario()
        val usuarioRepository = UserRepository(jdbcTemplate)
        var emailLog: String

        while (true) {
            while (true) {
                emailLog = JOptionPane.showInputDialog("Email:").also { usuario.email = it }.lowercase()
                if (emailLog.indexOf("@") == -1) {
                    JOptionPane.showMessageDialog(null, "Email inválido")
                } else if (emailLog.indexOf(".com") == -1) {
                    JOptionPane.showMessageDialog(null, "Email inválido")
                } else {
                    break
                }
            }

            while (true) {
                val senha = JOptionPane.showInputDialog("Senha de acesso").also { usuario.senha = it }
                if (usuarioRepository.validacaoLogin1(emailLog, senha)) {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas!")
                    return
                } else {
                    val autenticado: Boolean = usuarioRepository.validacaoLogin2(emailLog, senha)
                    if (autenticado) {
                        usuario.codEmpresa = JOptionPane.showInputDialog("Código da empresa:")
                        if (!usuarioRepository.validar1(usuario)) {
                            val autenticado2 = usuarioRepository.validar2(usuario)
                            if (autenticado2) {
                                while (true) {
                                    val escolha3 = JOptionPane.showInputDialog(
                                        """
                                    Bem vindo de volta!
                                    Oque deseja fazer?
                                    1 - Monitorar
                                    2 - Verificar Expediente
                                    3 - sair
                                """.trimIndent()
                                    )

                                    when (escolha3) {
                                        "1" -> monitorarUser()
                                        "2" -> verExpediente()
                                        else -> return
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Código empresarial incorreto!")
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                null, """
                                Credenciais inválidas!
                            """.trimIndent()
                            )
                        }

                    }
                }
            }
        }
    }
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val repository = UserRepository(jdbcTemplate)
    val diaSemana = LocalDate.now().dayOfWeek.value // Dia da semana (1-7)
    val horaAtual =  LocalDateTime.now() // Data e hora atual

    val formatoHour = DateTimeFormatter.ofPattern("HH:mm:ss")
    val formatoDay = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

    println(diaSemana)
    println(horaAtual.format(formatoHour))
    println(horaAtual.format(formatoDay))


    shellRun("MSG", listOf<String>("* ", "Aviso, ", "você está fora do horario de funcionamento!"), null)
    shellRun("MSG", listOf<String>("* ", "Um alerta será gerado e a máquina será encerrada em poucos segundos"), null)
    shellRun("shutdown", listOf<String>("/s", "/t", "100"), null)


}

