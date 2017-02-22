// use implicit conversion to make the logical functions from P46 part of the
// Boolean type

def not(a: Boolean): Boolean = !a
implicit class Logic(a: Boolean) {
  def and(b: Boolean): Boolean = a & b
  def or(b: Boolean): Boolean = a | b
  def nand(b: Boolean): Boolean = !(a and b)
  def nor(b: Boolean): Boolean = !a or b
  def xor(b: Boolean): Boolean = a ^ b
  def impl(b: Boolean): Boolean = !a or b
  def equ(b: Boolean): Boolean = (a and b) or (!a and !b)
}

true and true
true or false and true and false
true xor true or true and true
