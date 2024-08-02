package yandex_5.contest_3

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    val visited = mutableSetOf<Int>()

    for (i in 0 until n) {
        if (numbers[i] in visited) {
            println("YES")
            return
        }
        visited.add(numbers[i])
        if (i >= k) {
            visited.remove(numbers[i - k])
        }
    }
    println("NO")
}
