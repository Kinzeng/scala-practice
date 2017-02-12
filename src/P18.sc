// extract a slice from the list given two indices

// built in
// list.slice(start, end)

def slice[T](start: Int, end: Int, list: List[T]): List[T] = {
  def sliceRec(count: Int, list: List[T]): List[T] =
    (count >= start && count <= end, list) match {
      case (_, Nil) => Nil
      case (false, _ :: tail) => sliceRec(count + 1, tail)
      case (true, elem :: tail) => elem :: sliceRec(count + 1, tail)
      case _ => throw new NoSuchElementException
    }

  sliceRec(0, list)
}

import TestCases._
list1
slice(3, 5, list1)
