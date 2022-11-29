package app

import com.github.britooo.looca.api.core.Looca
import com.microsoft.sqlserver.jdbc.StringUtils.isNumeric
import config.Conexao
import dominio.Empresa
import dominio.Usuario
import dominio.componentes.CPU
import dominio.componentes.Disco
import dominio.componentes.Maquina
import dominio.componentes.RAM
import repositorio.ComponentesRepository
import repositorio.EmpresaRepository
import repositorio.UsuarioRepository
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog
import kotlin.concurrent.schedule
import kotlin.reflect.typeOf

open class Main {
    companion object {

        fun getRandomString(length: Int): String {
            val charset = "0123456789"
            return (1..length)
                .map { charset.random() }
                .joinToString("")
        }

        fun monitorarComponentes(maquina: Maquina) {

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
            componentes.inserirRam(ram)
        }

        fun cadastroUsuario() {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val usuarioRepository = UsuarioRepository(jdbcTemplate)
            val empresaRepository = EmpresaRepository(jdbcTemplate)
            val usuario = Usuario()

            while (true) {
                val nomeCad = showInputDialog("Nome").also { usuario.nome = it }.lowercase()
                if (nomeCad == "") {
                    showMessageDialog(null, "É necessário inserir um nome!")
                } else {
                    break
                }
            }

            while (true) {
                val emailCad = showInputDialog("Email").also { usuario.email = it }.lowercase()
                if (emailCad.indexOf("@") == -1) {
                    showMessageDialog(null, "Email inválido")
                } else if (emailCad.indexOf(".com") == -1) {
                    showMessageDialog(null, "Email inválido")
                } else {
                    break
                }
            }

            while (true) {
                val telCad = showInputDialog("Telefone").also { usuario.tel = it }
                if (telCad.length < 11) {
                    showMessageDialog(null, "Número incompleto")
                } else if (!empresaRepository.isNumeric(telCad)) {
                    showMessageDialog(null, "Apenas números")
                } else if (telCad.length > 11) {
                    showMessageDialog(null, "Número grande demais!")
                } else {
                    break
                }
            }

            while (true) {
                val codEmpresaCad = showInputDialog("Código da empresa").also { usuario.codEmpresa = it }.lowercase()
                if (codEmpresaCad == "") {
                    showMessageDialog(null, "Campo vazio!")
                } else if (codEmpresaCad.length < 5) {
                    showMessageDialog(null, "Código muito curto!")
                } else if (codEmpresaCad.length > 5) {
                    showMessageDialog(null, "Código muito longo!")
                } else if (usuarioRepository.validar(usuario)) {
                    val empresa = empresaRepository.validaFk(codEmpresaCad)
                    print(empresa)
                    if (empresa != null) {
                        usuario.fkEmpresa = empresa
                    } else {
                        showMessageDialog(null, "Código inexistente")
                    }
                    break
                } else {
                    showMessageDialog(null, "Código inesxistente")
                }
            }

            while (true) {
                val senhaCad = showInputDialog("Senha de acesso")
                val senha2Cad = showInputDialog("Confirme a senha")
                if (senhaCad != senha2Cad) {
                    showMessageDialog(null, "Senhas diferentes!")
                } else {
                    usuario.senha = senhaCad
                    showMessageDialog(
                        null, """
                        Cadastro realizado com sucesso!
                    """.trimIndent()
                    )
                    UsuarioRepository(jdbcTemplate).cadUsuario(usuario)
                    showMessageDialog(null, "Cadastro realizado com sucesso!")
                    showMessageDialog(null, "Redirecionando...")
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
                val nomeCad = showInputDialog("Nome da empresa").also { empresa.nome = it }.lowercase()
                if (nomeCad == "") {
                    showMessageDialog(null, "É necessário inserir um nome!")
                } else {
                    break
                }
            }

            while (true) {
                val emailCad = showInputDialog("Email").also { empresa.email = it }.lowercase()
                if (emailCad.indexOf("@") == -1) {
                    showMessageDialog(null, "Email inválido")
                } else if (emailCad.indexOf(".com") == -1) {
                    showMessageDialog(null, "Email inválido")
                } else {
                    break
                }
            }


            while (true) {
                val cnpjCad = showInputDialog("CNPJ").also { empresa.cnpj = it }
                if (cnpjCad.length < 14) {
                    showMessageDialog(null, "Número incompleto")
                } else if (!empresaRepository.isNumeric(cnpjCad)) {
                    showMessageDialog(null, "Apenas números")
                } else if (cnpjCad.length > 14) {
                    showMessageDialog(null, "Muito grande! Digite apenas números.")
                } else {
                    break
                }
            }

            while (true) {
                val cepCad = showInputDialog("CEP").also { empresa.cep = it }
                if (cepCad.length < 8) {
                    showMessageDialog(null, "Número incompleto")
                } else if (!empresaRepository.isNumeric(cepCad)) {
                    showMessageDialog(null, "Apenas números")
                } else if (cepCad.length > 8) {
                    showMessageDialog(null, "Número grande demais!")
                } else {
                    break
                }
            }

            while (true) {
                val estadoCad = showInputDialog("Estado(UF)").also { empresa.estado = it }.lowercase()
                if (estadoCad == "") {
                    showMessageDialog(null, "É necessário inserir o estado!")
                } else {
                    break
                }
            }

            while (true) {
                val telCad = showInputDialog("Telefone").also { empresa.numero = it }
                if (telCad.length < 11) {
                    showMessageDialog(null, "Número incompleto")
                } else if (!empresaRepository.isNumeric(telCad)) {
                    showMessageDialog(null, "Apenas números")
                } else if (telCad.length > 11) {
                    showMessageDialog(null, "Número grande demais!")
                } else {
                    break
                }
            }

            while (true) {
                val senhaCad = showInputDialog("Senha de acesso")
                val senha2Cad = showInputDialog("Confirme a senha")
                if (senhaCad != senha2Cad) {
                    showMessageDialog(null, "Senhas diferentes!")
                } else {
                    empresa.senha = senhaCad
                    empresa.codEmpresa = randomString
                    showMessageDialog(
                        null, """
                        Cadastro realizado com sucesso!
                        Esse é seu código empresarial: $randomString
                        Guarde-o pois é necessário para demais funcionalidades
                    """.trimIndent()
                    )
                    EmpresaRepository(jdbcTemplate).cadastro(empresa)
                    showMessageDialog(null, "Cadastro realizado com sucesso!")
                    showMessageDialog(null, "Redirecionando...")
                    break
                }

            }
        }

        fun loginEmpresa() {

            while (true) {
                val jdbcTemplate = Conexao().getJdbcTemplate()
                var empresa = Empresa()
                val maquina = Maquina()
                val empresaRepository = EmpresaRepository(jdbcTemplate)

                val emailLog = showInputDialog("Email:").lowercase()
                val senhaLog = showInputDialog("Senha de acesso:")
                val autenticado = empresaRepository.validacaoLogin(emailLog, senhaLog)
                if (autenticado) {
                    if (!empresaRepository.validaEmpresa1(emailLog)) {
                        empresa = empresaRepository.validaEmpresa2(emailLog)
                        println(empresa)
                        println("Login Empresa")
                    } else {
                        println("erro na validação de existencia de empresa")
                    }
                    showMessageDialog(null, "Login realizado com sucesso")
                    showMessageDialog(null, "Bem vindo de volta ${empresa.nome}!")

                    while (true) {
                        val resp = showInputDialog(
                            """
                        Oque deseja fazer?
                        1 - Monitorar Hardware
                        2 - Cadastrar usuários
                        3 - Cadastrar Máquinas
                        4 - Logout
            """.trimIndent()
                        )

                        when (resp) {
                            "1" -> monitorar(maquina, empresa)
                            "2" -> cadastroUsuario()
                            "3" -> cadastroMaquina(empresa)
                            else -> return
                        }
                    }
                } else {
                    showMessageDialog(null, "credenciais inválidas")
                }
            }
        }

        fun cadastroMaquina(empresa: Empresa) {

            //imports de classe e jdbc
            val jdbcTemplate = Conexao().getJdbcTemplate()
            val componentes = ComponentesRepository(jdbcTemplate)

            // Variaveis para inserção de data/hora
            val agora = LocalDateTime.now()
            val formatoDH = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
            val agoraBonito = agora.format(formatoDH)

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
            maquina.SO = loocaPc.sistemaOperacional
            maquina.nucleoF = loocaCPU.numeroCpusFisicas
            maquina.nucleoL = loocaCPU.numeroCpusLogicas
            maquina.totalDisco = loocaDisco.tamanhoTotal.toDouble() / 1024 / 1024 / 1024
            maquina.totalRam = loocaRam.total.toDouble() / 1024 / 1024 / 1024
            maquina.fk_empresa = empresa.id

            showMessageDialog(null, "Aguarde...")
            if (!componentes.validaMaquina2(maquina, empresa)) {
                showMessageDialog(
                    null, """
                    Máquina já cadastrada!
                """.trimIndent()
                )
                return
            } else {
                componentes.inserirMaquina(maquina)
                showMessageDialog(null, "Cadastro realizado!")
            }

        }

        fun loginUsuario() {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val usuario = Usuario()
            val usuarioRepository = UsuarioRepository(jdbcTemplate)
            var emailLog: String

            while (true) {
                while (true) {
                    emailLog = showInputDialog("Email:").also { usuario.email = it }.lowercase()
                    if (emailLog.indexOf("@") == -1) {
                        showMessageDialog(null, "Email inválido")
                    } else if (emailLog.indexOf(".com") == -1) {
                        showMessageDialog(null, "Email inválido")
                    } else {
                        break
                    }
                }

                while (true) {
                    val senha = showInputDialog("Senha de acesso").also { usuario.email = it }
                    val autenticado: Boolean = usuarioRepository.validacaoLogin(emailLog, senha)
                    if (autenticado) {
                        usuario.codEmpresa = showInputDialog("Código da empresa:")
                        val autenticado2 = usuarioRepository.validar(usuario)
                        if (autenticado2) {
                            while (true) {
                                val escolha3 = showInputDialog(
                                    """
                                    Bem vindo de volta!
                                    Oque deseja fazer?
                                    1 - Monitorar
                                    2 - sair
                                """.trimIndent()
                                )

                                when (escolha3) {
                                    "1" -> monitorarUser()
                                    else -> break
                                }
                            }

                        } else {
                            showMessageDialog(null, "Código empresarial incorreto!")
                        }
                    } else {
                        showMessageDialog(null, "Credenciais inválidas!")
                    }

                }
            }
        }

        fun monitorar(maquina: Maquina, empresa: Empresa) {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val componentes = ComponentesRepository(jdbcTemplate)

            println(maquina)

            if (componentes.validaMaquina(maquina)) {
                showMessageDialog(
                    null, """
                    Máquina não cadastrada!
                    Vamos cadastra-lá...
                """.trimIndent()
                )
                cadastroMaquina(empresa)
            } else {

                var resp = showInputDialog(
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
                        showMessageDialog(null, "Opção inválida!")
                    }
                }

                var resp2 = showInputDialog(
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
                    } else if (!isNumeric(resp2.toString())) {
                        showMessageDialog(null, "Valor inválido!")
                    } else {
                        resp2 = ((resp2 * 60) * 60) * 1000
                        break
                    }
                }

                val resp3 = showInputDialog(
                    """
                Quantas vezes deseja monitorar?
            """.trimIndent()
                ).toInt()

                while (true) {
                    if (!isNumeric(resp3.toString())) {
                        showMessageDialog(null, "Valor inválido!")
                    } else if (resp3 < 1) {
                        showMessageDialog(null, "Valor inválido!")
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

        fun monitorarUser() {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val looca = Looca()
            val maquina = Maquina()
            maquina.serialNumber = looca.processador.id
            val componentes = ComponentesRepository(jdbcTemplate)

            if (componentes.validaMaquina(maquina)) {
                showMessageDialog(
                    null, """
                        Seu computador não esta cadastrado!
                    Peça para que um administrador da sua empresa 
                               cadastre sua máquina.
                    """.trimIndent()
                )
                return
            } else {

                var resp = showInputDialog(
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
                        showMessageDialog(null, "Opção inválida!")
                    }
                }

                var resp2 = showInputDialog(
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
                    } else if (!isNumeric(resp2.toString())) {
                        showMessageDialog(null, "Valor inválido!")
                    } else {
                        resp2 = ((resp2 * 60) * 60) * 1000
                        break
                    }
                }

                val resp3 = showInputDialog(
                    """
                Quantas vezes deseja monitorar?
            """.trimIndent()
                ).toInt()

                while (true) {
                    if (!isNumeric(resp3.toString())) {
                        showMessageDialog(null, "Valor inválido!")
                    } else if (resp3 < 1) {
                        showMessageDialog(null, "Valor inválido!")
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

        @JvmStatic
        fun main(args: Array<String>) {

            while (true) {
                val escolha = showInputDialog(
                    """
                        Seja bem vindo de volta! Oque deseja fazer?
                        1 - Cadastrar empresa
                        2 - Login empresarial
                        3 - Login usuário
                        3 - Sair
                    """.trimIndent()
                )

                when (escolha) {
                    "1" -> cadastroEmpresa()
                    "2" -> loginEmpresa()
                    "3" -> loginUsuario()
                    else -> return
                }
            }
        }

    }
}
