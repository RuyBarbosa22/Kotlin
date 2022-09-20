//criando uma classe usando um construtor
class Relogio(
    var horas: Int = 0,
    var minutos: Int = 0,
    var segundos: Int = 0
){



    fun horaAtual():String {
        return "Hora atual: $horas:$minutos:$segundos"
    }

    fun adicionarHora(maisHoras:Int, maisMinutos:Int, maisSegundos:Int){
        if (maisHoras<=24){
            if (maisHoras+horas >23){
                var sobra = (maisHoras + horas) - 24
                horas = sobra
            }else {
                horas+=maisHoras
            }
        }
        if (maisMinutos <=60){
            if (maisMinutos+minutos>59){
                var sobra = (maisMinutos + minutos) - 59
                minutos = sobra
            }else{
                minutos+=maisMinutos
            }
        }
        if (maisSegundos<=60){
            segundos+=maisSegundos
        }

    }
}