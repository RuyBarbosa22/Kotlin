package sptech.school.herancaagregacao

fun main() {

    val desenvolvedor1 = Desenvolvedor("João", 160, 100.0)
    val desenvolvedor2 = Desenvolvedor("Pedro", 160, 100.0)
    val desenvolvedorMobile1 = DesenvolvedorMobile("Leonardo", 160, 100.0, 160, 150.0)
    val desenvolvedorMobile2 = DesenvolvedorMobile("Felipe", 160, 100.0, 160, 150.0)

    val consultoria1 = Consultoria("SPTech", 3)

    desenvolvedor1.getSalario()
    desenvolvedorMobile1.getSalario()

    consultoria1.existePorNome("Pedro")
    consultoria1.contratar(desenvolvedor2)
    consultoria1.contratar(desenvolvedorMobile2)
    consultoria1.existePorNome("Pedro")
    consultoria1.getQuantidadeDesenvolvedores()
    consultoria1.getQuantidadeDesenvolvedoresMobile()
    consultoria1.getTotalSalarios()
    consultoria1.buscarDesenvolvedorPorNome("Felipe")
}