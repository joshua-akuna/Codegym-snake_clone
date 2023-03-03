class Snake constructor(
    var x: Int,
    var y: Int,
){
    var sections: ArrayList<SnakeSection>? = null
    var direction: SnakeDirection? = null
    var isAlive = false

    init {
        // creates the head of the snake
        val head = SnakeSection(x, y)
        // initializing the sections variable
        sections = ArrayList()
        // adds the head as the first element of the snake sections
        sections?.add(head)
    }

    fun getHeadCol(): Int{
        return sections?.get(0)!!.x
    }

    fun getHeadRow(): Int{
        return sections?.get(0)!!.x
    }

    fun move(){

    }
}