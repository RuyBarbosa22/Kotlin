import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val produto1 = Produto()
    produto1.nome = showInputDialog("Nome do produto")
    produto1.preco = showInputDialog("Digite o preço").toDouble()
    var resposta = showInputDialog("É um brinde? \r\n" +
            "1 - Sim \r\n" +
            "2 - Não").toInt()

    produto1.brinde = resposta == 1

    showMessageDialog(null,"O produto ${produto1.nome} custa R$${"%.2f".format(produto1.preco)}")
}