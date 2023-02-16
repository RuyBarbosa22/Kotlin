package app

import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

open class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {

            println("Mostro coisas no console")

            showMessageDialog(null,
                            "Mostro coisas em Janelas")

            while (true) {
                val escolha = showInputDialog("""
                    Escolha uma opção:
                    1 - Dar bom dia
                    2 - Dar boa tarde
                    3 - Dar boa noite
                    NDA - Sair
                """.trimIndent())

                when (escolha) {
                    "1" -> showMessageDialog(null, "Bom dia, flor do dia")
                    "2" -> showMessageDialog(null, "Boa tarde")
                    "3" -> showMessageDialog(null, "Boa noite! Durma bem")
                    else -> break
                }
            }
        }
    }
}