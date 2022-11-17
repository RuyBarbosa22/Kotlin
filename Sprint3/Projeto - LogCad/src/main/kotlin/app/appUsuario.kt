package app

import com.github.britooo.looca.api.core.Looca
import com.microsoft.sqlserver.jdbc.StringUtils.isNumeric
import config.Conexao
import dominio.Empresa
import repositorio.EmpresaRepository
import java.util.*
import javax.swing.JOptionPane.*
import kotlin.concurrent.schedule

open class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            while (true) {

                val escolha = showInputDialog(
                    """
                        Seja bem vindo de volta! Oque deseja fazer?
                        1 - Cadastrar
                        2 - Login
                        3 - Sair
                    """.trimIndent()
                )

                when (escolha) {
                    "1" -> cadastro()
                    "2" -> login()
                    else -> break
                }
            }
        }


        fun cadastro() {

            val length = 5
            val randomString = getRandomString(length)
            val jdbcTemplate = Conexao().getJdbcTemplate()
            val empresa = Empresa()
            val empresaRepository = EmpresaRepository(jdbcTemplate)

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
                        Esse é seu código empresarial: ${randomString}
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

        fun login() {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val empresa = Empresa()
            val empresaRepository = EmpresaRepository(jdbcTemplate)

            while (true) {
                val emailLog = showInputDialog("Email:").lowercase()
                val senhaLog = showInputDialog("Senha de acesso:")
                val autenticado = empresaRepository.validacaoLogin(emailLog, senhaLog)
                if (autenticado) {
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
                            "1" -> monitorar()
                           // "2" -> monitorarRAM()
                           // "3" -> monitorarHD()
                            else -> return
                        }
                    }


                } else {
                    showMessageDialog(null, "credenciais inválidas")
                }
            }
        }

        fun getRandomString(length: Int): String {
            val charset = "0123456789"
            return (1..length)
                .map { charset.random() }
                .joinToString("")
        }

        fun monitorar() {

            while (true) {
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
                        De quanto em quanto ${resp} você deseja gravar
                        os dados das máquinas?
                    """.trimIndent()
                ).toLong()


                while (true) {
                    if (resp == "segundos") {
                        resp2 = resp2 * 1000
                    } else if (resp == "minutos") {
                        resp2 = (resp2 * 60) *1000
                    } else if (!isNumeric(resp2.toString())) {
                        showMessageDialog(null, "Valor inválido!")
                    } else {
                        resp2 = ((resp2 * 60) *60) * 1000
                    }
                }


                Timer().schedule(resp2) {

                }
            }

        }


        fun monitorarCPU() {
            val looca = Looca()
            val processador = looca.processador

            showMessageDialog(
                null, """
        Fabricante: ${processador.fabricante})
        Modelo: ${processador.nome}
        Frequência (GHz): ${processador.frequencia.toDouble() / 1024 / 1024 / 1024}
        Uso (%): ${processador.uso}
    """
            )
        }
//
//        fun monitorarRAM() {
//            val looca = Looca()
//
//            val memoria = looca.memoria
//
//            showMessageDialog(
//                null, """
//        Total (GB): ${"%.2f".format(memoria.total.toDouble() / 1024 / 1024 / 1024)}
//        Em uso (GB): ${"%.2f".format(memoria.emUso.toDouble() / 1024 / 1024 / 1024)}
//        Disponível (GB): ${"%.2f".format(memoria.disponivel.toDouble() / 1024 / 1024 / 1024)}
//    """
//            )
//        }
//
//        fun monitorarHD() {
//            val looca = Looca()
//
//            val grupoDiscos = looca.grupoDeDiscos
//
//            val discos = grupoDiscos.discos
//            discos.forEachIndexed { d, disco ->
//                showMessageDialog(
//                    null, """
//            Disco ${d + 1}:
//            Modelo: ${disco.modelo}
//            Tamanho (GB): ${disco.tamanho.toDouble() / 1024 / 1024 / 1024}
//        """
//                )
//            }
//        }
//
//        fun monitorarPC() {
//            val looca = Looca()
//            val sistema = looca.sistema
//
//            showMessageDialog(
//                null, """
//        Fabricante: """ + sistema.fabricante + """
//        Arquitetura: """ + sistema.arquitetura + """
//        SO: """ + sistema.sistemaOperacional + """
//        Ligado há: """ + sistema.tempoDeAtividade + """ horas
//        Ligado desde: """ + sistema.inicializado + """
//    """
//            )
//        }


    }
}

