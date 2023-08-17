package Main

class Imagem(

) {
    val figuras = mutableListOf<Figura>()

    fun addFigura(figura: Figura){
        this.figuras.add(figura)
    }

    fun getFiguras(){
        println("Figuras:")
        for (figura in figuras){
            println(figura)
        }
        println()
    }

    fun getSomaAreasImagem(){
        var soma = 0.0
        for (figura in figuras){
            soma += figura.calcularArea()
            println("A soma das areas das figuras é: $soma")
        }
    }

    fun getFigurasComMaiorArea(){
        for (figura in figuras){
            if (figura.calcularArea() > 20){
                println(figura)
            }
        }
    }

    fun getFigurasQuadrado(){
        for (figura in figuras){
            if (figura is Quadrado){
                println(figura)
            }
            else{
                println("Não é um quadrado")
            }
        }
    }
}