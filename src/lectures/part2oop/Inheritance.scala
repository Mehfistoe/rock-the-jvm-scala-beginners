package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance - extend one class at a time
  sealed class Animal {
    val creatureType: String = "wild"
    // private def eat = println("nomnom") // private - only use in this class
    def eat = println("nomnom") // protected - only use in this class and subclasses

  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  /*class Dog(dogType: String) extends Animal {
    override val creatureType: String = dogType
  }*/
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other files

}
