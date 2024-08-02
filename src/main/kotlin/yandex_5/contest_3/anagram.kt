package yandex_5.contest_3

import kotlin.system.exitProcess

fun main() {
    val one = readln().toList()
    val two = readln().toList()

    if (one.size != two.size) {
        println("NO")
        exitProcess(0)
    }
    val frequencyOne = mutableMapOf<Char, Int>()
    val frequencyTwo = mutableMapOf<Char, Int>()
    // Подсчет частоты символов в первой строке
    for (char in one) {
        frequencyOne[char] = frequencyOne.getOrDefault(char, 0) + 1
    }
    // Подсчет частоты символов во второй строке
    for (char in two) {
        frequencyTwo[char] = frequencyTwo.getOrDefault(char, 0) + 1
    }
    // Сравнение отображений частот
    if (frequencyOne == frequencyTwo) {
        println("YES")
    } else {
        println("NO")
    }
}
