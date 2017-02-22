// generate n bit Gray codes
import scala.collection.mutable.Map

val memo: Map[Int, List[String]] = Map.empty
def gray(n: Int): List[String] = {
  if (n == 0) return List("")
  if (memo.contains(n)) return memo(n)

  val l1 = gray(n - 1)
  val l2 = l1.reverse

  memo += n -> (l1.map("0" + _) ::: l2.map("1" + _))
  memo(n)
}

gray(1)
gray(2)
gray(3)
