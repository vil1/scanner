package org.vil1.scanner

/**
 * @author Valentin Kasas
 */

sealed trait Trie[A] {

}

case class TrieNode[A](children : Map[A,TrieNode[A]]) extends Trie[A]  {
  def words:Seq[Seq[A]] = for  {
    (a , child) <- children.toList
  } yield {
    child.words.flatMap(word => a :: word.toList)
  }
}

class TrieBuilder[A] {
  private[this] var trie : TrieNode[A] = TrieNode(Map.empty)

  def addWord[Repr](word: Seq[A]) {
    def addFirstElem(t: TrieNode[A], elems: Seq[A]):TrieNode[A] =
      if (elems.isEmpty) t
      else {
        val tt = t.children.withDefault(_x => TrieNode(Map.empty[A,TrieNode[A]]))(elems.head)
        t.copy(children = t.children + (elems.head -> addFirstElem(tt, elems.tail)))
      }
    trie = addFirstElem(trie, word)

  }

  def this(words : Seq[Seq[A]]) = {
    this
    words foreach addWord
  }

  def build = trie

}

