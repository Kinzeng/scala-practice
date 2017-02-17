// insert an element at a given position into a list

def insert[T](n: Int)(e: T, list: List[T]): List[T] = {
  def insertRec(count: Int, list: List[T]): List[T] =
    (count == n, list) match {
      case (_, Nil) => Nil
      case (true, l) => e :: insertRec(count + 1, l)
      case (false, elem :: tail) => elem :: insertRec(count + 1, tail)
      case _ => throw new NoSuchElementException
    }

  insertRec(0, list)
}

import TestCases._
list1
insert(2)(10, list1)
