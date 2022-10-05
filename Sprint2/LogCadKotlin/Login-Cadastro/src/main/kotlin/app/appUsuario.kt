package app

import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {
    while (true) {

        val resposta1 = showInputDialog("Bem vindo! Acesse sua conta, ou crie uma. \r\n 1 - Cadastro \r\n 2 - Entrar").toInt()

        if (resposta1 == 1){

        } else if (resposta1 == 2){

        } else {
            showMessageDialog(null, "Respota inválida!")
        }
    }
}