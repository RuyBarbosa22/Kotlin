package Main

abstract class Figura(
    private var cor:String,
    private var espessura:Int,
) {

    abstract fun calcularArea():Double

    override fun toString(): String {
        return "Figura(cor='$cor', espessura=$espessura)"
    }
}