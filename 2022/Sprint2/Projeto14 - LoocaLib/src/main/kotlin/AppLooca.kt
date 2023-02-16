import com.github.britooo.looca.api.core.Looca
import javax.swing.JOptionPane


fun main() {
    // criando instância do Looca
    val looca = Looca()

    // Objeto com as informações do SO
    val sistema = looca.sistema

    println("Sistema: $sistema")

    println("""
        Fabricante: ${sistema.fabricante}
        Arquitetura: ${sistema.arquitetura}
        SO: ${sistema.sistemaOperacional}
        Ligado há: ${sistema.tempoDeAtividade}
        Ligado desde: ${sistema.inicializado}
    """.trimIndent())

    println()

    // Criação do gerenciador de discos
    val grupoDiscos = looca.grupoDeDiscos

    // Obtendo lista de discos
    val discos = grupoDiscos.discos
    discos.forEachIndexed { d, disco ->
        println("""
            Disco ${d+1}:
            Modelo: ${disco.modelo}
            Tamanho (bytes): ${disco.tamanho}
            Tamanho (GB): ${disco.tamanho.toDouble()/1024/1024/1024}
            
        """.trimIndent() )
    }

    println()

    // criação do gerenciador de memória
    val memoria = looca.memoria

    println("""
        Total (Bytes): ${memoria.total}
        Em uso (Bytes): ${memoria.emUso}
        Disponível (Bytes): ${memoria.disponivel}
        
        Total (GB): ${"%.2f".format(memoria.total.toDouble()/1024/1024/1024)}
        Em uso (GB): ${"%.2f".format(memoria.emUso.toDouble()/1024/1024/1024)}
        Disponível (GB): ${"%.2f".format(memoria.disponivel.toDouble()/1024/1024/1024)}
    """.trimIndent())


    println()

    // criação do gerenciador do processador
    val processador = looca.processador

    println("""
        Fabricante: ${processador.fabricante}
        Modelo: ${processador.nome}
        Frequência (Hz): ${processador.frequencia}
        Frequência (GHz): ${processador.frequencia.toDouble()/1024/1024/1024}
        Uso (%): ${processador.uso}
    """.trimIndent())

    println()

    // criação do gerenciador de temperatura
    val temperatura = looca.temperatura

    println("Temperatura da CPU (ºC):  ${temperatura.temperatura}")

    println()

    // criação do gerenciador de processos do SO
    val grupoProcesssos = looca.grupoDeProcessos

    println("""
        Total de processos: ${grupoProcesssos.totalProcessos}    
        Total de threads: ${grupoProcesssos.totalThreads}    
    """.trimIndent())

    grupoProcesssos.processos.forEachIndexed { p, processo ->
        println("""
            Processo ${p+1}
            Nome: ${processo.nome}
            PID: ${processo.pid}
            Uso de memória (GB): ${processo.usoMemoria}
            Uso de CPU (%): ${processo.usoCpu}
            
        """.trimIndent())
    }

    val pesquisa = JOptionPane.showInputDialog("Qual processo quer achar?")
    val processosEncontrados = grupoProcesssos.processos.filter{
                                it.nome.contains(pesquisa)}

    if (processosEncontrados.isEmpty()) {
        println("Nenhum processo '$pesquisa' encontrado")
    } else {
        println("${processosEncontrados.size} processos '$pesquisa' encontrados:")
        println()

        processosEncontrados.forEach {
            println("Processo:\r\r$it")
        }
    }

}