package app

import dominio.Tamagotchi
import dominio.TamagotchiBrincalhao
import dominio.TamagotchiEsfomeado
import javax.swing.JOptionPane
import javax.swing.JOptionPane.*

fun main() {

    val resp = showInputDialog("""
        Qual Tamagochi você quer?
        1 - Comum
        2 - Brincalhão
        3 - Esfomeado
    """.trimIndent()).toInt()

    val petVirtual: Tamagotchi
    if (resp == 1) {
        petVirtual = Tamagotchi()
    } else if (resp == 2) {
        petVirtual = TamagotchiBrincalhao()
    } else if (resp == 3) {
        petVirtual = TamagotchiEsfomeado()
    } else {
        showMessageDialog(null,"Opção inválida")
        return
    }

    showMessageDialog(null, """
         Nome do Pet: (sem nome)
            Está acordado? Não
            Está com fome? Sim
            Quer brincar? Sim
    """.trimIndent())

    val nome = showInputDialog("Qual o nome do pet?")
    petVirtual.mudarNome(nome)

    var i = 0

    while (i < 1) {
        showMessageDialog(null, """
         Nome do Pet: ${petVirtual.getNome()}
            Está acordado? ${petVirtual.isAcordado()}
            Está com fome? ${petVirtual.estaComFome()}
            Quer brincar? ${petVirtual.querBrincar()}
    """.trimIndent())

        petVirtual.acordar()
        petVirtual.comer(20)
        petVirtual.brincar(10,0)

        showMessageDialog(null, """
         Nome do Pet: ${petVirtual.getNome()}
            Está acordado? ${petVirtual.isAcordado()}
            Está com fome? ${petVirtual.estaComFome()}
            Quer brincar? ${petVirtual.querBrincar()}
    """.trimIndent())

        petVirtual.receberCarinho()
        petVirtual.comer(10)

        showMessageDialog(null, """
         Nome do Pet: ${petVirtual.getNome()}
            Está acordado? ${petVirtual.isAcordado()}
            Está com fome? ${petVirtual.estaComFome()}
            Quer brincar? ${petVirtual.querBrincar()}
    """.trimIndent())

        petVirtual.brincar(1,3)
        petVirtual.mudarNome("Arlindo marijuana")
        petVirtual.comer(2)
        petVirtual.dormir()

        showMessageDialog(null, """
         Nome do Pet: ${petVirtual.getNome()}
            Está acordado? ${petVirtual.isAcordado()}
            Está com fome? ${petVirtual.estaComFome()}
            Quer brincar? ${petVirtual.querBrincar()}
    """.trimIndent())
        i++
    }



}