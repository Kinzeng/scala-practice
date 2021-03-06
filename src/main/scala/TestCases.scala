/**
  * Created by Kinzeng on 2/8/17.
  */
object TestCases {
  val list1 = List(1, 2, 3, 4, 5, 6, 7, 8)
  val list2 = List(4, 2, 8, 10, 4, 3, 1, 7)
  val list3 = List(1, 2, 3, 4, 3, 2, 1)
  val list4 = List(List(1, 1), List(2, 2), List(3, 3))
  val list5 = List(List(1, 1), "hello", "suhh", List("what", "the", "heck"))
  val list6 = List("a", "a", "a", "b", "b", "c", "c", "c", "c", "d")
  val list7 = List(List("a", "b", "c"), List("a"), List("a", "b"), List("a", "b"), List("a", "b"), List("a"))
  val list8 = List(('a', 45), ('b', 13), ('c', 12), ('d', 16), ('e', 9), ('f', 5))

  def time[T](f: => T): T = {
    val start = System.currentTimeMillis()
    val result = f
    println("function took " + (System.currentTimeMillis() - start) + "to run")
    result
  }
}
