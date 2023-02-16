import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    uber()
}

fun uber() {
    var price = showInputDialog("Qual o valor por Km rodado?").toDouble()
    var km = showInputDialog("Qual a distancia (KM) da próxima corrida?").toDouble()
    var volume = showInputDialog("Quantas corridas?").toInt()

    if (volume > 10 || volume < 0) {
        showMessageDialog(null, "Valor inválido")
        return
    }

    val valor = price * km
    when (volume) {
        in 0..2 -> showMessageDialog(null, "O valor da corrida é ${valor}")
        in 3..7 -> showMessageDialog(null, "O valor da corrida é ${valor * 1.3}")
        in 8..10 -> showMessageDialog(null, "O valor da corrida é ${valor * 1.8}")
    }
}