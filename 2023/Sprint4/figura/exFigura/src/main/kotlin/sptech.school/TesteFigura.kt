package Main

fun main(array: Array<String>) {


    val figura1 = Quadrado("Verde",  8,  8.0)
    val figura2 = Retangulo("Roxo",  6,  9.0,   14.0)
    val figura3 = Triangulo("Ciano",  4,  17.0,  18.0)
    val figura4 = Circulo("Vermelho",  2,  6.0)

    val imagem = Imagem()

    imagem.addFigura(figura1)
    imagem.addFigura(figura2)
    imagem.addFigura(figura3)
    imagem.addFigura(figura4)

    imagem.getFiguras()
    imagem.getSomaAreasImagem()
    imagem.getFigurasComMaiorArea()
    imagem.getFigurasQuadrado()
}