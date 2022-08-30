import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val cofres = mutableListOf<Cofrinho>()
    var cofrinho1 = Cofrinho()
    var cofrinho2 = Cofrinho()
    var cofrinho3 = Cofrinho()

    cofrinho1.objetivo = showInputDialog("Qual o objetivo do 1º cofrinho?")
    cofrinho2.objetivo = showInputDialog("Qual o objetivo do 2º cofrinho?")
    cofrinho3.objetivo = showInputDialog("Qual o objetivo do 3º cofrinho?")

    cofrinho1.meta = showInputDialog("Qual a meta do 1º cofrinho?").toDouble()
    cofrinho2.meta = showInputDialog("Qual a meta do 2º cofrinho?").toDouble()
    cofrinho3.meta = showInputDialog("Qual a meta do 3º cofrinho?").toDouble()

    cofres.add(cofrinho1)
    cofres.add(cofrinho2)
    cofres.add(cofrinho3)

    while (true) {

        var resposta1 = showInputDialog("Em qual cofrinho você quer mecher? \r\n 1, 2 ou 3").toInt()

        if (resposta1 != 1 && resposta1 != 2 && resposta1 != 3){
            break
        }

        var valorDeposito = showInputDialog("Quanto você quer depositar no cofre ${resposta1}?").toDouble()

        if (resposta1 == 1) {
            cofres[0].depositar(valorDeposito)
        } else if (resposta1 == 2) {
            cofres[1].depositar(valorDeposito)
        } else if (resposta1 == 3) {
            cofres[2].depositar(valorDeposito)
        }

        var retirada = showInputDialog("Informe quanto vai retirar do cofre $resposta1").toDouble()
        if (resposta1 == 1) {
            cofres[0].retirar(retirada)
        } else if (resposta1 == 2) {
            cofres[1].retirar(retirada)
        } else if (resposta1 == 3) {
            cofres[2].retirar(retirada)
        }
    }

    showMessageDialog(null, cofres[0].descrever())
    showMessageDialog(null, cofres[1].descrever())
    showMessageDialog(null, cofres[2].descrever())
}