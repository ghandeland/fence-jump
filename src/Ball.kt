class Ball(var position: Int = 4) {

    fun getString(): String {
        return " ".repeat(10).replaceRange(position..position, "O")
    }

    fun setPos(pos: Int) {
        if(pos > -1 && pos < 10)
            if(pos == 0)
                this.position = 9
            else
                this.position = pos - 1
    }
}