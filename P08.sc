def compress[T](list: List[T]): List[T] = {
  def compRec(list: List[T]): List[T] = list match {
    case Nil => Nil
    case elem :: tail => elem :: compRec(tail.dropWhile(_ == elem))
    case _ => throw new NoSuchElementException
  }

  compRec(list)
}

import TestCases._
list6
compress(list6)
