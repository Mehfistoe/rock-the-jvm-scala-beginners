package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (static)
  /*
  With objects in Scala, you don't have to make an instance of a class to access it's variables
   */
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2 // equivalent to static
    def canFly: Boolean = false

    // factory method because it's sole purpose is to build other persons
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // Classes and objects with the same name in the same scope are called COMPANIONS

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person // instance of the Person type
    val john = Person
    println(mary == john) // true because they point to the same instance of Person

    val person1 = new Person("Mary")
    val person2 = new Person("John")
    println(person1 == person2) // false because these are two different instances of the class Person

    val bobbie = Person(person1, person2)
  }

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
