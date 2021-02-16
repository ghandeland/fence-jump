class Ball(var vPos: Int = 4) {

    fun getRow(): String {
        return " ".repeat(10).replaceRange(vPos..vPos, "O")
    }

    fun setPos(pos: Int) {
        if(pos > -1 && pos < 10) {
            vPos = if(pos == 0) 9 else pos - 1
        }
    }
}