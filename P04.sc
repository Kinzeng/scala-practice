def length[T](list: List[T]): Int = {
  list match {
    case Nil => 0
    case _ :: tail => 1 + length(tail)
    case _ => throw new NoSuchElementException
  }
}

import TestCases._
println(list1)
println(list2)
length(list1)
length(list2)
