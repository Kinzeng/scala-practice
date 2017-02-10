def flatten[T](list: List[T]): List[T] = list.flatMap {
  case ms: List[T] => flatten(ms)
  case elem => List(elem)
}

import TestCases._
list4
list5
flatten(list4)
flatten(list5)

list4 flatMap ((list) => for (e <- list) yield e)
