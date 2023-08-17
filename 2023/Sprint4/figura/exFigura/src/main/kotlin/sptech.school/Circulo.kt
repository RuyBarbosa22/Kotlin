package Main

class Circulo(
    cor:String,
    espessura:Int,
    private var raio:Double,
):Figura(cor, espessura) {

    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }

    override fun toString(): String {
        return "Triangulo:(${super.toString()},valor da area=${calcularArea()})"
    }


}