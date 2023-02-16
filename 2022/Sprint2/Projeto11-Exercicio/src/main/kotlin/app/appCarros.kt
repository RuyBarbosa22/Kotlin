package app

import config.Conexao
import dominio.Carro
import repositorio.CarrosRepository
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val carrosRepository = CarrosRepository(jdbcTemplate)

    var contador = showInputDialog("Quantos carros deseja inserir?").toInt()

    while (contador > 0) {

        val novoModelo = showInputDialog("Nome do carro")
        val novoAno = showInputDialog("Ano").toInt()
        val novaPotencia = showInputDialog("Potência").toDouble()
        val novoCarro = Carro(0, novoModelo, novoAno, novaPotencia)

        carrosRepository.inserir(novoCarro)

        contador--
    }
    val carros = carrosRepository.Listar()
    var consulta = "${contador} Carros foram cadastrados:  \r\n\r\n"


    carros.forEach {
        consulta += "ID: ${it.id}, Modelo: ${it.modelo}, Ano: ${it.ano}, Potência: ${it.potencia}"
        consulta += "\r\n"
    }
    showMessageDialog(null, consulta)


    val rever = showInputDialog("Qual carro deseja rever? Digite um ID válido").toInt()
    if (carrosRepository.selectEspecifico(rever)) {
        val Rcarro = carrosRepository.select(rever)
        showMessageDialog(
            null,
            "ID: ${Rcarro.id}, modelo: ${Rcarro.modelo}, ano: ${Rcarro.ano}, potência: ${Rcarro.potencia}"
        )
    } else {
        showMessageDialog(null, "Carro de ID ${rever} não encontrado")
    }

    val seminovos = CarrosRepository(jdbcTemplate).listarSeminovos()

    var mensagemSeminovos = "${seminovos.size} carros seminovos: \r\n"
    seminovos.forEach {
        mensagemSeminovos += "id: ${it.id} - ${it.modelo}, ano ${it.ano}, potência de ${it.potencia} \r\n"
    }
    showMessageDialog(null, mensagemSeminovos)

    val seminovosPotentes = CarrosRepository(jdbcTemplate).listarSeminovosPotentes()

    var mensagemPotentes = "${seminovosPotentes.size} carros seminovos: \r\n"
    seminovosPotentes.forEach {
        mensagemPotentes += "id: ${it.id} - ${it.modelo}, ano ${it.ano}, potência de ${it.potencia} \r\n"
    }
    showMessageDialog(null, mensagemPotentes)

    val modeloExcluir = showInputDialog(
        "Qual o modelo de carro que deseja excluir do banco?")

    val excluidos = CarrosRepository(jdbcTemplate).excluirPorModelo(modeloExcluir)
    if (excluidos > 0) {
        showMessageDialog(null, "$excluidos carros excluídos")
    } else {
        showMessageDialog(null, "Nenhum carro excluído")
    }
}