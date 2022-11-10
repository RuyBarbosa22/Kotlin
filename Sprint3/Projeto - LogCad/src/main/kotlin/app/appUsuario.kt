package app

import com.github.britooo.looca.api.core.Looca
import config.Conexao
import dominio.Usuario
import repositorio.UsuarioRepository
import javax.swing.JOptionPane.*
import kotlin.math.roundToInt

open class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            while (true) {

                val escolha = showInputDialog(
                    """
                        Bem vindo
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

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val usuario = Usuario()
            val usuarioRepository = UsuarioRepository(jdbcTemplate)

            while (true) {
                val nomeCad = showInputDialog("Nome de usuário").also { usuario.nome = it }
                if (nomeCad == "") {
                    showMessageDialog(null, "Usuário inválido!")
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
                } else if (!usuarioRepository.isNumeric(telCad)) {
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
                    usuario.senha = senhaCad
                    UsuarioRepository(jdbcTemplate).cadastro(usuario)
                    showMessageDialog(null, "Cadastro realizado com sucesso!")
                    showMessageDialog(null, "Redirecionando...")
                    break
                }

            }
        }

        fun login() {

            val jdbcTemplate = Conexao().getJdbcTemplate()
            val usuario = Usuario()
            val usuarioRepository = UsuarioRepository(jdbcTemplate)

            while (true) {
                val emailLog = showInputDialog("Email:")
                val senhaLog = showInputDialog("Senha de acesso:")
                val autenticado = usuarioRepository.validacaoLogin(emailLog, senhaLog)
                if (autenticado) {
                    showMessageDialog(null, "Login realizado com sucesso")
                    showMessageDialog(null, "Bem vindo de volta ${usuario.nome}!")

                    while (true) {
                        val resp = showInputDialog(
                            """
                        Oque deseja monitorar?
                        1 - CPU
                        2 - RAM
                        3 - Disco
                        4 - Sobre o computador
                        5 - Sair
            """.trimIndent()
                        )

                        when (resp) {
                            "1" -> monitorarCPU()
                            "2" -> monitorarRAM()
                            "3" -> monitorarHD()
                            "4" -> monitorarPC()
                            else -> return
                        }
                    }


                } else {
                    showMessageDialog(null, "credenciais inválidas")
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
    """)
        }

        fun monitorarRAM() {
            val looca = Looca()

            val memoria = looca.memoria

            showMessageDialog(
                null, """
        Total (GB): ${"%.2f".format(memoria.total.toDouble() / 1024 / 1024 / 1024)}
        Em uso (GB): ${"%.2f".format(memoria.emUso.toDouble() / 1024 / 1024 / 1024)}
        Disponível (GB): ${"%.2f".format(memoria.disponivel.toDouble() / 1024 / 1024 / 1024)}
    """)
        }

        fun monitorarHD() {
            val looca = Looca()

            val grupoDiscos = looca.grupoDeDiscos

            val discos = grupoDiscos.discos
            discos.forEachIndexed { d, disco ->
                showMessageDialog(
                    null, """
            Disco ${d + 1}:
            Modelo: ${disco.modelo}
            Tamanho (GB): ${disco.tamanho.toDouble() / 1024 / 1024 / 1024}
        """
                )
            }
        }

        fun monitorarPC() {
            val looca = Looca()
            val sistema = looca.sistema

            showMessageDialog(
                null, """
        Fabricante: """ + sistema.fabricante + """
        Arquitetura: """ + sistema.arquitetura + """
        SO: """ + sistema.sistemaOperacional + """
        Ligado há: """ + sistema.tempoDeAtividade + """ horas
        Ligado desde: """ + sistema.inicializado + """
    """
            )
        }


    }
}

