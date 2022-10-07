package app

import config.Conexao
import dominio.Usuario
import repositorio.UsuarioRepository
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val usuarioRepository = UsuarioRepository(jdbcTemplate)
    val usuario1 = Usuario()

    var cadastro = false
    var login = false

        val resposta1 = showInputDialog("Bem vindo! Acesse sua conta, ou crie uma. \r\n 1 - Cadastro \r\n 2 - Entrar \r\n 3 - Sair").toInt()

        if (resposta1 == 1) {

            while (!cadastro) {
                while (true) {
                    var nomeCad = showInputDialog("Nome de usuário").also { usuario1.nome = it }
                    if (nomeCad == "") {
                        showMessageDialog(null, "Usuário inválido!")
                    } else {
                        break
                    }
                }

                while (true) {
                    var emailCad = showInputDialog("Email").also { usuario1.email = it }
                    if (emailCad.indexOf("@") == -1) {
                        showMessageDialog(null, "Email inválido")
                    } else {
                        break
                    }
                }

                while (true) {
                    var telCad = showInputDialog("Telefone").also { usuario1.tel = it }
                    if (telCad.length < 11 || telCad.length > 11) {
                        showMessageDialog(null, "Número incorreto")
                    } else if (!telCad.contains("-?[0-9]+(\\.[0-9]+)?")){
                            showMessageDialog(null, "Número inválido! (apenas números)")
                    } else {
                        break
                    }
                }

                while (true) {
                    var senhaCad = showInputDialog("Senha de acesso").also { usuario1.senha = it }
                    var senha2Cad = showInputDialog("Confirme a senha")
                    if (senhaCad != senha2Cad) {
                        showMessageDialog(null, "Senhas diferentes!")
                    } else {
                        showMessageDialog(null, "Cadastro realizado com sucesso!")
                        showMessageDialog(null, "Redirecionando...")
                        break
                    }

                }
                cadastro = true
                usuarioRepository.cadastro(usuario1)

            }
        }  else if (resposta1 == 2) {
            while (login == false) {
                while (true) {
                    val emailLog = showInputDialog("Email")
                    if (emailLog != usuario1.email){
                        showMessageDialog(null, "Email inválido!")
                    } else {
                        break
                    }
                }

                while (true) {
                val emailLog = showInputDialog("Email:")
                var r1 = usuarioRepository.validacaoEmail(emailLog)
                    if (r1) {
                        break
                    } else {
                        showMessageDialog(null, "Email inválido!")
                    }
                }

                while (true) {
                val senhaLog = showInputDialog("Senha de acesso:")
                val r2 = usuarioRepository.validacaoSenha(senhaLog)
                    if (r2) {
                        break
                        showMessageDialog(null, "Login realizado com sucesso")
                        showMessageDialog(null,"Bem vindo de volta ${usuario1.nome}!")
                    }
                }
                login = true
                }

            } else {
            showMessageDialog(null, "Saindo...")
        }
        }
