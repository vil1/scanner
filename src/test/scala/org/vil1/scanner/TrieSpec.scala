package org.vil1.scanner

import org.specs2.mutable._

/**
 * @author Valentin Kasas
 */
class TrieSpec extends Specification {


  """A Trie built using "foo", "bar", and "baz"  """ should {
    """contain "foo", "bar" and "baz" """ in {
      val trie:Trie[Char] = Trie("foo".toList, "bar".toList, "baz".toList)
      val words = trie.words
      words must contain("foo".toList)
      words must contain("foo".toList)
      words must contain("foo".toList)
    }
  }
}
