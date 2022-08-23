import aula2308.Relogio
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {
    val relogio1 = Relogio()
    relogio1.modelo = "Rolex"
    relogio1.preco = 30000.0
    relogio1.horas = 20
    relogio1.minutos = 47
    relogio1.segundos = 23

    showMessageDialog(null, "A hora atual é ${relogio1.verHora()}")

    showMessageDialog(null, "Após o teste ${relogio1.validar()}")

    val relogio2 = Relogio()
    relogio2.modelo = showInputDialog("Digite o modelo do relógio")
    relogio2.preco = showInputDialog("Digite o preço do relógio").toDouble()
    relogio2.horas = showInputDialog("Digite as horas").toInt()
    relogio2.minutos = showInputDialog("Digite os minutos").toInt()
    relogio2.segundos  = showInputDialog("Digite os segundos do relógio").toInt()



    showMessageDialog(null, relogio2.validar())
    showMessageDialog(null, "O horário atual é: ${relogio2.verHora().toString().padStart(2,'0')}")
}