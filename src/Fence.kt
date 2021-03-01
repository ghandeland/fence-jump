import kotlin.random.Random

class Fence(var verticalPos: Int = 0, var hole: Int = Random.nextInt(10)) {

    fun getRow(ballInHole: Boolean = false): String {
        val s = if(ballInHole) "O" else " "
        return "#".repeat(10).replaceRange(hole..hole, s)
    }

    fun newHole() { hole = Random.nextInt(10) }
}