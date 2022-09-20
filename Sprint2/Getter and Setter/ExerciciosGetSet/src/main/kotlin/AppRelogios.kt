import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main(){
    val relogio1 = Relogio(10,25,30)
    val relogio2 = Relogio(10,25)
    val relogio3 = Relogio(10)
    val relogio4 = Relogio()

    showMessageDialog(null, relogio1.horaAtual())
    showMessageDialog(null, relogio2.horaAtual())
    showMessageDialog(null, relogio3.horaAtual())
    showMessageDialog(null, relogio4.horaAtual())

    val relogioSoMinutos = Relogio(minutos = 12) //passando o valor de apenas um parâmetro dentro do construtor do objeto.
    showMessageDialog(null, relogioSoMinutos.horaAtual())
}
