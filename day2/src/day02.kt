fun main() {

    fun part1(input: List<List<String>>): Int {
        var horizontal = 0
        var depth = 0
        input.forEach() {
            when (it[0]) {
             "forward" -> horizontal += it[1].toInt()
             "down" -> depth += it[1].toInt()
             "up" -> depth -= it[1].toInt()
            }
        }
        return horizontal * depth;
    }

    fun part2(input: List<List<String>>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach() {
            when (it[0]) {
                "forward" -> {
                    horizontal += it[1].toInt()
                    depth += aim * it[1].toInt()
                }
                "down" -> aim += it[1].toInt()
                "up" -> aim -= it[1].toInt()
            }
        }
        return horizontal * depth;
    }

    // input comes back as List of String pairs. e.g., ["forward", "10"]
    val input = readInput("input")
    println(input[0][0].javaClass.name)
    println(part1(input))
    println(part2(input))
}