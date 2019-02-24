package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing the factorial of " + n + " - I first need the factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed the factorial of " + n)

      result
    }
  }

  println(factorial(10))
  //println(factorial(5000)) // causes stack overflow due to limited JVM memory and too many calls

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use a recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = factHelper(6, 7 * 8 * 9 * 10 * 1)
      ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * ... * 10 * 1)
    = 3628800
   */

  // we will see zero as this result runs out of integer representation, unless you use BigInt as the return type
  println("Factorial of 5000: " + anotherFactorial(5000))

  // WHEN YOU NEED LOOPS USE *TAIL* RECURSION

  /* 1. Concatenate a string n times with tail recursion
     2. IsPrime function with tail recursion
     3. Fibonacci sequence with tail recursion
   */

  /*
     stringConcat("blah", 5, "")
     = stringConcat("blah", 4, "blah")
     = stringConcat("blah", 3, "blahblah")
     = stringConcat("blah", 2, "blahblahblah")
     = stringConcat("blah", 1, "blahblahblahblah")
     = stringConcat("blah", 0, "blahblahblahblahblah")
   */
  @tailrec
  def stringConcat(x: String, n: Int, sumString: String): String = {
    if (n == 0) sumString
    else stringConcat(x, n-1, sumString+x)
  }
  println(stringConcat("blah", 5, ""))

  def isItPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }
  println(isItPrime(47))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }
  println(fibonacci(8))
}
