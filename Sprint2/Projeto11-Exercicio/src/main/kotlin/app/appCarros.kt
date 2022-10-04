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

    while (contador > 0){

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
    if (carrosRepository.selectEspecifico(rever) == true) {
            val Rcarro = carrosRepository.select(rever)
        showMessageDialog(null, "ID: ${Rcarro.id}, modelo: ${Rcarro.modelo}, ano: ${Rcarro.ano}, potência: ${Rcarro.potencia}")
    }else{
        showMessageDialog(null,"Carro de ID ${rever} não encontrado")
    }

    showMessageDialog(null, carrosRepository.selectOrdenado())


//    val idConsulta = showInputDialog("Id para consultar").toInt()
//    val carroEncontrado = carrosRepository.recuperar(idConsulta)
//    showMessageDialog(null, carroEncontrado)
//
//    val idExclusao = showInputDialog("Id para excluir").toInt()
//    val excluidos = carrosRepository.excluir(idExclusao)
//    if (excluidos >0) {
//        showMessageDialog(null,"Carro $idExclusao excluido!")
//    }else {
//        showMessageDialog(null, "Carro não encontrado: (")
//    }
}