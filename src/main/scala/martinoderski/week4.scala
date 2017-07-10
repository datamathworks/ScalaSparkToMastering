package martinoderski

import java.util.NoSuchElementException

/**
  * Created by dorina.stratulat on 7/10/2017.
  */
object week4 extends App{

  trait List[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    def prepend[U >: T](elem: U) = new Cons(elem, this)
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  }

  object Nil extends List[Nothing] {
    def isEmpty = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
      def tail = throw new NoSuchElementException("Nil.tail")
  }

  //define
  //List() //empty list
  //List(1); List(1,2)
  object List {
    def apply[T]() = new Nil
    def apply[T](x1: T) = new Cons(x1, new Nil)
    def apply[T](x1: T, x2: T) = new Cons(x1, new Cons(x2, new Nil))
  }

  object test {
    val x: List[String] = Nil
  }

}
