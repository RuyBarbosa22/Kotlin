package Main

class Retangulo(
    cor:String,
    espessura:Int,
    private var base:Double,
    private var altura:Double
):Figura(cor, espessura) {

    override fun calcularArea(): Double {
        return base * altura
    }

    override fun toString(): String {
        return "Retangulo:(${super.toString()},valor da area=${calcularArea()})"
    }


}