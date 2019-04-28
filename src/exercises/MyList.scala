package exercises

abstract class MyList {

  /*
     head = first element of the list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(i: Int): MyList
}

object Empty extends MyList {
  def head: Int =  throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(i: Int): MyList = new Cons(i, Empty)
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(i: Int): MyList = new Cons(i, this)
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
}