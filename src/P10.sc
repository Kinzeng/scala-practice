// run-length encoding of a list

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

def runLength[T](list: List[T]): List[(Int, T)] =
  pack(list).map((run) => (run.length, run.head))

import TestCases._
list6
runLength(list6)
