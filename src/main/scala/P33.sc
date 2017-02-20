// determine whether two integers are coprime



implicit class Coprime(a: Int) {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  def isCoprimeTo(b: Int) = gcd(a, b) == 1
}

7.isCoprimeTo(8)
35.isCoprimeTo(64)
25.isCoprimeTo(35)
