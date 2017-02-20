// determine the greatest common divisor of two numbers

def gcd(a: Int, b: Int): Int = {
  if (b == 0) a
  else gcd(b, a % b)
}

gcd(36, 63)
gcd (25, 35)
gcd(29, 37)
gcd(29, 64)
