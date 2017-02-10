def kthElement[T](list: List[T], k: Int): T = {
  list match {
    case elem :: tail =>
      if (k == 0) elem
      else kthElement(tail, k - 1)
    case _ => throw new NoSuchElementException
  }
}

// better way
// def kthElement[T](list: List[T], k: Int): T = (k, list) match {
//     case (0, elem :: tail) => elem
//     case (k, _ :: tail) => kthElement(tail, k - 1)
//     case (_, Nil) => throw new NoSuchElementException
//   }
// }

import TestCases._
println(list1)
println(list2)
kthElement(list1, 3)
kthElement(list2, 3)
