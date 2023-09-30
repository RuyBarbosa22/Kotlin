object BinarySearch {

    fun binarySearch(arr: IntArray, target: Int): Boolean {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                target < arr[mid] -> right = mid - 1
                target > arr[mid] -> left = mid + 1
                else -> return true
            }
        }
        return false
    }
}
