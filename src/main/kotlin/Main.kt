fun main(){
    val snake = Snake(10, 10)
    val game = Room.getInstance(20, 20, snake)
    game.snake.direction = SnakeDirection.DOWN
    game.snake.isAlive = true

    game.createMouse()
    game.run()
}