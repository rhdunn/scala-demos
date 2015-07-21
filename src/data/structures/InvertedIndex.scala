/** Inverted index or posting list
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

package data.structures

import scala.collection.mutable

class InvertedIndex[KeyT, T] {
  private val data = mutable.Map[KeyT, List[T]]()

  def isEmpty = data.isEmpty

  def notEmpty = data.nonEmpty

  def size = data.size

  def put(item: (KeyT, T)) = {
    data.get(item._1) match {
      case Some(x) => data put(item._1, x :+ item._2)
      case None    => data put(item._1, List(item._2))
    }
  }

  def get(item: KeyT): Option[List[T]] = data get item
}

/** References:
  *
  *   1.  Russ Cox, [Regular Expression Matching with a Trigram
  *       Index](https://swtch.com/~rsc/regexp/regexp4.html). 2012,
  */