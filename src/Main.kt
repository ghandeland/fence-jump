import java.util.*

fun main(args: Array<String>) {

    println("\nFENCE JUMP")
    var sleepVal = 600L

    gameLoop@while(true) {
        print("\nSelect difficulty (easy/medium/hard) or type 'q' to quit: ")
        val prompt = Scanner(System.`in`).next()
        when(prompt.toLowerCase()) {
            "e", "easy" -> sleepVal = 800
            "m", "medium" -> sleepVal = 600
            "h", "hard" -> sleepVal = 300
            "q", "quit" -> break@gameLoop
        }
        Game(sleepVal).start()
    }
}


