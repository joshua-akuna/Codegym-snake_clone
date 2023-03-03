class Room constructor(
    val width: Int,
    val height: Int,
    val snake: Snake,
){
    // instantiate a Mouse instance
    var mouse: Mouse? = null
    // Implements a singleton for the class
    companion object {
        var INSTANCE: Room? = null

        fun getInstance(
            width: Int,
            height: Int,
            snake: Snake,
        ): Room {
            if (INSTANCE == null){
                INSTANCE = Room(width, height, snake)
            }

            return this.INSTANCE!!
        }
    }
    // creates a Mouse instance at a random position
    // in the Room
    fun createMouse(){
        mouse = Mouse(
            (Math.random() * width).toInt(),
            (Math.random() * height).toInt(),
        )
    }
    // implements the behavior of the snake eating the mouse
    fun eatMouse(){
        createMouse()
    }
    // implementation for running the game
    fun run(){
        var len = 0
        while (snake.isAlive){
            print()

            sleep()
            len++

            if (len == 10) snake.isAlive = false
        }
        println("Game Over")
    }
    // prints the game graphics to standard output
    fun print(){
        val symbols = arrayOf(" . ", " x ", " X ", "^_^", "RIP")
        val board = Array(height) {IntArray(width)}

        for (section in snake.sections!!){
            val (x, y) = section
            board[y][x] = 1
        }

        board[snake.getHeadRow()][snake.getHeadCol()] = if(snake.isAlive) 2 else 4

        board[mouse!!.y][mouse!!.x] = 3

        for (row in 0 until height){
            for (col in 0 until width){
                print("${board[row][col]}\t")
            }
            print("\n")
        }
        println("Game is running")
        print("\n\n")
    }
    // a conditional sleep method
    fun sleep(){
        snake.sections?.size?.also {len ->
            if(len < 11) Thread.sleep(500)
            else if (len < 15) Thread.sleep(300)
            else Thread.sleep(200)
        }
    }
}