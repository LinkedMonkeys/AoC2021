import java.io.File

fun main() {
    val numbers = File("input.txt")
        .readLines()
        .map { it.toInt() }

    val increasing = numbers
        .windowed(2)
        .fold(0)
        { sum, element -> sum + if (element[1] > element[0]) 1 else 0 }
    println(increasing)

    // count counts all items that meet some criteria.
    val increasing2 =
        numbers
            .windowed(2)
            .count { it[1] > it[0] }
    println(increasing2)

    //    var count = 0
//    var last = numbers[0]
//    for (number in numbers) {
//        if (number > last) {
//            count++;
//        }
//        last = number
//    }
//
//    println(count)
}