import javax.swing.JOptionPane

fun main() {
    val estado1 = Estado()
    estado1.populacao = 900
    JOptionPane.showMessageDialog(null, estado1.populacao)

    estado1.populacao = -88
    JOptionPane.showMessageDialog(null, estado1.populacao)

    estado1.populacao = 500
    JOptionPane.showMessageDialog(null, estado1.populacao)

    estado1.nome = "MG"
    JOptionPane.showMessageDialog(null, estado1.nome)

    estado1.nome = "MINAS GERAIS"
    JOptionPane.showMessageDialog(null, estado1.nome)

    estado1.nome = "Paraiba"
    JOptionPane.showMessageDialog(null, estado1.nome)

}