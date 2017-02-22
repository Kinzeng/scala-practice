// implement Huffman encoding
import scala.collection.{mutable => m}

abstract class Node extends Ordered[Node] {
  val freq: Int
  def compare(that: Node): Int = {
    that.freq - this.freq
  }
}

case class InternalNode(freq: Int, left: Node, right: Node) extends Node
case class LeafNode(freq: Int, char: Char) extends Node

def encode(s: String): String = {
  val freq: m.Map[Char, Int] = s.foldLeft(m.Map.empty[Char, Int]) {(map, c) =>
    if (map.contains(c)) map(c) += 1
    else map(c) = 1
    map
  }

  val codes = huffman(freq.toList)
  s.foldLeft("") {(code, c) => code + codes(c)}
}

def huffman(freq: List[(Char, Int)]) = {
  val heap = m.PriorityQueue.empty[Node]
  freq.foreach((c) => heap += LeafNode(c._2, c._1))

  while (heap.size > 1) {
    val node1 = heap.dequeue()
    val node2 = heap.dequeue()
    val node3 = InternalNode(node1.freq + node2.freq, node1, node2)
    heap += node3
  }

  def traverse(node: Node, cur: String): Map[Char, String] = node match {
    case LeafNode(_, c) => Map(c -> cur)
    case InternalNode(_, left, right) => traverse(left, cur + "0") ++ traverse(right, cur + "1")
  }

  val tree = heap.dequeue()
  traverse(tree, "")
}

import TestCases._
list8
huffman(list8)

val string = "the big bad wolf is really hungry. but at the same time like why doesn't he just go out and hunt. like he's a wolf. he hunts. except this one decided to just go and trick a little girl"
// chars are 16 bits in Scala
string.length * 16
val code = encode(string)
code.length
