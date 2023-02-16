import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    // aqui criamos o objeto usando um construtor
    val cidade1 = Cidade(nome = "São Paulo", 11_000_000)
    showMessageDialog(null, cidade1.nome)
    showMessageDialog(null, cidade1.populacao)

    //não conseguimos mudar o valor atribuido por ser uma val
    //cidade1.nome = "Rio de Janeiro"
    cidade1.populacao = 8_000_000

    showMessageDialog(null, cidade1.nome)
    showMessageDialog(null, cidade1.populacao)
}