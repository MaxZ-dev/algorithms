package yandex_5.contest_3

fun main() {
    val preResultMap = mutableMapOf<String, Int>()
    val result = mutableListOf<String>()
    val quanityPerson = readln().toInt()
    repeat(quanityPerson) {
        readln()
        val input = readln().split(" ").toList()
        for (i in input.indices) {
            if (preResultMap[input[i]] == null) {
                preResultMap[input[i]] = 1
            } else {
                preResultMap[input[i]] = (preResultMap[input[i]] ?: 0) + 1
            }
        }
    }
    preResultMap.forEach { (t, u) -> if (u == quanityPerson) { result.add(t)} }
    println(result.size)
    println(result.sorted().joinToString(" "))
}
