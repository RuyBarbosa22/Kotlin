import javax.swing.JOptionPane
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val meuSalario = JOptionPane.showInputDialog("Meu salário").toDouble() //definindo variável que será usada como parametro
    val meuInss = inss(meuSalario)  //definindo variável que receberá o valor da função com o parâmetro "meuSalario"
    val meuIR = impostoRenda(meuSalario)
    println("Meu Inss será de $meuInss")
    println("Meu Imposto de Renda será $meuIR")
}

//criamos uma função que exige um parametro double e
//definimos que é obrigatório o retorno de um determinado valor(double)

fun inss(salario: Double): Double {
    if (salario < 0) {
        showMessageDialog(null, "Valor no sálario inválido")
    }
    return salario * 0.01
}

fun impostoRenda(salario: Double): Double {
    if (salario < 0) {
        showMessageDialog(null, "Valor no sálario inválido")
    }

    if (salario <= 2500) {
        return salario * 0.15
    } else {
        return salario * 0.20
    }
}

fun podeAposentar(idade: Int): Boolean {
    if (idade> 65){
        return true
    } else {
        return false
    }
}