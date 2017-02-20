// find the multiplicity of the prime factors of the number

import scala.collection.mutable.{Map => MuMap}
import scala.collection.mutable.ArrayBuffer

implicit class PrimeFactorsMultiplicity(n: Int) {
  val sieve: ArrayBuffer[Boolean] = ArrayBuffer.fill(n + 1)(true)
  sieve(0) = false
  sieve(1) = false
  for (i <- 2 to Math.sqrt(n).toInt) {
    if (sieve(i)) {
      for (j <- (i * 2) to n by i) {
        sieve(j) = false
      }
    }
  }
  def isPrime: Boolean = sieve(n)
  val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })

  def primeFactorsMultipicity: Map[Int, Int] = {
    def primeFactorsRec(cur: Int, primes: Stream[Int]): MuMap[Int, Int] = {
      if (cur.isPrime) MuMap(cur -> 1)
      else if (cur % primes.head == 0) {
        val map = primeFactorsRec(cur / primes.head, primes)
        if (map.contains(primes.head)) {
          map(primes.head) = map(primes.head) + 1
        } else {
          map += primes.head -> 1
        }

        map
      }
      else primeFactorsRec(cur, primes.tail)
    }

    primeFactorsRec(n, primes).toMap
  }
}

import TestCases.time
25.primeFactorsMultipicity
315.primeFactorsMultipicity
time {
  10000042.primeFactorsMultipicity
}
