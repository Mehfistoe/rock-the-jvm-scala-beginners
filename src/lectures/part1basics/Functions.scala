package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  // parameterless functions can be called without parentheses
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  // Use return type unit for function with just side effects
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

/*
 * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old.
 * 2. Factorial function 1 * 2* 3* 4 ... * n
 * 3. Fibonacci function
 *    f(1) = 1
 *    f(2) = 1
 *    f(n) = f(n - 1) + f(n - 2)
 * 4. Tests if a number is prime
 */

  def aGreetingFunction(name:String, age:Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(aGreetingFunction("McKenzie", 23))

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))

  /*
    fib(6) =
    = fib(5) + fib(4)
    = (fib(4) + fib(3)) + (fib(3) + fib(2))
    = (fib(3) + fib(2)) + (fib(2) + fib(1)) + (fib(2) + fib(1)) + 1
    = (fib(2) + fib(1)) + 1 + 1 + 1 + 1 + 1 + 1
    = 8
   */
  def fibonacci(n: Int): Int = {
    if (n == 1) 1
    else if (n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8))

  def isItPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isItPrime(44))
  println(isItPrime(37))
}
