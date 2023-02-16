import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    basquete()
}

fun basquete() {
    val alt = showInputDialog("Qual sua altura?").toDouble()
    if (alt > 1.8) {
        showMessageDialog(null, "Voce pode jogar basquete")
    } else {
        showMessageDialog(null, "Você não pode jogar basquete")
    }

}