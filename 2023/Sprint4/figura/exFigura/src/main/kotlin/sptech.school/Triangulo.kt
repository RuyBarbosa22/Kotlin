package Main

class Triangulo(
    cor:String,
    espessura:Int,
    private var base:Double,
    private var altura:Double
):Figura(cor, espessura) {

    override fun calcularArea(): Double {
        return base * altura / 2
    }

    override fun toString(): String {
        return "Triangulo:(${super.toString()},valor da area=${calcularArea()})"
    }


}