package dominio

open class Tamagotchi {
    private var nome:String = ""
    private var acordado:Boolean = false
    private var nivelFome:Int = 20
    private var nivelEntendiado:Double = 0.0

    fun temNome():Boolean {
        return nome != ""
    }

    fun getNome():String {
        return nome
    }

    fun isAcordado():Boolean {
        return acordado
    }

    open fun querBrincar():Boolean {
        return nivelEntendiado > 50.0
    }

    fun estaComFome():Boolean {
        return nivelFome > 60.0
    }

    fun mudarNome(novoNome:String) {
        if (novoNome.length > 2) {
            nome = novoNome
            return
        }
    }

    fun acordar() {
        if (!acordado) {
            acordado = true
        }
    }

    fun dormir() {
        if (acordado) {
            acordado = false
        }
    }

    open fun comer(quantidadeRacao:Int) {
        if (acordado) {
            nivelFome -= quantidadeRacao
            if (nivelFome < 0){
                nivelFome = 0
            }
        }
    }

    fun brincar(segundos:Int, minutos:Int) {
        if (acordado) {
            nivelEntendiado -= segundos*0.5
            nivelEntendiado -= minutos*80
            if (nivelEntendiado < 0) {
                nivelEntendiado = 0.0
            }
        }
    }

    fun receberCarinho() {
        if (acordado) {
            nivelEntendiado -= 2.5
            if (nivelEntendiado < 0) {
                nivelEntendiado = 0.0
            }
        }

    }

}