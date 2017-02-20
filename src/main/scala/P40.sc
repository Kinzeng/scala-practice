// Goldbach's conjecture: every even integer can be writtine as a sum of two prime numbers
// given an even number find two prime numbers that add up to it

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

28.goldbach
