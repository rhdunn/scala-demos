/** Inverted index test file
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

class InvertedIndexSpec extends FlatSpec {
  "Initialization" should "create an empty collection" in {
    val c = new InvertedIndex[String, Int]()
    assert(c.isEmpty)
    assert(!c.notEmpty)
    assert(c.size == 0)
  }

  "Adding a single item" should "add that item to the collection" in {
    val c = new InvertedIndex[String, Int]()
    c put "hello" -> 2

    assert(!c.isEmpty)
    assert(c.notEmpty)
    assert(c.size == 1)

    assert(c.get("hello").contains(List(2)))
  }

  "Adding to an existing item" should "append the item" in {
    val c = new InvertedIndex[String, Int]()
    c put "hello" -> 2
    c put "hello" -> 5

    assert(c.get("hello").contains(List(2, 5)))
  }

  "Adding multiple items" should "add those items to the collection" in {
    val c = new InvertedIndex[String, Int]()
    c put "hello" -> 2
    c put "there" -> 5

    assert(c.get("hello").contains(List(2)))
    assert(c.get("there").contains(List(5)))
  }

  "Getting a non-existent item" should "return an empty option" in {
    val c = new InvertedIndex[String, Int]()
    c put "hello" -> 2

    assert(c.get("world").isEmpty)
  }
}
