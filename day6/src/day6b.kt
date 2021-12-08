import java.io.File
import java.math.BigInteger

fun main() {
    val numbers = File("input.txt")
        .bufferedReader()
        .use { it.readLine() }
        .split(",")
        .map { it.toInt() }

    var currentGeneration = numbers.fold(Array(9, { _ -> BigInteger.ZERO })) { list, element ->
        list[element]++
        list
    }

//    currentGeneration.forEachIndexed { index, item -> println("$index: $item") }
    for (i in 1..256) {
        currentGeneration = createNextGeneration2(currentGeneration)
    }
    println(currentGeneration.reduce { total, item -> total + item })
}

fun createNextGeneration2(currentGeneration: Array<BigInteger>): Array<BigInteger> {
    var copy = Array(9) { _ -> BigInteger.ZERO }
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
