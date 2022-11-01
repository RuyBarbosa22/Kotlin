package app

import dominio2.ContaDesafio
import dominio2.EstagiarioDesafio
import dominio2.TrabalhadorDesafio
import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog

fun main() {

    val conta1 = EstagiarioDesafio()
    val conta2 = TrabalhadorDesafio()
    val conta0 = ContaDesafio("Ruy", 2000.0)


    fun contaComum() {
        conta0.depositar(200.0)
        conta0.getSaldo()
    }

    fun contaTrabalhador() {
        conta1.depositar(250.0)
        conta1.getSaldo()
    }

    fun contaEstagiario() {
        conta2.depositar(1800.0)
        conta2.getSaldo()
    }

    while (true) {

        val escolha = showInputDialog("""
        1 - Conta Estagiário
        2 - Conta Trabalhador
        3 - Conta comum
        4 - Sair
    """.trimIndent())

        when (escolha) {
            "1" -> contaEstagiario()
            "2" -> contaTrabalhador()
            "4" -> return
            else -> contaComum()
        }


    }

}