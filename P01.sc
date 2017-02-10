def last[T](list: List[T]): T = list match {
  case elem :: Nil => elem
  case _ :: tail => last(tail)
  case _ => throw new NoSuchElementException
}

import TestCases._
println(list1)
println(list2)
last(list1)
last(list2)
