package aula2308

class Relogio {
    lateinit var modelo: String
    var preco: Double = 0.0
    var horas: Int = 0
    var minutos: Int = 0
    var segundos: Int = 0

    fun zerarRelogio() {
        horas = 0
        minutos = 0
        segundos = 0
    }

    fun validar(): String {
        var valido = true
        if (horas < 0 || horas > 23){
            valido = false
            horas = 0
        }
        if (minutos < 0 || minutos > 59){
            valido = false
            minutos = 0
        }
        if (segundos < 0 || segundos > 59){
            valido = false
            segundos = 0
        }
        var resultado = if (valido)
                "Todos os valores estavam corretos!"
                 else
                "Valores inválidos identificados. Ajustando"
        return resultado
    }

    fun verHora(): String {
        validar()
        return "${horas.toString().padStart(2,'0')}:${minutos.toString().padStart(2,'0')}:" +
                "${segundos.toString().padStart(2,'0')}"
    }
}