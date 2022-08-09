import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    bairroNome()
}

fun bairroNome() {
    var nome = showInputDialog("Digite o seu nome")
    var bairro = showInputDialog("Digite seu bairro")
    showMessageDialog(null, "Seu nome é $nome e você mora em $bairro")
}
