package app

import dominio.Usuario
import repositorio.UsuarioRepository
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {
    while (true) {

        val resposta1 = showInputDialog("Bem vindo! Acesse sua conta, ou crie uma. \r\n 1 - Cadastro \r\n 2 - Entrar \r\n 3 - Sair").toInt()

        if (resposta1 == 1){
            var nomeCad = showInputDialog("Nome de usuário").also { Usuario().nome = it }
            var emailCad = showInputDialog("Email").also { Usuario().email = it }
            var telCad = showInputDialog("Telefone").also { Usuario().tel = it }
            var senhaCad = showInputDialog("Senha de acesso").also { Usuario().senha = it }
            var senha2Cad = showInputDialog("Confirme a senha")
            if (senhaCad != senha2Cad){
                showMessageDialog(null,"Senhas diferentes!")
            }
        } else if (resposta1 == 2){

        } else {
            showMessageDialog(null, "Saindo...")
            break
        }
    }
}