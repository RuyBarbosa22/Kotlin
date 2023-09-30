fun main() {
    val arrayOriginal = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    val (arrayOrdenado1, estatisticas1) = Ordenar.selectionSort(arrayOriginal.clone())
    println("Selection Sort: ${arrayOrdenado1.joinToString(", ")}, Comparações: ${estatisticas1.first}, Trocas: ${estatisticas1.second}")

    val (arrayOrdenado2, estatisticas2) = Ordenar.selectionSortOtimizado(arrayOriginal.clone())
    println("Selection Sort Otimizado: ${arrayOrdenado2.joinToString(", ")}, Comparações: ${estatisticas2.first}, Trocas: ${estatisticas2.second}")

    val (arrayOrdenado3, estatisticas3) = Ordenar.bubbleSort(arrayOriginal.clone())
    println("Bubble Sort: ${arrayOrdenado3.joinToString(", ")}, Comparações: ${estatisticas3.first}, Trocas: ${estatisticas3.second}")

    val estaPresente = BinarySearch.binarySearch(arrayOrdenado3, 25)
    println("O número 25 está presente: $estaPresente")

    val estaAusente = BinarySearch.binarySearch(arrayOrdenado3, 100)
    println("O número 100 está presente: $estaAusente")
}
