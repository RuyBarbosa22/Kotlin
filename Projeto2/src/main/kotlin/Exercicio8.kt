import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    classeSocial()
}

fun classeSocial() {

    val salario = showInputDialog("Qual seu salário?").toDouble()

    if (salario < 0) {
        showMessageDialog(null, "Valor inválido")
    }

    when (salario) {
        in 0.0..1000.0 -> println("Classe C")
        in 1000.01..2000.0 -> println("Classe B")
        in 2000.01..5000.0 -> println("Classe A")
        else -> println("Classe AA")
    }

}
