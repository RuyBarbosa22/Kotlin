package Main

class Quadrado(
    cor:String,
    espessura:Int,
    private var lado:Double
):Figura(cor, espessura) {

    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun toString(): String {
        return "Quadrado:(${super.toString()},valor da area=${calcularArea()})"
    }


}