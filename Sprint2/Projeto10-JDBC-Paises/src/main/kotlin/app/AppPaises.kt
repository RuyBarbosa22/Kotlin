package app

import config.Conexao
import dominio.Pais
import repositorio.PaisRepository
import javax.swing.JOptionPane.showInputDialog
import javax.swing.JOptionPane.showMessageDialog

fun main() {
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val paisRepository = PaisRepository(jdbcTemplate)

    val excluir = showInputDialog("Deseja excluir os países? \r\n 1- Sim \r\n 2 - Não") =="1"
    if (excluir) {
        paisRepository.excluirTodos()
    }

    val novoNome = showInputDialog("Nome do pais")
    val novaPopulacao = showInputDialog("População").toInt()
    val novoPais = Pais(0, novoNome, novaPopulacao)

    paisRepository.inserir(novoPais)

    val paises = paisRepository.Listar()
    var consulta = "Paises cadastrados:  \r\n\r\n"

    paises.forEach {
        consulta += "${it.id} - ${it.nome}, população: ${it.populacao} habitantes"
        consulta += "\r\n"
    }
    showMessageDialog(null, consulta)

    val idConsulta = showInputDialog("Id para consultar").toInt()
    val paisEncontrado = paisRepository.recuperar(idConsulta)
    showMessageDialog(null, paisEncontrado)

    val idExclusao = showInputDialog("Id para excluir").toInt()
    val excluidos = paisRepository.excluir(idExclusao)
    if (excluidos >0) {
        showMessageDialog(null,"País $idExclusao excluido!")
    }else {
        showMessageDialog(null, "País não encontrado: (")
    }
}