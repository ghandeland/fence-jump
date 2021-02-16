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

    printTitle()
    Game().start()
}

fun printTitle() {
    println("\n\nFENCE JUMP")
}


