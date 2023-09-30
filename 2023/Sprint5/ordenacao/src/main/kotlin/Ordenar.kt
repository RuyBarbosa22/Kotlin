object Ordenar {

    fun selectionSort(arr: IntArray): Pair<IntArray, Pair<Int, Int>> {
        var comparisons = 0
        var swaps = 0
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIdx = i
            for (j in i + 1 until n) {
                comparisons++
                comparisons++
                if (arr[j] < arr[minIdx]) {
                    minIdx = j
                }
            }
            val temp = arr[minIdx]
            arr[minIdx] = arr[i]
            arr[i] = temp
            swaps++
        }
        return Pair(arr, Pair(comparisons, swaps))
    }

    fun selectionSortOtimizado(arr: IntArray): Pair<IntArray, Pair<Int, Int>> {
        var comparisons = 0
        var swaps = 0
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIdx = i
            for (j in i + 1 until n) {
                comparisons++
                if (arr[j] < arr[minIdx]) {
                    minIdx = j
                }
            }
            val temp = arr[minIdx]
            arr[minIdx] = arr[i]
            arr[i] = temp
            swaps++
        }
        return Pair(arr, Pair(comparisons, swaps))
    }

    fun bubbleSort(arr: IntArray): Pair<IntArray, Pair<Int, Int>> {
        var comparisons = 0
        var swaps = 0
        val n = arr.size
        var swapped: Boolean
        for (i in 0 until n - 1) {
            swapped = false
            for (j in 0 until n - i - 1) {
                comparisons++
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    swaps++
                    swapped = true
                }
            }
            if (!swapped) break
        }
        return Pair(arr, Pair(comparisons, swaps))
    }
}
