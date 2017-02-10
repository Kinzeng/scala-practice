def pack[T](list: List[T]): List[List[T]] = {
  def packRec(list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case l: List[T] =>
      val (first, rest) = l.span(_ == l.head)
      first :: packRec(rest)
    case _ => throw new NoSuchElementException
  }

  packRec(list)
}

import TestCases._
list6
pack(list6)
