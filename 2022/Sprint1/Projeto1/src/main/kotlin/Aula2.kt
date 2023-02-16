import javax.swing.JOptionPane

fun main() {
    val cidade = JOptionPane.showInputDialog("Sua cidade")
    println("Sua cidade é $cidade")

    //solicitando um número e exiba no console  dobro dele

    var numero = JOptionPane.showInputDialog("Digite o número")
    println("O dobro de $numero é ${numero.toDouble() * 2}")

    //todo valor recebido de "JOptionPane.showInputDialog" é String
    // .toDouble() converte para número real (com virgula)
    // .toInt() converte para número inteiro (sem virgula)

    // podemos fazer a conversão na leitura do valor

    var filhos = JOptionPane.showInputDialog("Quantos filhos?").toInt()

    println("Você tem, atualmente $filhos")

    JOptionPane.showMessageDialog(null, "Janela bacana")
    // O "JOptionPane.showMessageDialog" pode ser usado como um Alert, semelhante ao JavaScript

}