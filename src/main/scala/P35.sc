// determine the prime factors of a positive integer

import scala.collection.mutable.ArrayBuffer

implicit class PrimeFactors(n: Int) {
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

  def primeFactors: List[Int] = {
    def primeFactorsRec(cur: Int, primes: Stream[Int]): List[Int] = {
      if (cur.isPrime) List(cur)
      else if (cur % primes.head == 0) primes.head :: primeFactorsRec(cur / primes.head, primes)
      else primeFactorsRec(cur, primes.tail)
    }

    primeFactorsRec(n, primes)
  }
}

import TestCases.time
25.primeFactors
315.primeFactors
time {
  10000042.primeFactors
}
