package aula2308.segundaParte

import javax.swing.JOptionPane.*

fun main() {
    val pizza1 = PedidoPizza()
    pizza1.sabor = showInputDialog("Qual o sabor da pizza")
    pizza1.preco = showInputDialog( "Qual o valor").toDouble()
    pizza1.qtdAmigos = showInputDialog("Quantos amigos?").toInt()

    pizza1.validarCupom(showInputDialog("Digite o cumpom").toString())
    showMessageDialog(null, "${pizza1.descreverPizza()}")
    pizza1.obterValorAmigo()
    showMessageDialog(null, "Cada amigo vai pagar" +
            " R$${".%2f".format(pizza1.preco)}")

    showMessageDialog(null, pizza1.obterCuponsUsados())

}