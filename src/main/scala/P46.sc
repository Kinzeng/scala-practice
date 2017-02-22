// truth tables for logical expressinos

def not(a: Boolean): Boolean = !a
def and(a: Boolean, b: Boolean): Boolean = a & b
def or(a:Boolean, b: Boolean): Boolean = a | b
def nand(a: Boolean, b: Boolean): Boolean = !and(a, b)
def nor(a: Boolean, b: Boolean): Boolean = !or(a, b)
def xor(a: Boolean, b: Boolean): Boolean = a ^ b
def impl(a: Boolean, b: Boolean): Boolean = or(!a, b)
def equ(a: Boolean, b: Boolean): Boolean = or(and(a, b), and(!a, !b))

// write a function that prints out the truth table for two variables
// from a given logical expression

def table2(expr: (Boolean, Boolean) => Boolean): String = {
  val values = List((true, true), (true, false), (false, true), (false, false))
  values.foldLeft("A\tB\tresult\n")((accum, cur) =>
    cur match {case (a, b) => accum + s"$a\t$b\t${expr(a, b)}\n"}
  )
}

table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
