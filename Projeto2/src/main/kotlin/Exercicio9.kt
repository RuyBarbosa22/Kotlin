import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    pensamento()
}

fun pensamento() {
    val frase = showInputDialog("Digite sua frase")
    val contador = showInputDialog("Repetir quantas vezes?").toInt()

    var i = 0
    while (i<contador){
        println("$frase")
        i++
    }

}