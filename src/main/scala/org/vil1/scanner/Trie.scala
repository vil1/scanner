package org.vil1.scanner


/**
 * @author Valentin Kasas
 */

object Trie {
  def apply[A](word : List[A]):Trie[A] = word match {
    case Nil => TrieLeaf[A]()
    case head :: tail => TrieNode[A](Map(head -> Trie(tail)))
  }

  def apply[A](words: List[A]*):Trie[A] = {
    var trie:Trie[A] = TrieLeaf[A]()
    words foreach(w => trie = (trie + w))
    trie
  }
}

sealed trait Trie[A] extends PartialFunction[A,Trie[A]] {
  def words:List[List[A]]
  def +(word :List[A]):Trie[A]

  def apply(v1: A) = ???
}

case class TrieLeaf[A]() extends Trie[A]{
  def words = List(Nil)

  def isDefinedAt(x: A) = false

  def +(word: List[A]):Trie[A] = word match {
    case Nil => this
    case head :: tail => TrieNode[A](Map(head -> Trie(tail)))
  }
}

case class TrieNode[A](children : Map[A,Trie[A]] = Map[A,Trie[A]]()) extends Trie[A]  {
  def words:List[List[A]] = children.toList.flatMap{
    case (a,TrieLeaf()) => List(List(a))
    case (a,t:TrieNode[A]) => t.words.map( a :: _)
  }

  def isDefinedAt(x: A) = children.isDefinedAt(x)

  def +(word: List[A]):Trie[A] = word match {
    case Nil => this
    case head :: tail =>
      if(this isDefinedAt head){
        copy(children = children + ( head -> (children(head) + tail)))
      } else {
        copy(children = children + (head -> Trie(tail)))
      }
  }
}



