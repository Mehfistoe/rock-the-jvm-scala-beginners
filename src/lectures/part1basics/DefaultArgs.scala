package lectures.part1basics

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n-1, n*acc)
  }

  val fact10 = trFact(10)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  //savePicture(800, 900) // compiler is confused since it thinks the first value
                                       // is for the first parameter

  //savePicture() // if all parameters have a default argument, you can run it like this
  /* To avoid confusing the compiler about which argument goes to what with default leading arguments, we can:
     1. pass in every leading argument
     2. name the arguments
   */
  savePicture(width = 1920, height = 1080)
}
