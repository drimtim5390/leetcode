fun main() {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()

        fun calc(combination: MutableList<Int>, remain: Int, index: Int) {
            if (remain < 0) return
            if (remain == 0) {
                result.add(ArrayList(combination))
                return
            }
            for (i in index..candidates.lastIndex) {
                if (remain < candidates[i]) return
                if (i > index && candidates[i] == candidates[i - 1]) continue
                combination.add(candidates[i])
                calc(combination, remain - candidates[i], i + 1)
                combination.removeLast()
            }
        }

        candidates.sort()
        calc(mutableListOf(), target, 0)
        return result.toList()
    }

    val candidates = readln().replace("[", "").replace("]", "").split(",").map { it.toInt() }.toIntArray()
    val target = readln().toInt()
    println(combinationSum2(candidates, target).joinToString("\n") { it.joinToString(",") })
}
