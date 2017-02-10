def reverse[T](list: List[T]): List[T] =
  list.foldLeft(List[T]())((cur, prev) => prev :: cur)

import TestCases._
println(list1)
println(list2)
reverse(list1)
reverse(list2)
