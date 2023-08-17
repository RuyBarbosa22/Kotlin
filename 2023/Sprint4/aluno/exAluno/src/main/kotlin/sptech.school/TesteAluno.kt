package main

fun main(array: Array<String>) {


    val aluno1 = AlunoFundamental("Ruy", 12, 9.0, 8.3, 3.6, 9.0)
    val aluno2 = AlunoFundamental("Maria", 23, 6.0, 10.0, 8.0, 9.9)
    val aluno3 = AlunoFundamental("Kaue", 35, 7.4, 6.0, 8.2, 4.2)
    val aluno4 = AlunoGraduacao("Paulo", 47, 7.4, 9.0)
    val aluno5 = AlunoPos("Bruna", 52, 9.7, 8.0, 9.0)

    val escola = Escola("Pedro Taques")

    escola.addAluno(aluno1)
    escola.addAluno(aluno2)
    escola.addAluno(aluno3)
    escola.addAluno(aluno4)
    escola.addAluno(aluno5)

    escola.getTodos()
    escola.getAlunoGraduacao()
    escola.getAlunoGraduacao()
    escola.getAluno(12)

}