// generate a list of prime numbers from a given range

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

def primeList(range: Range): List[Int] = {
  val sieve = generateSieve(range.last)
  range.filter(sieve).toList
}

primeList(6 to 20)
