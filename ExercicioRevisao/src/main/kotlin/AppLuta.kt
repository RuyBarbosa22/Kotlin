import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {
    var j = 0

    var lutador1 = Lutador()
    lutador1.nome = showInputDialog("Vamos começar a Luta! Nome do 1º lutador")
    lutador1.forcaAtaque = showInputDialog("Força de Ataque").toDouble()
    lutador1.forcaDefesa = showInputDialog("Força de defesa").toDouble()

    var lutador2 = Lutador()
    lutador2.nome = showInputDialog("Vamos começar a Luta! Nome do 2º lutador")
    lutador2.forcaAtaque = showInputDialog("Força de Ataque").toDouble()
    lutador2.forcaDefesa = showInputDialog("Força de defesa").toDouble()

    while (j < 3) {

        var resposta1 = showInputDialog(" 1 - Lutador 1 bate no Lutador 2\r\n 2 - Lutador 2 bate no Lutador 1").toInt()


            if (resposta1 == 1) {
                lutador2.apanhar(lutador1)
            } else {
                lutador1.apanhar(lutador2)
            }

        showMessageDialog(null, lutador1.descrever())
        showMessageDialog(null, lutador2.descrever())

        var resposta2 =
            showInputDialog("1 - Lutador 1 se concentra \r\n 2 - Lutador 2 se concentra \r\n 3 - Nenhum se concentra").toInt()

        if (resposta2 == 1) {
            lutador1.concentrar()
        } else if (resposta2 == 2) {
            lutador2.concentrar()
        }


        showMessageDialog(null, lutador1.descrever())
        showMessageDialog(null, lutador2.descrever())

        j+=1
    }

    if (lutador1.vidaAtual > lutador2.vidaAtual){
        showMessageDialog(null, "O vencedor é ${lutador1.nome}")
    }else{
        showMessageDialog(null, "O vencedor é ${lutador2.nome}")
    }

}