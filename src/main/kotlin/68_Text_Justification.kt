import java.lang.StringBuilder

fun main() {
    val words = readln().split(" ").toTypedArray()
    val maxWidth = readln().toInt()
    println(fullJustify(words, maxWidth))
}

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    val lineWords = mutableListOf<String>()
    var lineLength = 0

    for (word in words) {
        when {
            lineLength + word.length + lineWords.size <= maxWidth -> {
                lineWords.add(word)
                lineLength += word.length
            }
            else -> {
                result.add(createLine(lineWords, maxWidth, lineLength))
                lineWords.clear()
                lineWords.add(word)
                lineLength = word.length
            }
        }
    }

    if (lineWords.isNotEmpty()) {
        result.add(lineWords.joinToString(" ").padEnd(maxWidth))
    }

    return result
}

fun createLine(lineWords: MutableList<String>, maxWidth: Int, lineLength: Int): String =
    when {
        lineWords.size == 1 -> lineWords[0].padEnd(maxWidth)
        else -> {
            val line = StringBuilder()
            val gapLength = (maxWidth - lineLength) / (lineWords.size - 1)
            val extraGapCount = (maxWidth - lineLength) % (lineWords.size - 1)
            for (i in 0 until lineWords.size - 1) {
                line.append(lineWords[i])
                line.append(" ".repeat(gapLength))
                if (i < extraGapCount) {
                    line.append(" ")
                }
            }
            line.append(lineWords.last())
            line.toString()
        }
    }
