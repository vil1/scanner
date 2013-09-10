package org.vil1.scanner

import org.specs2.mutable._

/**
 * @author Valentin Kasas
 */
class TrieSpec extends Specification {

  "A TrieBuilder[Char]" should {
    "build an instance of Trie[Char]" in {
      val tb = new TrieBuilder[Char]()
      tb.build must not be(null)
    }
  }

  """A Trie built using "foo", "bar", and "baz"  """ should {
    """contain "foo", "bar" and "baz" """ in {
      val trie = new TrieBuilder[Char](Seq("foo", "bar", "baz")).build
      val words = trie.words
      words must contain("foo".toSeq)
      words must contain("foo".toSeq)
      words must contain("foo".toSeq)
    }
  }
}
