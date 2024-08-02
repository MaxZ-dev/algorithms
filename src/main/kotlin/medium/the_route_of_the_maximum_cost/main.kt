package medium.the_route_of_the_maximum_cost

fun choiceDirection(input: MutableList<MutableList<Int>>) {
    val resultDirectionReverse = mutableListOf<Char>()
    var i = input.size - 1
    var j = input[0].size - 1
    while (true) {
        when {
            i == 0 && j == 0 -> break
            i == 0 -> {
                resultDirectionReverse.add('R')
                j--
            }

            j == 0 -> {
                resultDirectionReverse.add('D')
                i--
            }

            else -> {
                if ((input[i - 1][j] > input[i][j - 1])) {
                    resultDirectionReverse.add('D')
                    i--
                } else {
                    resultDirectionReverse.add('R')
                    j--
                }
            }
        }
    }
    val resultDirection = resultDirectionReverse.asReversed()
    println(resultDirection.joinToString(" "))
}

fun theRouteOfTheMaximumCostAlgorithm(input: MutableList<MutableList<Int>>) { // по факту, алгоритм дейкстры
    val result = mutableListOf<MutableList<Int>>()
    for (i in 0..<input.size) {
        result.add(mutableListOf())
        for (j in 0..<input[0].size) {
            if (input[i].getOrNull(j - 1) != null) {
                if (result[i].getOrNull(j) == null) {
                    result[i].add(input[i][j] + result[i][j - 1])
                } else {
                    if (input[i][j] + result[i][j - 1] > result[i][j]) {
                        result[i][j] = input[i][j] + result[i][j - 1]

                    }
                }
            }
            if (input.getOrNull(i - 1) != null) {
                if (input[i - 1].getOrNull(j) != null) {
                    if (result[i].getOrNull(j) == null) {
                        result[i].add(input[i][j] + result[i - 1][j])
                    } else {
                        if (input[i][j] + result[i - 1][j] > result[i][j]) {
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
    choiceDirection(result)
}

fun input(): MutableList<MutableList<Int>> {
    val mapList = mutableListOf<MutableList<Int>>()
    repeat(readln().split(" ")[0].toInt()) {
        mapList.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }
    return mapList
}

fun main() {
    theRouteOfTheMaximumCostAlgorithm(input())
//    test()
}

fun test() {
    println("Тест 1")
    theRouteOfTheMaximumCostAlgorithm(
        mutableListOf(
            mutableListOf(9, 9, 9, 9, 9),
            mutableListOf(3, 0, 0, 0, 0),
            mutableListOf(9, 9, 9, 9, 9),
            mutableListOf(6, 6, 6, 6, 8),
            mutableListOf(9, 9, 9, 9, 9)
        )
    )
    println(
        "Правильный ответ: \n74\n" +
                "D D R R R R D D \n"
    )
}