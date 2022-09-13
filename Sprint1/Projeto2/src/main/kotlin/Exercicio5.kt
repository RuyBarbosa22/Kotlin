import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    transporte()
}

fun transporte() {
    var onibus = showInputDialog("Digite a linha do ônibus")
    var tempG = showInputDialog("Qual o maior tempo de volta (minutos)?").toInt()
    var tempP = showInputDialog("Qual o menor tempo de volta (minutos)?").toInt()
    val media = (tempG + tempP) / 2
    showMessageDialog(null, "A linha $onibus leva em média $media minutos/volta onde $media é a média entre o maior e menor tempo")
}
