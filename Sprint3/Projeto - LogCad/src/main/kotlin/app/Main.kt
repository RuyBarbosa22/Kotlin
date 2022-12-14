package app

import cadastroEmpresa
//import com.github.britooo.looca.api.core.Looca
//import com.microsoft.sqlserver.jdbc.StringUtils.isNumeric
//import config.Conexao
//import dominio.Empresa
//import dominio.Usuario
//import dominio.componentes.CPU
//import dominio.componentes.Disco
//import dominio.componentes.Maquina
//import dominio.componentes.RAM
import loginEmpresa
import loginUsuario
//import repository.ComponentesRepository
//import repository.EmpresaRepository
//import repository.UsuarioRepository
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.JOptionPane.showInputDialog

open class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            while (true) {
                val escolha = showInputDialog(
                    """
                        Seja bem vindo de volta! Oque deseja fazer?
                        1 - Cadastrar empresa
                        2 - Login empresarial
                        3 - Login usuário
                        4 - Sair
                    """.trimIndent()
                )

                when (escolha) {
                    "1" -> cadastroEmpresa()
                    "2" -> loginEmpresa()
                    "3" -> loginUsuario()
                    else -> return
                }
            }
        }
    }
}
