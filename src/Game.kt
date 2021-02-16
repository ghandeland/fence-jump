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
    private var input = AtomicInteger(4)

    private val inputThread = Thread {
        val scanner = Scanner(System.`in`)
        while(running.get()) {
            input.set(scanner.nextInt())
            Thread.sleep(100)
        }
    }

    fun start() {
        inputThread.isDaemon
        inputThread.start()
        while(true) {
            Thread.sleep(600)
            render()
            moveFences()
        }
    }

    private fun render() {
        println("\n".repeat(15))
        var str = ""
        for(i in 14 downTo 0) {
            if(i == 13) {
                ball.setPos(input.get())
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

    private fun moveFences() {
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