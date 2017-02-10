def secondLast[T](list: List[T]): T = list match {
  case elem :: tail =>
    if (tail.length == 1) elem
    else secondLast(tail)
  case _ => throw new NoSuchElementException
}

import TestCases._
println(list1)
println(list2)
secondLast(list1)
secondLast(list2)
