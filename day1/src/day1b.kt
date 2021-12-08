import java.io.File

fun main() {
    val numbers = File("input.txt")
        .readLines()
        .map { it.toInt() } // This is the lambda style.

    val answerb =
        numbers
            .windowed(4)
            .count { it[3] > it[0] }  // Since the "middle two" are shared and not important.

    println(answerb)
}