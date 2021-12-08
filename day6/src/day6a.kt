import java.io.File

fun main() {
    val numbers = File("input.txt")
        .bufferedReader()
        .use { it.readLine() }
        .split(",")
        .map { it.toInt() }

    var currentGeneration = numbers.fold(Array(9, { _ -> 0 })) { list, element ->
        list[element]++
        list
    }

//    currentGeneration.forEachIndexed { index, item -> println("$index: $item") }
    for (i in 1..80) {
        currentGeneration = createNextGeneration(currentGeneration)
    }
    println(currentGeneration.reduce { total, item -> total+item })
}

fun createNextGeneration(currentGeneration: Array<Int>): Array<Int> {
    var copy = Array(9) { _ -> 0 }
    currentGeneration.forEachIndexed { index, item ->
        println("--$index: $item")
        if (index > 0) {
            copy[index - 1] += item
        } else {
            copy[6] += item
            copy[8] += item
        }
    }

    return copy
}
