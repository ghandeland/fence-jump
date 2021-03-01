import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class Game {

    private val fences = listOf(
        Fence(0),
        Fence(3),
        Fence(6),
        Fence(9),
        Fence(12)
        )

    private val sb = StringBuilder()
    private val ball = Ball()
    private var running = AtomicBoolean(false)
    private var input = AtomicInteger(5)
    private var score = 0

    private val inputThread = Thread {
        val scanner = Scanner(System.`in`)
        while(running.get()) {
            input.set(scanner.nextInt())
            Thread.sleep(100)
        }
    }

    fun start() {
        fences[4].hole = 4
        running.set(true)
        inputThread.isDaemon = true
        inputThread.start()
        while(running.get()) {
            ball.setPos(input.get())
            render()
            moveFences()
            Thread.sleep(600)
        }
    }

    private fun render() {
        sb.clear()
        sb.append("\n".repeat(10))
            .append("       Score: $score\n\n")

        renderLoop@ for(i in 14 downTo 0) {
            if(i == 13) {
                for(fence in fences) {
                    if(fence.verticalPos == i) {
                        if(fence.hole == ball.horizontalPos) {
                            score++
                            sb.appendS(fence.getRow(true))
                            continue@renderLoop
                        } else {
                            sb.appendS(fence.getRow().replaceRange(ball.horizontalPos..ball.horizontalPos, "X"))
                            running.set(false)
                            continue@renderLoop
                        }
                    }
                }
                sb.appendS(ball.getRow())
                continue@renderLoop
            } else {
                for(fence in fences) {
                    if(fence.verticalPos == i) {
                        sb.appendS(fence.getRow())
                        continue@renderLoop

                    }
                }
            }
            sb.appendS(" ".repeat(10))
        }
        println(sb.toString())
    }

    private fun moveFences() {
        for(f in fences) {
            if(f.verticalPos > 13) {
                f.newHole()
                f.verticalPos = 0
            } else {
                f.verticalPos++
            }
        }
    }

    private fun java.lang.StringBuilder.appendS(str: String) {
        this.append("     |")
            .append(str)
            .append("|\n")
    }
}

