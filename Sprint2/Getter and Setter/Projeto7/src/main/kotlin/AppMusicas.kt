import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val musicaA = Musica()

    while (musicaA.acessoEncerrado == false) {
        musicaA.interprete = showInputDialog("Nome do artista")
        musicaA.acessosSpotify = showInputDialog("Quantidade de acessos").toInt()

        showMessageDialog(
            null,
            "A música cantada por ${musicaA.interprete} teve ${musicaA.acessosSpotify} acessos no Spotify"
        )

        val resposta = showInputDialog("Encerrar acesso? \r \n 1 - Sim \r\n 2 - Não").toInt()
        // usamos o "\r \n" para poder pular de linha dentro do input/messege.

        if (resposta == 1) {
            musicaA.acessoEncerrado = true
        }
    }
}
