package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 27)
  println(person)
  // age and name are class parameters but not class MEMBERS. They can't be accessed like person.name
  println(person.age)
  println(person.x)
  person.greeting("Daniel")
  person.greeting()

  val dfw = new Writer(firstName="David", surname="Foster Wallace", year=1962)
  println(dfw.getFullName() + "'s birth year: " + dfw.year)

  val infiniteJest = new Novel("Infinite Jest", 1996, dfw)
  val newInfiniteJest = infiniteJest.copy(2000)
  println(newInfiniteJest.getAuthorAge())
  println(newInfiniteJest.isWrittenBy())

  var counter = new Counter(0)
  counter = counter.inc()
  counter = counter.inc(5)
  println(counter.current_count())

  counter = counter.dec()
  println(counter.current_count())
  counter = counter.dec(2)
  println(counter.current_count())


}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2
  println(1+3)

  // method
  def greeting(name: String): Unit = println(s"${this.name} says: Hello, $name")

  // overloading
  def greeting(): Unit = println(s"Hello, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
/*
   Class parameters are NOT fields.
   To convert a class parameter to a field, add val or var to the parameter
 */

/*
   Novel and a Writer

   Writer: first name, surname, year
     - method fullname

   Novel: name, year of release, author
     - authorAge
     - isWrittenBy(author)
     - copy (new year of release) = new instance of Novel

 */
class Writer(firstName: String, surname: String, val year: Int) {

  def getFullName(): String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def getAuthorAge(): Int = 2019 - author.year
  def isWrittenBy(author: Writer = author): String = author.getFullName()
  def copy(newYearOfRelease: Int): Novel = {
    new Novel(name=name, yearOfRelease=newYearOfRelease, author=author)
  }
}

/*
   Counter class
     - receives an int value
     - method current count
     - method to increment/decrement => new Counter
     - overload inc/dec to receive an amount
 */

class Counter(i: Int) {

  def current_count(): Int = i
  def inc(): Counter = {
    println("incrementing")
    new Counter(i+1)
  }
  def dec(): Counter = {
    println("decrementing")
    new Counter(i-1)
  }

  def inc(up: Int): Counter = {
    if (up <= 0) this
    else inc.inc(up-1)
  }
  def dec(down: Int): Counter = {
    if (down <= 0) this
    else dec.dec(down-1)
  }
}