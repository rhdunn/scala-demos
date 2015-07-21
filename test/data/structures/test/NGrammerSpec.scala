/** NGrammer : n-gram construction algorithm tests
  *
  * Copyright (C) 2015 Reece H. Dunn
  *
  * This file is part of scala-demos.
  *
  * scala-demos is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  *
  * scala-demos is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * You should have received a copy of the GNU General Public License
  * along with scala-demos.  If not, see <http://www.gnu.org/licenses/>.
  */

package data.structures.test

import data.structures._
import org.scalatest._

class NGrammerSpec extends FlatSpec {
  "2-gram" should "not return items for a 0 element sequence" in {
    assert(NGrammer.ngrams(List(), 2).isEmpty)
  }

  "2-gram" should "not return items for a 1 element sequence" in {
    assert(NGrammer.ngrams(List(9), 2).isEmpty)
  }

  "2-gram" should "return one bigram for a 2 element sequence" in {
    val ret = NGrammer.ngrams(List(9, 8), 2).toList
    assert(ret == List(List(9, 8)))
  }

  "2-gram" should "return the bigrams in an integer sequence" in {
    val ret = NGrammer.ngrams(List(1, 2, 3, 4, 5), 2).toList
    assert(ret == List(List(1, 2), List(2, 3), List(3, 4), List(4, 5)))
  }

  "string 2-gram" should "not return items for a 0 element string" in {
    assert(NGrammer.ngrams("", 2).isEmpty)
  }

  "string 2-gram" should "not return items for a 1 element string" in {
    assert(NGrammer.ngrams("a", 2).isEmpty)
  }

  "string 2-gram" should "return one bigram for a 2 element string" in {
    val ret = NGrammer.ngrams("ab", 2).toList
    assert(ret == List("ab"))
  }

  "string 2-gram" should "return the bigrams in a string" in {
    val ret = NGrammer.ngrams("ab cd", 2).toList
    assert(ret == List("ab", "b ", " c", "cd"))
  }

  "3-gram" should "not return items for a 0 element sequence" in {
    assert(NGrammer.ngrams(List(), 3).isEmpty)
  }

  "3-gram" should "not return items for a 1 element sequence" in {
    assert(NGrammer.ngrams(List(9), 3).isEmpty)
  }

  "3-gram" should "not return items for a 2 element sequence" in {
    assert(NGrammer.ngrams(List(9, 8), 3).isEmpty)
  }

  "3-gram" should "return one trigram for a 3 element sequence" in {
    val ret = NGrammer.ngrams(List(9, 8, 7), 3).toList
    assert(ret == List(List(9, 8, 7)))
  }

  "3-gram" should "return the trigrams in an integer sequence" in {
    val ret = NGrammer.ngrams(List(1, 2, 3, 4, 5), 3).toList
    assert(ret == List(List(1, 2, 3), List(2, 3, 4), List(3, 4, 5)))
  }

  "string 3-gram" should "not return items for a 0 element string" in {
    assert(NGrammer.ngrams("", 3).isEmpty)
  }

  "string 3-gram" should "not return items for a 1 element string" in {
    assert(NGrammer.ngrams("a", 3).isEmpty)
  }

  "string 3-gram" should "not return items for a 2 element string" in {
    assert(NGrammer.ngrams("ab", 3).isEmpty)
  }

  "string 3-gram" should "return one trigram for a 3 element string" in {
    val ret = NGrammer.ngrams("abc", 3).toList
    assert(ret == List("abc"))
  }

  "string 3-gram" should "return the trigrams in a string" in {
    val ret = NGrammer.ngrams("ab cd", 3).toList
    assert(ret == List("ab ", "b c", " cd"))
  }
}
