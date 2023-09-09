package solving//fun main() {
//    val s = readln()
//    println(longestPalindrome(s))
//}
//
//fun longestPalindrome(s: String): String {
//    var startIndex = 0
//    var result = s[0].toString()
//    while (s.length - startIndex > result.length) {
//        var endIndex = s.lastIndex
//        while (endIndex - startIndex + 1> result.length) {
//            if (s[startIndex] == s[endIndex]) {
//                var isPalindrome = true
//                var start = startIndex
//                var end = endIndex
//                while (start <= end && isPalindrome) {
//                    isPalindrome = s[start++] == s[end--]
//                }
//                if (isPalindrome) {
//                    result = s.substring(startIndex, endIndex + 1)
//                }
//            }
//            endIndex--
//        }
//        startIndex++
//    }
//    return result
//}
//
