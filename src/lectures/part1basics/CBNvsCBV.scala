package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  /* => delays the evaluation of the expression passed as a parameter  and it's used literally every time it
     is used in the function definition
   */
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  /* the exact value of System.nanoTime is computed before the function evaluates
     calledByValue(System.nanoTime()) = {
       println("by value: " + 367186027521427L)
       println("by value: " + 367186027521427L)
     }
   */
  calledByValue(System.nanoTime())
  /* System.nanoTime() is passed literally as is
     calledByName(System.nanoTime()) = {
       println("by name: " + System.nanoTime())
       println("by name: " + System.nanoTime())
     }
   */
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) causes a stack overflow error
  printFirst(34, infinite()) // this works because infinite() is never used in the function so it's never evaluated

}
