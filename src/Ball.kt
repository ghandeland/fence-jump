class Ball(var horizontalPos: Int = 5) {

    fun getRow(): String {
        return " ".repeat(10).replaceRange(horizontalPos..horizontalPos, "O")
    }

    fun setPos(pos: Int) {
        if(pos > -1 && pos < 10) {
            horizontalPos = if(pos == 0) 9 else pos - 1
        }
    }
}