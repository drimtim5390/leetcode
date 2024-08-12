class KthLargest(k: Int, nums: IntArray) {
    private val kk = k
    val list = mutableListOf<Int>()

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun add(`val`: Int): Int {
        if (list.size == kk && `val` > list.first()) {
            list.removeFirst()
        }
        if (list.size < kk) {
            val index = list.binarySearch(`val`)
            val insertionIndex = if (index < 0) -index - 1 else index
            list.add(insertionIndex, `val`)
        }
        return list.first()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */