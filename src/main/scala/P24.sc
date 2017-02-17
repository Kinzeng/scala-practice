// draw N different random numbers from the set 1 to M

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
  def extractRandomRec(count: Int, list: List[T]): List[T] =
    if (count < n) {
      // list.length runs in O(N), so this is actually O(N^2) algorithm
      val index = (Math.random() * list.length).toInt
      val (l, r) = dropK(index)(list)
      r :: extractRandomRec(count + 1, l)
    } else Nil

  extractRandomRec(0, list)
}

def lotto(N: Int, M: Int): List[Int] =
  extractRandom(N)(List.range(1, M + 1))

lotto(6, 49)