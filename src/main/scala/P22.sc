import scala.collection.mutable.ListBuffer
// create a list containing all integers in a given range

// could just use List.range(start, end)

// for loop
// def range(start: Int, end: Int): List[Int] =
//   for (i <- List.range(start, end + 1)) yield i

def range(start: Int, end: Int): List[Int] = {
  def rangeRec(count: Int): List[Int] = {
    if (count >= start && count <= end) count :: rangeRec(count + 1)
    else Nil
  }

  rangeRec(start)
}

range(4, 9)
