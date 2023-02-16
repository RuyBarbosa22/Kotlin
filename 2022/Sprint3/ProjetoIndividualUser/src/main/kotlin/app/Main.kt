package app
import javax.swing.JOptionPane.showInputDialog

open class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            while (true) {
                val escolha = showInputDialog(
                    """
                        Seja bem vindo de volta! Oque deseja fazer?
                        1 - Login usuário
                        2 - Sair
                    """.trimIndent()
                )

                when (escolha) {
                    "1" -> loginUsuario()
                    else -> return
                }
            }
        }
    }
}
