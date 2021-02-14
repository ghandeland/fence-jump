import java.lang.Thread.sleep
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.schedule
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.system.exitProcess

fun main(args: Array<String>) {


    var g = Game()
    var i = AtomicInteger(4)

    val t = Thread {
        val scanner = Scanner(System.`in`)
        while(true) {
            i.set(scanner.nextInt())
            sleep(100)
        }
    }
    t.isDaemon = true
    t.start()

    while(true) {
        Thread.sleep(600)
        g.render(i.get())
        g.moveFences()
    }

}


