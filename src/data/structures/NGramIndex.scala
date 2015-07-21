/** n-gram index
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

class NGramIndex[T](arity: Int) {
  private val data = new InvertedIndex[String, T]()

  def isEmpty = data.isEmpty

  def nonEmpty = data.nonEmpty

  def ngrams = data

  def put(item: (String, T)) = {
    NGrammer.ngrams(item._1, arity).foreach(ngram => {
      data put ngram -> item._2
    })
  }
}

/** References:
  *
  *   1.  Russ Cox, [Regular Expression Matching with a Trigram
  *       Index](https://swtch.com/~rsc/regexp/regexp4.html). 2012,
  */