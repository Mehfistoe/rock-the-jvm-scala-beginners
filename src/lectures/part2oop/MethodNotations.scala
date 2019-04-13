package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is ${name} and I like $favoriteMovie"

    def +(title: String) : Person = new Person(s"${this.name} ${title}", this.favoriteMovie)
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age+1)

    def learns(subject: String): String = s"${this.name} learns $subject"
    def leansScala: String = learns("Scala")

    def apply(amount: Int): String = s"${this.name} watched ${this.favoriteMovie} $amount times"


  }


  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (works with methods that have a single parameter) (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  //println(mary hangOutWith tom) // hangOutWith acts as an operator
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))
  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation (only available to methods without parameters)
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  val mary2 = mary + "the rockstar"
  println(mary2.name)

  val otherMary = +mary
  println(otherMary.age)

  println(mary learns "cooking")

  println(mary leansScala)

  println(mary.apply(3))

  /*
    1. Overload the + operator
       mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
       Add a unary + operator => new person with the age + 1
       +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnScala method, class the learns method with "Scala"

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */

}
