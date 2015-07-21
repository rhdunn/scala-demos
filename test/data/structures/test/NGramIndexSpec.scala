/** n-gram index test file
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
import scala.collection.mutable

class NGramIndexSpec extends FlatSpec {
  "Initialization" should "create an empty collection" in {
    val c = new NGramIndex[Int](3)

    assert(c.isEmpty)
    assert(!c.nonEmpty)
    assert(c.ngrams.isEmpty)
    assert(c.any.isEmpty)
  }

  "put" should "not add n-grams for keys below the n-gram arity" in {
    val c = new NGramIndex[Int](3)
    c put "hi" -> 1

    assert(c.isEmpty)
    assert(!c.nonEmpty)
    assert(c.ngrams.isEmpty)

    assert(c.any == mutable.Set(1))
  }

  "put" should "build n-grams for the given key" in {
    val c = new NGramIndex[Int](3)
    c put "hello" -> 1

    assert(!c.isEmpty)
    assert(c.nonEmpty)
    assert(!c.ngrams.isEmpty)

    assert(c.any == mutable.Set(1))

    assert(c.ngrams.size == 3)
    assert(c.ngrams.get("hel").contains(mutable.Set(1)))
    assert(c.ngrams.get("ell").contains(mutable.Set(1)))
    assert(c.ngrams.get("llo").contains(mutable.Set(1)))
  }

  "put" should "build n-grams for the given keys" in {
    val c = new NGramIndex[Int](3)
    c put "hello" -> 1
    c put "mellow" -> 2
    c put "lower" -> 3
    c put "yes" -> 4

    assert(c.any == mutable.Set(1, 2, 3, 4))

    assert(c.ngrams.size == 8)
    assert(c.ngrams.get("hel").contains(mutable.Set(1)))
    assert(c.ngrams.get("mel").contains(mutable.Set(2)))
    assert(c.ngrams.get("ell").contains(mutable.Set(1, 2)))
    assert(c.ngrams.get("llo").contains(mutable.Set(1, 2)))
    assert(c.ngrams.get("low").contains(mutable.Set(2, 3)))
    assert(c.ngrams.get("owe").contains(mutable.Set(3)))
    assert(c.ngrams.get("wer").contains(mutable.Set(3)))
    assert(c.ngrams.get("yes").contains(mutable.Set(4)))
  }
}
