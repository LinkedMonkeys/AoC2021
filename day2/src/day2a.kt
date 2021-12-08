import java.io.File

fun main() {
    val command = File("test.txt")
        .readLines()
        .map { it.split(" ")}


// First value is horizontal position.  Second is depth.
    val total = command.fold(arrayOf(0, 0)) { pair, element ->
        if (element[0] == "forward") {
            arrayOf(pair[0] + element[1].toInt(), pair[1])
        } else {
            if (element[0] == "up") {
                arrayOf(pair[0], pair[1] - element[1].toInt())
            } else {
                arrayOf(pair[0], pair[1] + element[1].toInt)()
            }
        }
    }

    println("$total[0] $total[1]")
//    commands.fold([0,0]) {total, element ->
//        [total[0]+element, 0]
//}
}