package yandex_5.contest_3

data class InputData(val listOne: List<Int>, val listTwo: List<Int>, val listTree: List<Int>)

fun main() {
    algorithm(input())
}

fun algorithm(input: InputData) {
    val result = mutableListOf<Int>()
    val dictionary = mutableMapOf<Int, Int>()
    for (element in 0..<input.listOne.size) {
        if (dictionary.getOrDefault(input.listOne[element], null) == null) {
            dictionary[input.listOne[element]] = 1
        } else {
            dictionary[input.listOne[element]] = dictionary[input.listOne[element]]!! + 1
        }
    }
    for (element in 0..<input.listTwo.size) {
        if (dictionary.getOrDefault(input.listTwo[element], null) == null) {
            dictionary[input.listTwo[element]] = 1
        } else {
            dictionary[input.listTwo[element]] = dictionary[input.listTwo[element]]!! + 1
        }
    }
    for (element in 0..<input.listTree.size) {
        if (dictionary.getOrDefault(input.listTree[element], null) == null) {
            dictionary[input.listTree[element]] = 1
        } else {
            dictionary[input.listTree[element]] = dictionary[input.listTree[element]]!! + 1
        }
    }
    dictionary.forEach { (t, u) ->
        if (u > 1) {
            result.add(t)
        }
    }
    println(result.sorted().joinToString(" "))
}

fun input(): InputData {
    readln()
    val listOne = readln().split(" ").map { it.toInt() }.toList().distinct()
    readln()
    val listTwo = readln().split(" ").map { it.toInt() }.toList().distinct()
    readln()
    val listTree = readln().split(" ").map { it.toInt() }.toList().distinct()
    return InputData(listOne, listTwo, listTree)
}