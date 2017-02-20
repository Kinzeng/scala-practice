// sorting a list of lists according to length of sublists

import TestCases._
list7
list7.sortBy(_.length)

// sorting a list of lists according to length frequency

// run length from P13
def runLength[T](list: List[T]): List[(Int, T)] = list match {
  case Nil => Nil
  case l: List[T] =>
    val (pack, tail) = l.span(_ == l.head)
    (pack.length, pack.head) :: runLength(tail)
  case _ => throw new NoSuchElementException
}

def sortByFrequency[T](list: List[List[T]]) = {
  val frequencies = runLength(list.map(_.length).sorted).toMap.map(_.swap)
  list.sortWith {
    case (l1, l2) => frequencies(l1.length) < frequencies(l2.length)
  }
}

sortByFrequency(list7)
