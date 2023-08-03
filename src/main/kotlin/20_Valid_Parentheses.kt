fun main() {
    val s = readln()
    println(isValid(s))
}

fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()
    for (c in s) {
        if (c.isOpening()) {
            stack.add(c)
        } else if(c.isClosingFor(stack.lastOrNull())) {
            stack.removeAt(stack.size - 1)
        } else {
            return false
        }
    }
    return stack.size == 0
}

fun Char.isOpening(): Boolean {
    return when (this) {
        '{', '(', '[' -> true
        else -> false
    }
}

fun Char.isClosingFor(it: Char?): Boolean {
    return when {
        this == '}' && it == '{' -> true
        this == ')' && it == '(' -> true
        this == ']' && it == '[' -> true
        else -> false
    }
}