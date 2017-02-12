// remove the kth element from the list

// using built ins
// def dropK[T](k: Int)(list: List[T]): List[T] = {
//   val (first, second) = list.splitAt(k)
//   first ::: second.tail
// }

// recursive
def dropK[T](k: Int)(list: List[T]): List[T] = {
  def dropKRec(count: Int, list: List[T]): List[T] =
    (count == k, list) match {
      case (false, elem :: tail) => elem :: dropKRec(count + 1, tail)
      case (true, _ :: tail) => tail
    }

  dropKRec(0, list)
}

import TestCases._
list1
dropK(1)(list1)
