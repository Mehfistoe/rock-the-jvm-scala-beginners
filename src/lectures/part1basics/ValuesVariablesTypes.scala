package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  //x = 2 is wrong. VALS ARE IMMUTABLE

  val aString: String = "Hello!"
  val another: String = "Goodbye!"

  val aBoolean: Boolean = true // or false

  val aChar: Char = 'a' // single quotes for characters, double for strings

  val aShort: Short = 4613 // if a number is too long, it's invalid
  val aLong: Long = 123456789889749875L // L make a long number a valid Long type
  val aFloat: Float = 2.0f // without the f, the compiler sees a double
  val aDouble: Double = 2.0

  // variables are mutable
  var aVariable: Int = 4
  aVariable = 5 //
}
