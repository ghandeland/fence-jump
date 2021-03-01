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

    private val ball = Ball()
    private var running = AtomicBoolean(false)
    private var input = AtomicInteger(5)

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
        inputThread.isDaemon
        inputThread.start()
        while(running.get()) {
            ball.setPos(input.get())
            render()
            moveFences()
            Thread.sleep(600)
        }
    }

    private fun render() {
        println("\n".repeat(15))
        var str = ""
        renderLoop@ for(i in 14 downTo 0) {
            if(i == 13) {
                for(fence in fences) {
                    if(fence.verticalPos == i) {
                        if(fence.hole == ball.horizontalPos) {
                            str += fence.getRow(true) + "\n"
                            continue@renderLoop
                        } else {
                            str += fence.getRow().replaceRange(ball.horizontalPos..ball.horizontalPos, "X") + "\n"
                            running.set(false)
                            continue@renderLoop
                        }
                    }
                }
                str += ball.getRow()
            } else {
                for(f in fences) {
                    if(f.verticalPos == i) str += f.getRow()
                }
            }
            str += "\n"
        }
        println(str)
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
}