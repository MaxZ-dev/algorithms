package medium.the_cheapest_way

fun theCheapestWayAlgorithm(input: MutableList<MutableList<Int>>) { // по факту, алгоритм дейкстры
    val result = mutableListOf<MutableList<Int>>()
    for (i in 0..<input.size) {
        result.add(mutableListOf())
        for (j in 0..<input[0].size) {
            if (input[i].getOrNull(j - 1) != null) {
                if (result[i].getOrNull(j) == null) {
                    result[i].add(input[i][j] + result[i][j - 1])
                } else {
                    if (input[i][j] + result[i][j - 1] < result[i][j]) {
                        result[i][j] = input[i][j] + result[i][j - 1]
                    }
                }
            }
            if (input.getOrNull(i - 1) != null) {
                if (input[i - 1].getOrNull(j) != null) {
                    if (result[i].getOrNull(j) == null) {
                        result[i].add(input[i][j] + result[i - 1][j])
                    } else {
                        if (input[i][j] + result[i - 1][j] < result[i][j]) {
                            result[i][j] = input[i][j] + result[i - 1][j]
                        }
                    }
                }
            } else if (input.getOrNull(i - 1) == null && input[i].getOrNull(j - 1) == null) {
                result[i].add(input[i][j])
            }
        }
    }
    println(result[result.size - 1][result[0].size - 1])
}

fun input(): MutableList<MutableList<Int>> {
    val mapList = mutableListOf<MutableList<Int>>()
    repeat(readln().split(" ")[0].toInt()) {
        mapList.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    return mapList
}

fun main() {
    theCheapestWayAlgorithm(input())
    //test()
}

fun test() {
    println("Тест 1")
    theCheapestWayAlgorithm(
        mutableListOf(
            mutableListOf(67, 31, 16, 37, 42, 8),
            mutableListOf(47, 7, 84, 5, 29, 91),
            mutableListOf(36, 77, 32, 69, 84, 71),
            mutableListOf(30, 16, 32, 46, 24, 82),
            mutableListOf(27, 48, 14, 87, 28, 77)
        )
    )
    println("Правильный ответ: 398 \n")
    println("Тест 2")
    theCheapestWayAlgorithm(
        mutableListOf(
            mutableListOf(1, 1, 1, 1, 1),
            mutableListOf(3, 100, 100, 100, 100),
            mutableListOf(1, 1, 1, 1, 1),
            mutableListOf(2, 2, 2, 2, 1),
            mutableListOf(1, 1, 1, 1, 1)
        )
    )
    println("Правильный ответ: 11\n")
}