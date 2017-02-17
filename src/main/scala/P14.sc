// duplicate the elements of a list

// def duplicate[T](list: List[T]): List[T] =
//   list.flatMap((e) => List.fill(2)(e))

// allow currying for the number of duplications to be flexible
def multiply[T](num: Int)(list: List[T]): List[T] =
  list.flatMap((e) => List.fill(num)(e))

import TestCases._
list1
// define and use the curried function
def duplicate[T]: List[T] => List[T] = multiply(2)
duplicate(list1)

def timesThree[T]: List[T] => List[T] = multiply(3)
timesThree(list1)
