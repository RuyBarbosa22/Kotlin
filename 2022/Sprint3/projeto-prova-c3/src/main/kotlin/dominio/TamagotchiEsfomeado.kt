package dominio

class TamagotchiEsfomeado : Tamagotchi() {

    override fun comer(quantidadeRacao: Int) {
        super.comer(quantidadeRacao/2)
    }

}