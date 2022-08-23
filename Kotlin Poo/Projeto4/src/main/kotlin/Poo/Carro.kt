package Poo

import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

class Carro {
    lateinit var modelo: String
    lateinit var placa: String
    var km: Int = 0
    var marcha: Int = 0
    var potencia: Double = 0.0
    var ligado: Boolean = false


    fun ligarCarro() {
        ligado = true
    }

    fun desligarCarro() {
        ligado = false
    }

    fun aumentarMarcha() {
        marcha += 1
        if (marcha > 6) {
            marcha = 6
            showMessageDialog(null, "Já está na ultima marcha")
        }
    }

    fun diminuirMarcha() {
        marcha -= 1
        if (marcha < -1) {
            marcha = -1
            showMessageDialog(null, "Já está na marcha ré")
        }
    }

    fun viagemCurta() {
        if (ligado && marcha > 0){
            if (marcha == 1 || marcha == 2){
                km +=10
            }
            if (marcha == 3 || marcha == 4 || marcha == 5){
                km +=20
            }
            if (marcha == 6){
                km +=30
            }
        }else{
            showMessageDialog(null, "O carro está desligado")
        }
    }

}