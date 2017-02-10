# Scala Practice Problems

This repository contains my solutions to the [Ninety-Nine Scala Problems](http://aperiodic.net/phil/scala/s-99/). For
these problems I try to use a variety of styles that are available in Scala including simple recursion, tail-recursion (
which is the same as recursion but it ends in the recursive call, allowing the Scala compiler to rewrite it as a branch
to reduce memory usage), and function programming. To run these solutions I use Scala Worksheets, which is an IntelliJ
feature that's basically a REPL but compiles and runs on save. It makes it quicker for me to put down my ideas. If you
want to run these without having to install IntelliJ, copying and pasting the files into the Scala REPL should work as
long as you also paste the TestCases object too. Speaking of which, the TestCases object is a simple singleton object
that stores commonly used test cases. I import this object into each of my solutions so that I can use the test cases
as a demo for each solution.
