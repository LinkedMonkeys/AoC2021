fun main() {
    fun computeTotalDistance(input: List<Int>, distanceTo: Int): Int {
        return input.fold(0) { total, item -> total + Math.abs(distanceTo - item) }
    }

    fun part1(input: List<Int>): Int {
        var smallest = computeTotalDistance(input, 0)
        var count = 1
        var next = computeTotalDistance(input, count++)
        while (smallest >= next) {
            smallest = next
            next = computeTotalDistance(input, count++)
        }

        return smallest
    }

    fun part2(input: List<Int>): Int {
        // Sum_{i=1}^n i = n * (n+1) / 2
        fun gauss(distance: Int): Int {
            return distance*(distance+1)/2
        }

        fun computeTotalDistance(input: List<Int>, distanceTo: Int): Int {
            return input.fold(0) { total, item -> total + gauss(Math.abs(distanceTo - item)) }
        }

        var smallest = computeTotalDistance(input, 0)
        var count = 1
        var next = computeTotalDistance(input, count++)
        while (smallest >= next) {
            smallest = next
            next = computeTotalDistance(input, count++)
        }

        return smallest
    }

    val input = readInput("input")
    println(part1(input))
    println(part2(input))
}