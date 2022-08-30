class Lutador {
    lateinit var nome: String
    var forcaAtaque: Double = 0.0
    var forcaDefesa: Double = 0.0
    var vidaAtual: Double = 100.0
    var golpesSofridos = mutableListOf<Double>()


    fun concentrar(): Double {
        vidaAtual *= 1.05
        return vidaAtual
    }

    fun treinarLeve(semanas: Int) {
        forcaAtaque += semanas
    }

    fun treinarForte(semanas: Int) {
        forcaAtaque += (semanas*3)
    }

    fun apanhar(quemBate: Lutador) {
        if (quemBate.forcaAtaque > forcaDefesa){
            var dano = quemBate.forcaAtaque - forcaDefesa
            vidaAtual -= dano
            golpesSofridos.add(quemBate.forcaAtaque)
        }else{
            return
        }
        if (vidaAtual < 0.0){
            vidaAtual = 0.0
        }
    }

    fun descrever(): String {
        return "Lutador $nome tem ${"%.2f".format(vidaAtual)} de vida e já recebeu ${golpesSofridos.size} golpes"
    }

}