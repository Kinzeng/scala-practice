// generate the combinations of K distinct objects chosen from the N elements of a list

def combinations[T](k: Int)(list: List[T]): List[List[T]] = {
  def combinationsRec(count: Int, list: List[T], current: List[T]): List[List[T]] = {
    // println(list + " " + current)
    if (list.length < k - count || count > k) Nil
    else if (count == k - 1) List((list.head :: current).reverse)
    else {
      list.indices.toList.flatMap {(i) =>
        combinationsRec(count + 1, list.drop(i + 1), list.head :: current)
      }
    }
  }

  list.indices.toList.flatMap((i) => combinationsRec(0, list.drop(i), List()))
}

import TestCases._
list1
combinations(3)(list1)
