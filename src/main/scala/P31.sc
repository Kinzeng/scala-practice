// determine whether a given integer is prime

import scala.collection.mutable.ArrayBuffer

// imperative implementation of Sieve of Eratosthenes
implicit class Prime(n: Int) {
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
}

7.isPrime
8.isPrime
1000003.isPrime
