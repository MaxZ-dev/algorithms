package yandex_5.contest_3
/* В данном алгоритме есть проблемма с эффективностью,
 я позже подумаю как исправить. При больших данных он не успевает за 1 секунду
 Задачу сдал на пайтоне
 Вводные данные, по которым алгоритм тормозит в отдельном файле
 */
fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.sorted()

    var result = n
    var left = 0
    for (right in 0 until n) {
        while (a[right] - a[left] > 1) {
            left++
        }
        result = minOf(result, n - (right - left + 1))
    }
    println(result)
}
