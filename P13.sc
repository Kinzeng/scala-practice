def runLength[T](list: List[T]): List[(Int, T)] = list match {
  case Nil => Nil
  case l: List[T] =>
    val (pack, tail) = l.span(_ == l.head)
    (pack.length, pack.head) :: runLength(tail)
  case _ => throw new NoSuchElementException
}

import TestCases._
list6
runLength(list6)
