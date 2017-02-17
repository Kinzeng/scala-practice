// generate a random permutation of the elements of a list

// solution from P23
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
  def extractRandomRec(count: Int, list: List[T], result: List[T]): List[T] =
    if (count >= n) result
    else {
      // list.length runs in O(N), so this is actually O(N^2) algorithm
      val index = (Math.random() * list.length).toInt
      val (l, r) = dropK(index)(list)
      extractRandomRec(count + 1, l, r :: result)
    }

  extractRandomRec(0, list, Nil)
}

// using the solution from P23, the algorithm runs in O(N^2) time
def randPerm[T](list: List[T]): List[T] = extractRandom(list.length)(list)

// faster way to do it is to convert to an array, run the same algorithm as above,
// then convert back into a list. that way it would be O(N) since finding the length
// of an array is constant time

import TestCases._
list1
randPerm(list1)
