class Game() {

    val fences = listOf<Fence>(
        Fence(0),
        Fence(3),
        Fence(6),
        Fence(9),
        Fence(12)
        )

    val ball = Ball()

    fun render(ballPosition: Int = -1) {
        println("\n".repeat(15))

        var str = ""
        for(i in 14 downTo 0) {
            if(i == 13) {
                ball.setPos(ballPosition)
                var fenceRow = false
                fences.forEach {
                    if(it.position == i) {
                        val ballInHole = if(it.hole == ball.position) "O" else " "
                        str += it.getString(ballInHole)
                        fenceRow = true
                    }
                }
                if(!fenceRow) str += ball.getString()
            } else {
                fences.forEach {
                    if(it.position == i) {
                        str += it.getString()
                    }
                }
            }

            str += "\n"
        }
        println(str)
    }

    fun moveFences() {
        for(f in fences) {
            if(f.position > 13) {
                f.newHole()
                f.position = 0
            } else {
                f.position++
            }
        }
    }
}