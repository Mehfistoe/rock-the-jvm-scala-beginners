package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // math operators: + - * /
  // bitwise operators: & | ^ << >> >>>(right shift with zero extension)

  println(1 == x)
  // relation operators == != > >= < <=

  println(!(1 == x))
  // boolean operators: ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  /* Instructions (DO) vs Expressions (VALUE)
  Instructions: commands that tell the computer what to do
  Expressions: something that has a value and/or a type
  In functional programming, we think in terms of Expressions or values
   */

  // IF EXPRESSION
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  // WE DISCOURAGE USE OF LOOPS IN SCALA (FUNPRO)
  // Looping is very specific to imperative programming
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN
  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // ()
  // reassigning a variable is a side effect

  // side effects: println(), whiles, reassigning (they all return Unit)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y +1

    if (z > 2) "hello" else "goodbye"
  } // an expression because it's the value of it's last expression

  // 1. What is the difference between he string "Hello world" vs println("hello world")?
  // println("hello world") is a side effect returning Unit while "hello world" is a value of type string

  // 2. What the value of the following:
  val someValue = {
    2 < 3
  }
  // someValue = true

  // 3. What's the value of the following:
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // someOtherValue = 42
}
