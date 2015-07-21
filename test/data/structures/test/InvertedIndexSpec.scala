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
}
