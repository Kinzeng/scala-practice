// drop every Nth element in the list

def dropEveryN[T](num: Int)(list: List[T]): List[T] = {
  def dropRec(count: Int, list: List[T]): List[T] =
    (count % `num`, list) match {
      case (_, Nil) => Nil
      case (0, _ :: tail) => dropRec(count + 1, tail)
      case (_, elem :: tail) => elem :: dropRec(count + 1, tail)
    }

  dropRec(1, list)
}

import TestCases._
list1
dropEveryN(3)(list1)