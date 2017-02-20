// group the elements of a set into disjoint subsets

// combinations function from P26
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


def group[T](lengths: List[Int], list: List[T]): List[List[List[T]]] = lengths match {
  case Nil => List(Nil)
  case length :: tail => combinations(length)(list).flatMap {(sublist) =>
    group(tail, list diff sublist).map(sublist :: _)
  }
}

import TestCases._
list6
group(List(2, 3, 4), list6)
