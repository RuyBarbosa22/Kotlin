import javax.swing.JOptionPane

fun main() {
    val pessoa1 = Cidadao()
    pessoa1.nome = "Elizabeth"
    pessoa1.idade = 96
    pessoa1.renda = 500000.0

    val pessoa2 = Cidadao()
    pessoa2.nome = "Lady Gaga"
    pessoa2.idade = 36
    pessoa2.renda = 3300000.0

    val pessoas = mutableListOf<Cidadao>(pessoa1, pessoa2)

    val entrevistado = pessoas[1]
    entrevistado.nome = "Jojo Todinho"

    JOptionPane.showMessageDialog(null, pessoa2.nome)
}