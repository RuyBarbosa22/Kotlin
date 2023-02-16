import javax.swing.JOptionPane
import javax.swing.JOptionPane.showInputDialog

fun main() {
    ki()
}

fun ki() {
    val kiBase = showInputDialog("Digite seu ki base").toInt()
    val kiSSJ = kiBase * 50
    val kiSSJ2 = kiBase * 100
    val kiSSJ3 = kiBase * 200
    val kiGod = kiBase * 500
    println("nivel de Ki SSJ é $kiSSJ")
    println("nivel de Ki SSJ2 é $kiSSJ2")
    println("nivel de Ki SSJ3 é $kiSSJ3")
    println("nivel de Ki God é $kiGod")
}