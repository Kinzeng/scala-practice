// compare the two totient functions

import scala.collection.mutable.{Map => MuMap}
import scala.collection.mutable.ArrayBuffer

implicit class Totient(n: Int) {
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

  def totient1: Int = {
    n.primeFactorsMultipicity.foldLeft(1) {(accum, cur) =>
      accum * (cur._1 - 1) * Math.pow(cur._1, cur._2 - 1).toInt
    }
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }
  def isCoprimeTo(b: Int) = gcd(n, b) == 1

  def totient2 = (1 to n).foldLeft(0)((accum, cur) =>
    if (n.isCoprimeTo(cur)) accum + 1
    else accum
  )
}

import TestCases.time
// much faster than going through each number from 1 to n
time {
  10090.totient1
}

time {
  10090.totient2
}
