// rotate a list N places to the left

def rotate[T](n: Int)(list: List[T]): List[T] = {
  val (second, first) = list.splitAt(n)
  first ::: second
}

import TestCases._
list1
rotate(3)(list1)
