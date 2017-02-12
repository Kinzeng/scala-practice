// split a list into two parts
// the length of the first part is given, use a Tuple for the result

// very roundabout way of doing it
// def split[T](n: Int)(list: List[T]): (List[T], List[T]) = {
//  val (head, tail) = list.zipWithIndex.span(_._2 < n)
//  (head.map(_._1), tail.map(_._1))
//}

// can just use the built in
// list.splitAt(n)

// own recursive way
def split[T](n: Int)(list: List[T]): (List[T], List[T]) = {
  def splitRec(count: Int, list: List[T]): (List[T], List[T]) =
    (count <= 0, list) match {
      case (_, Nil) => (Nil, Nil)
      case (true, elem :: tail) =>
        (Nil, elem :: splitRec(count - 1, tail)._2)
      case (false, elem :: tail) =>
        val (first, second) = splitRec(count - 1, tail)
        (elem :: first, second)
      case _ => throw new NoSuchElementException
    }

  splitRec(n, list)
}

import TestCases._
list1
split(3)(list1)
