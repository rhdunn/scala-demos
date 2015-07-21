/** NGrammer : n-gram construction algorithm
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

object NGrammer {
  def ngrams[T](items: Iterable[T], arity: Int) : Iterator[Iterable[T]] = {
    if (items.size < arity) return Iterator.empty
    items.sliding(arity)
  }

  def ngrams(items: String, arity: Int): Iterator[String] = {
    if (items.length < arity) return Iterator.empty
    items.sliding(arity).map(x => x.mkString(""))
  }
}
