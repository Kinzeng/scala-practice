// implement Euclid's totient function (number of integers from 1 to n that are coprime to n)

implicit class Totient(a: Int) {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }
  def isCoprimeTo(b: Int) = gcd(a, b) == 1

  def totient = (1 to a).foldLeft(0)((accum, cur) =>
    if (a.isCoprimeTo(cur)) accum + 1
    else accum
  )
}

import TestCases.time
7.totient
10.totient
25.totient
time {
  10000042.totient
}
