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

    var resposta1 =
        showInputDialog("Bem vindo! Acesse sua conta, ou crie uma. \r\n 1 - Cadastro \r\n 2 - Entrar \r\n 3 - Sair").toInt()

    while (resposta1 !=3){


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CADASTRO

        if (resposta1 == 1) {
            while (!cadastro) {
                while (true) {
                    val nomeCad = showInputDialog("Nome de usuário").also { usuario1.nome = it }
                    if (nomeCad == "") {
                        showMessageDialog(null, "Usuário inválido!")
                    } else {
                        break
                    }
                }

                while (true) {
                    val emailCad = showInputDialog("Email").also { usuario1.email = it }
                    if (emailCad.indexOf("@") == -1) {
                        showMessageDialog(null, "Email inválido")
                    } else if (emailCad.indexOf(".com") == -1) {
                        showMessageDialog(null, "Email inválido")
                    } else {
                        break
                    }
                }

                while (true) {
                    val telCad = showInputDialog("Telefone").also { usuario1.tel = it }
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
                    val senhaCad = showInputDialog("Senha de acesso").also { usuario1.senha = it }
                    val senha2Cad = showInputDialog("Confirme a senha")
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
                resposta1 = 2
            }
        } else if (resposta1 == 2) {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //LOGIN

            while (login == false) {

                while (true) {
                    val emailLog = showInputDialog("Email:")
                    val r1 = usuarioRepository.validacaoEmail(emailLog)
                    if (!r1) {
                        break
                    } else {
                        showMessageDialog(null, "Email inválido!")
                    }
                }

                while (true) {
                    val senhaLog = showInputDialog("Senha de acesso:")
                    val r2 = usuarioRepository.validacaoSenha(senhaLog)
                    if (!r2) {
                        showMessageDialog(null, "Login realizado com sucesso")
                        showMessageDialog(null, "Bem vindo de volta ${usuario1.nome}!")
                        break
                    }
                }
                login = true
            }

        } else {
            showMessageDialog(null, "Saindo...")
        }

    }

}

