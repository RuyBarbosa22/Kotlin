import Poo.Carro
import javax.swing.JOptionPane.*

fun main() {
    val carro1 = Carro()
    carro1.modelo = showInputDialog("Qual o modelo do primeiro carro?")
    carro1.potencia = showInputDialog("Quantos cavalos de potencia?").toDouble()
    carro1.placa = "WHBS-273"
    carro1.marcha = 0

    showMessageDialog(null, "Seu carro é ${carro1.modelo}, tem ${carro1.potencia} cavalos de potencia" +
            "e está na ${carro1.marcha} marcha.")

    carro1.ligarCarro()
    carro1.aumentarMarcha()
    carro1.aumentarMarcha()
    carro1.aumentarMarcha()
    carro1.aumentarMarcha()

    showMessageDialog(null, "O ${carro1.modelo} está na ${carro1.marcha} marcha e está " +
            " ${if (carro1.ligado) "ligado" else "desligado"}")

    val carro2 = Carro()
    carro2.modelo = showInputDialog("Qual o modelo do segundo carro?")
    carro2.potencia = showInputDialog("Quantos cavalos de potencia?").toDouble()
    carro2.placa = "JSKJ-047"
    carro2.marcha = 0

    carro2.ligarCarro()
    carro2.aumentarMarcha()
    carro2.aumentarMarcha()
    carro2.aumentarMarcha()
    carro2.aumentarMarcha()
    carro2.aumentarMarcha()
    carro2.aumentarMarcha()

    showMessageDialog(null, "O ${carro2.modelo} está na ${carro2.marcha} marcha e está " +
            " ${if (carro2.ligado) "ligado" else "desligado"}")

    carro2.viagemCurta()

    showMessageDialog(null, "Voce viajou por ${carro2.km} kilometros")


}



