package yandex_5.contest_3

fun main() {
    val words1 = readln().split(" ")
    val dict = mutableMapOf<Int, MutableSet<String>>()
    val result = mutableListOf<String>()

    for (word in words1) {
        dict.computeIfAbsent(word.length) { mutableSetOf() }.add(word)
    }

    val words2 = readln().split(" ")

    for (word in words2) {
        var found = false
        for (i in 1 until word.length) {
            val str = word.substring(0, i)
            if (dict[i]?.contains(str) == true) {
                result.add(str)
                found = true
                break
            }
        }
        if (!found) {
            result.add(word)
        }
    }

    println(result.joinToString(" "))
}