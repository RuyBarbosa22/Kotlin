import com.github.britooo.looca.api.core.Looca
import com.microsoft.sqlserver.jdbc.StringUtils
import config.Conexao
import dominio.Empresa
import dominio.Expediente
import dominio.Usuario
import dominio.componentes.CPU
import dominio.componentes.Disco
import dominio.componentes.Maquina
import dominio.componentes.RAM
import repositorio.ComponentesRepository
import repositorio.EmpresaRepository
import repositorio.UsuarioRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.JOptionPane
import kotlin.concurrent.schedule

fun getRandomString(length: Int): String {
    val charset = "0123456789"
    return (1..length).map { charset.random() }.joinToString("")
}

fun monitorarComponentes(maquina: Maquina) {

    println(maquina)
    println("dentro de monitorarComponentes()")

    println(maquina)
    disco(maquina)
    cpu(maquina)
    ram(maquina)
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

fun cadastroUsuario(empresa: Empresa) {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val usuarioRepository = UsuarioRepository(jdbcTemplate)
    val empresaRepository = EmpresaRepository(jdbcTemplate)
    val usuario = Usuario()

    while (true) {
        val nomeCad = JOptionPane.showInputDialog("Nome").also { usuario.nome = it }.lowercase()
        if (nomeCad == "") {
            JOptionPane.showMessageDialog(null, "É necessário inserir um nome!")
        } else {
            break
        }
    }

    while (true) {
        val emailCad = JOptionPane.showInputDialog("Email").also { usuario.email = it }.lowercase()
        if (emailCad.indexOf("@") == -1) {
            JOptionPane.showMessageDialog(null, "Email inválido")
        } else if (emailCad.indexOf(".com") == -1) {
            JOptionPane.showMessageDialog(null, "Email inválido")
        } else {
            break
        }
    }

    while (true) {
        val telCad = JOptionPane.showInputDialog("Telefone").also { usuario.tel = it }
        if (telCad.length < 11) {
            JOptionPane.showMessageDialog(null, "Número incompleto")
        } else if (!empresaRepository.isNumeric(telCad)) {
            JOptionPane.showMessageDialog(null, "Apenas números")
        } else if (telCad.length > 11) {
            JOptionPane.showMessageDialog(null, "Número grande demais!")
        } else {
            break
        }
    }

    while (true) {
        val codEmpresaCad =
            JOptionPane.showInputDialog("Código da empresa").also { usuario.codEmpresa = it }.lowercase()
        if (codEmpresaCad == "") {
            JOptionPane.showMessageDialog(null, "Campo vazio!")
        } else if (codEmpresaCad.length < 5) {
            JOptionPane.showMessageDialog(null, "Código muito curto!")
        } else if (codEmpresaCad.length > 5) {
            JOptionPane.showMessageDialog(null, "Código muito longo!")
        } else if (usuarioRepository.validar2(usuario)) {
            usuario.fkEmpresa = empresa.id
        } else {
            JOptionPane.showMessageDialog(null, "Código inexistente")
        }
        break
    }


    while (true) {
        val senhaCad = JOptionPane.showInputDialog("Senha de acesso do usuário")
        val senha2Cad = JOptionPane.showInputDialog("Confirme a senha")
        if (senhaCad != senha2Cad) {
            JOptionPane.showMessageDialog(null, "Senhas diferentes!")
        } else {
            usuario.senha = senhaCad
            JOptionPane.showMessageDialog(
                null, """
                        Cadastro realizado com sucesso!
                    """.trimIndent()
            )
            UsuarioRepository(jdbcTemplate).cadUsuario(usuario)
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!")
            JOptionPane.showMessageDialog(null, "Redirecionando...")
            break
        }
    }
}

fun cadastroEmpresa() {

    val length = 5
    val randomString = getRandomString(length)
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val empresaRepository = EmpresaRepository(jdbcTemplate)
    val empresa = Empresa()

    while (true) {
        val nomeCad = JOptionPane.showInputDialog("Nome da empresa").also { empresa.nome = it }.lowercase()
        if (nomeCad == "") {
            JOptionPane.showMessageDialog(null, "É necessário inserir um nome!")
        } else {
            break
        }
    }

    while (true) {
        val emailCad = JOptionPane.showInputDialog("Email").also { empresa.email = it }.lowercase()
        if (emailCad.indexOf("@") == -1) {
            JOptionPane.showMessageDialog(null, "Email inválido")
        } else if (emailCad.indexOf(".com") == -1) {
            JOptionPane.showMessageDialog(null, "Email inválido")
        } else {
            break
        }
    }


    while (true) {
        val cnpjCad = JOptionPane.showInputDialog("CNPJ").also { empresa.cnpj = it }
        if (cnpjCad.length < 14) {
            JOptionPane.showMessageDialog(null, "Número incompleto")
        } else if (!empresaRepository.isNumeric(cnpjCad)) {
            JOptionPane.showMessageDialog(null, "Apenas números")
        } else if (cnpjCad.length > 14) {
            JOptionPane.showMessageDialog(null, "Muito grande! Digite apenas números.")
        } else {
            break
        }
    }

    while (true) {
        val cepCad = JOptionPane.showInputDialog("CEP").also { empresa.cep = it }
        if (cepCad.length < 8) {
            JOptionPane.showMessageDialog(null, "Número incompleto")
        } else if (!empresaRepository.isNumeric(cepCad)) {
            JOptionPane.showMessageDialog(null, "Apenas números")
        } else if (cepCad.length > 8) {
            JOptionPane.showMessageDialog(null, "Número grande demais!")
        } else {
            break
        }
    }

    while (true) {
        val estadoCad = JOptionPane.showInputDialog("Estado(UF)").also { empresa.estado = it }.lowercase()
        if (estadoCad == "") {
            JOptionPane.showMessageDialog(null, "É necessário inserir o estado!")
        } else {
            break
        }
    }

    while (true) {
        val telCad = JOptionPane.showInputDialog("Telefone").also { empresa.numero = it }
        if (telCad.length < 11) {
            JOptionPane.showMessageDialog(null, "Número incompleto")
        } else if (!empresaRepository.isNumeric(telCad)) {
            JOptionPane.showMessageDialog(null, "Apenas números")
        } else if (telCad.length > 11) {
            JOptionPane.showMessageDialog(null, "Número grande demais!")
        } else {
            break
        }
    }

    while (true) {
        val senhaCad = JOptionPane.showInputDialog("Senha de acesso")
        val senha2Cad = JOptionPane.showInputDialog("Confirme a senha")
        if (senhaCad != senha2Cad) {
            JOptionPane.showMessageDialog(null, "Senhas diferentes!")
        } else {
            empresa.senha = senhaCad
            empresa.codEmpresa = randomString
            JOptionPane.showMessageDialog(
                null, """
                        Cadastro realizado com sucesso!
                        Esse é seu código empresarial: $randomString
                        Guarde-o pois é necessário para demais funcionalidades
                    """.trimIndent()
            )
            EmpresaRepository(jdbcTemplate).cadastro(empresa)
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!")
            JOptionPane.showMessageDialog(null, "Redirecionando...")
            break
        }

    }
}

fun loginEmpresa() {

    while (true) {
        val jdbcTemplate = Conexao().getJdbcTemplate()
        var empresa = Empresa()
        var maquina = Maquina()
        val empresaRepository = EmpresaRepository(jdbcTemplate)

        val emailLog = JOptionPane.showInputDialog("Email:").lowercase()
        val senhaLog = JOptionPane.showInputDialog("Senha de acesso:")
        if (!empresaRepository.validacaoLogin1(emailLog, senhaLog)) {
            val autenticado = empresaRepository.validacaoLogin2(emailLog, senhaLog)
            if (autenticado) {
                if (!empresaRepository.validaEmpresa1(emailLog)) {
                    empresa = empresaRepository.validaEmpresa2(emailLog)
                    println(empresa)
                    println("Login Empresa")
                } else {
                    println("erro na validação de existencia de empresa")
                }
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso")
                JOptionPane.showMessageDialog(null, "Bem vindo de volta ${empresa.nome}!")

                val componentes = ComponentesRepository(jdbcTemplate)
                val looca = Looca()
                val id = looca.processador.id

                if (!componentes.validaMaquina4(id)) {
                    val teste = componentes.identificaMaquina(id)
                    println(teste)
                    maquina = teste
                    println("minha maquina")
                    println(maquina)
                }

                while (true) {
                    val resp = JOptionPane.showInputDialog(
                        """
                        Oque deseja fazer?
                        1 - Monitorar Hardware
                        2 - Cadastrar usuários
                        3 - Cadastrar Máquinas
                        4 - Registrar expediente
                        5 - Logout
            """.trimIndent()
                    )

                    when (resp) {
                        "1" -> monitorar(maquina, empresa)
                        "2" -> cadastroUsuario(empresa)
                        "3" -> cadastroMaquina(empresa)
                        "4" -> cadastroExpediente(empresa)
                        else -> return
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "credenciais inválidas")
            }
        } else {
            JOptionPane.showMessageDialog(
                null, """
                            Credenciais inválidas!
                        """.trimIndent()
            )
            return
        }
    }
}

fun cadastroExpediente(empresa: Empresa) {

    val expediente = Expediente()

    while (true) {
        JOptionPane.showMessageDialog(
            null, """
                    Vamos definir o horário de expediente!
                       Lembre-se de usar o formato 24h
                        Digite os horários a seguir
                """.trimIndent()
        )

        var hora1: String
        var hora2: String
        var minuto1: String
        var minuto2: String

        while (true) {
            hora1 = JOptionPane.showInputDialog(
                """
                Hora de entrada:
            """.trimIndent()
            )

            if (StringUtils.isNumeric(hora1)) {
                break
            } else if (hora1.length > 2 || hora1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Valor inválido")
            } else {
                JOptionPane.showMessageDialog(null, "Apenas a hora! (número)")
            }
        }

        while (true) {
            minuto1 = JOptionPane.showInputDialog(
                """
                        Minuto de entrada:
                    """.trimIndent()
            )

            if (StringUtils.isNumeric(minuto1)) {
                break
            } else if (minuto1.length > 2 || minuto1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Valor inválido")
            } else {
                JOptionPane.showMessageDialog(null, "Apenas o minuto! (número)")
            }
        }

        JOptionPane.showMessageDialog(
            null, """
                O horário de entrada será:
                    ${hora1}:${minuto1}:00
                 """.trimIndent()
        )

        JOptionPane.showMessageDialog(
            null, """
                Vamos definir o horário de saida.
                 Lembre-se de usar o formato 24h
                """.trimIndent()
        )

        while (true) {
            hora2 = JOptionPane.showInputDialog(
                """
                    Hora de saída:
                """.trimIndent()
            )

            if (StringUtils.isNumeric(hora2)) {
                break
            } else if (hora2.length > 2 || hora2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Valor inválido")
            } else {
                JOptionPane.showMessageDialog(null, "Apenas a hora! (número)")
            }
        }

        while (true) {
            minuto2 = JOptionPane.showInputDialog(
                """
                    Minuto de saída:
                """.trimIndent()
            )

            if (StringUtils.isNumeric(minuto2)) {
                break
            } else if (minuto2.length > 2 || minuto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Valor inválido")
            } else {
                JOptionPane.showMessageDialog(null, "Apenas o minuto! (número)")
            }
        }

        while (true) {
            val resp1 = JOptionPane.showInputDialog(
                """
                    O horário de espediente será: 
                    Entrada: $hora1:$minuto1:00
                    Saída: $hora2:$minuto2:00
                    
                    Deseja salvar alterações?
                    1 - Salvar
                    2 - Cancelar
                    
                """.trimIndent()
            ).toInt()

            if (resp1 == 1) {
                JOptionPane.showMessageDialog(null, "Salvando...")
                return
            } else if (resp1 == 2) {
                JOptionPane.showMessageDialog(null, "n salva")
            } else {
                JOptionPane.showMessageDialog(null, "Resposta inválida!")
            }
        }


    }
}


fun cadastroMaquina(empresa: Empresa) {

    //imports de classe e jdbc
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val componentes = ComponentesRepository(jdbcTemplate)

    // Looca
    val looca = Looca()
    val loocaRam = looca.memoria
    val loocaCPU = looca.processador
    val loocaDisco = looca.grupoDeDiscos

    // MÁQUINA
    val loocaPc = looca.sistema
    val maquina = Maquina()

    println(empresa)
    println("Cadastro Maquina")

    maquina.serialNumber = loocaCPU.id
    maquina.sistema_operacional = loocaPc.sistemaOperacional
    maquina.cpu_nucleos_fisicos = loocaCPU.numeroCpusFisicas
    maquina.cpu_nucleos_logicos = loocaCPU.numeroCpusLogicas
    maquina.disco_total = loocaDisco.tamanhoTotal.toDouble() / 1024 / 1024 / 1024
    maquina.memoria_total = loocaRam.total.toDouble() / 1024 / 1024 / 1024
    maquina.fk_empresa = empresa.id

    JOptionPane.showMessageDialog(null, "Aguarde...")
    if (!componentes.validaMaquina2(maquina) || componentes.validaMaquina3(maquina)) {
        JOptionPane.showMessageDialog(
            null, """
                    Máquina já cadastrada!
                """.trimIndent()
        )
        return
    } else {
        componentes.inserirMaquina(maquina)
        JOptionPane.showMessageDialog(null, "Cadastro realizado!")
    }

}

fun loginUsuario() {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val usuario = Usuario()
    val usuarioRepository = UsuarioRepository(jdbcTemplate)
    var emailLog: String
    var maquina = Maquina()

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

                            val componentes = ComponentesRepository(jdbcTemplate)
                            val looca = Looca()
                            val id = looca.processador.id

                            if (!componentes.validaMaquina4(id)) {
                                maquina = componentes.identificaMaquina(id)
                                println(maquina)
                            }

                            while (true) {
                                val escolha3 = JOptionPane.showInputDialog(
                                    """
                                    Bem vindo de volta!
                                    Oque deseja fazer?
                                    1 - Monitorar
                                    2 - sair
                                """.trimIndent()
                                )

                                when (escolha3) {
                                    "1" -> monitorarUser(maquina)
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

fun monitorar(maquina: Maquina, empresa: Empresa) {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val componentes = ComponentesRepository(jdbcTemplate)
    val looca = Looca()

    val idMachine: String
    idMachine = looca.processador.id
    println(idMachine)
    println("Dentro de monitorar")

    if (componentes.validaMaquina4(idMachine)) {
        JOptionPane.showMessageDialog(
            null, """
                    Máquina não cadastrada!
                    Vamos cadastra-lá...
                """.trimIndent()
        )
        cadastroMaquina(empresa)
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

fun monitorarUser(maquina: Maquina) {

    val jdbcTemplate = Conexao().getJdbcTemplate()
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

