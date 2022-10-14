package app

import config.Conexao
import dominio.Usuario
import repositorio.UsuarioRepository
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {

    while (true) {
        val escolha = showInputDialog(
            """
        Bem vindo
        1 - Cadastrar
        2 - Login
        3 - Sair
    """.trimIndent())

        when (escolha) {
            "1" -> cadastro()
            "2" -> login(Usuario())
            "3" -> showMessageDialog(null, "Boa noite! Durma bem")
            else -> break
        }
    }





}

fun cadastro(): Usuario {

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
        val emailCad = showInputDialog("Email").also { usuario.email = it }
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
            showMessageDialog(null, "Cadastro realizado com sucesso!")
            showMessageDialog(null, "Redirecionando...")
            break
        }

    }
        return Usuario()
}

fun login (Usuario:Usuario) {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val usuario = Usuario()
    val usuarioRepository = UsuarioRepository(jdbcTemplate)

    while (true) {
        val emailLog = showInputDialog("Email:")
        val r1 = usuarioRepository.validacaoEmail(emailLog)
        if (!r1) {
            showMessageDialog(null, "Email inválido ou não cadastrado!")
        } else {
            break
        }
    }

    while (true) {
        val senhaLog = showInputDialog("Senha de acesso:")
        val r2 = usuarioRepository.validacaoSenha(senhaLog)
        if (r2) {
            showMessageDialog(null, "Login realizado com sucesso")
            showMessageDialog(null, "Bem vindo de volta ${usuario.nome}!")
            break
        }
    }
}








