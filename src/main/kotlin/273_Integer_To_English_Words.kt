fun main() {
    fun numberToWords(num: Int): String {
        val ones = listOf(
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
        )
        val decs = listOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
        val nums = num.toString()

        fun convertThree(nums: String, suffix: String): String {
            var result: String
            if (nums.isEmpty()) {
                result = ""
            } else if (nums.length == 1) {
                result = ones[nums[0].digitToInt()]
            } else if (nums.length == 2) {
                if (nums.toInt() < 20) {
                    result = ones[nums.toInt()]
                } else {
                    result = decs[nums[0].digitToInt()]
                    if (nums[1].digitToInt() > 0){
                        result += " ${ones[nums[1].digitToInt()]}"
                    }
                }
            } else {
                val first = nums[0].digitToInt()
                val second = nums[1].digitToInt()
                val third = nums[2].digitToInt()
                val lastTwo = nums.takeLast(2).toInt()
                if (lastTwo < 20) {
                    result = ones[lastTwo]
                } else {
                    result = decs[second]
                    if (third > 0){
                        result += " ${ones[third]}"
                    }
                }
                result = (if (first == 0) "" else "${ones[first]} Hundred ") + result
            }
            if (suffix.isNotEmpty() && result.isNotEmpty()) {
                result += " $suffix"
            }
            return " $result"
        }
        if (num == 0) return "Zero"
        val len = nums.length
        var result = convertThree(nums.substring(maxOf(0, len - 3) until len), "")
        if (len > 3) result = convertThree(nums.substring(maxOf(0, len - 6) until len - 3), "Thousand") + result
        if (len > 6) result = convertThree(nums.substring(maxOf(0, len - 9) until len - 6), "Million") + result
        if (len > 9) result = convertThree(nums.substring(maxOf(0, len - 12) until len - 9), "Billion") + result
        return result.replace("\\s+".toRegex(), " ").trim()
    }

    val num = readln().toInt()
    println(numberToWords(num))
}
