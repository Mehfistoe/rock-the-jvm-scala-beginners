package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 27)
  println(person)
  // age and name are class parameters but not class MEMBERS. They can't be accessed like person.name
  println(person.age)
  println(person.x)
  person.greeting("Daniel")
  person.greeting()


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
