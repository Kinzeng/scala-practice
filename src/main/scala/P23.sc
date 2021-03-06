// extract a given number of random elements from a list

// solution from P20
def dropK[T](k: Int)(list: List[T]): (List[T], T) = {
  def dropKRec(count: Int, list: List[T]): (List[T], T) =
    (count == k, list) match {
      case (false, elem :: tail) =>
        val (l, r) = dropKRec(count + 1, tail)
        (elem :: l, r)
      case (true, elem :: tail) => (tail, elem)
      case _ => throw new NoSuchElementException
    }

  dropKRec(0, list)
}

def extractRandom[T](n: Int)(list: List[T]): List[T] = {
  def extractRandomRec(count: Int, list: List[T]): List[T] =
    if (count < n) {
      // list.length runs in O(N), so this is actually O(N^2) algorithm
      val index = (Math.random() * list.length).toInt
      val (l, r) = dropK(index)(list)
      r :: extractRandomRec(count + 1, l)
    } else Nil

  extractRandomRec(0, list)
}

import TestCases._
list1
extractRandom(3)(list1)
