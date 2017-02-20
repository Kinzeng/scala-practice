// given a range of integers find the Goldbach pairs for each even number in the range

import scala.collection.mutable.ArrayBuffer

def generateSieve(n: Int): Array[Boolean] = {
  val sieve = ArrayBuffer.fill(n + 1)(true)
  sieve(0) = false
  sieve(1) = false
  for (i <- 2 to Math.sqrt(n).toInt) {
    if (sieve(i)) {
      for (j <- (i * 2) to n by i) {
        sieve(j) = false
      }
    }
  }

  sieve.toArray
}

def primeList(range: Range): Array[Int] = {
  val sieve = generateSieve(range.last)
  range.filter(sieve).toArray
}

implicit class Goldbach(n: Int) {
  def goldbach: List[(Int, Int)] = {
    val primes = primeList(2 to n)
    val sums: Map[Int, Int] = primes.zipWithIndex.map {case (x, i) =>
      (x, i)
    }.toMap

    primes.foldLeft(List[(Int, Int)]()) {(accum, cur) =>
      if (sums.contains(n - cur)) (n - cur, cur) :: accum
      else accum
    }
  }
}

def printGoldbachList(range: Range) = {
  (for {
    i <- range
    if i % 2 == 0
    g = i.goldbach.head
  } yield {
    (i, g._1, g._2)
  }).foreach((goldbach) =>
    println(s"${goldbach._1} = ${goldbach._2} + ${goldbach._3}")
  )
}

printGoldbachList(9 to 20)

def printGoldbachListLimited(range: Range, threshold: Int) = {
  (for {
    i <- range
    if i % 2 == 0
    g = i.goldbach.head
    if g._1 >= threshold && g._2 >= threshold
  } yield {
    (i, g._1, g._2)
  }).foreach((goldbach) =>
    println(s"${goldbach._1} = ${goldbach._2} + ${goldbach._3}")
  )
}

printGoldbachListLimited(3 to 2000, 50)
