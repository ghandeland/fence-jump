import kotlin.random.Random

class Fence(var position: Int = 0, var hole: Int = Random.nextInt(10)) {

    fun getString(fillHole: String = " "): String {
        return "#".repeat(10).replaceRange(hole..hole, fillHole)
    }

    fun newHole() { hole = Random.nextInt(10) }
}