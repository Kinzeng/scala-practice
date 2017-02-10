// decode a run-length encoded list

def pack[T](list: List[T]): List[List[T]] = {
  def packRec(list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case l: List[T] =>
      val (first, rest) = l.span(_ == l.head)
      first :: packRec(rest)
    case _ => throw new NoSuchElementException
  }

  packRec(list)
}

def runLength[T](list: List[T]): List[(Int, T)] =
  pack(list).map((run) => (run.length, run.head))

def decodeRunLength[T](list: List[(Int, T)]): List[T] =
  for {
    run <- list
    _ <- Range(0, run._1)
  } yield run._2

// list.flatMap((run) => List.fill(run._1, run._2))

import TestCases._
list6
decodeRunLength(runLength(list6))
