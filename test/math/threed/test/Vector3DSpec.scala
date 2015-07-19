/** 3D Vector test file
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

package math.threed.test

import math.threed._
import org.scalatest._

// noinspection DoubleNegation
class Vector3DSpec extends FlatSpec {
  def approx(a: Double, b: Double, precision: Double = 0.000000000000001) =
    assert((a - b).abs < precision, "for " + a + " approx " + b)

  "Initialization" should "initialize x, y and z correctly" in {
    val v = new Vector3D(1.2, 2.8, -5.6)
    assert(v.x ==  1.2)
    assert(v.y ==  2.8)
    assert(v.z == -5.6)
  }

  "Null vector initialization" should "initialize x, y and z with zeros" in {
    val v = new Vector3D()
    assert(v.x == 0)
    assert(v.y == 0)
    assert(v.z == 0)
  }

  "Vector equality" should "match identical vectors" in {
    assert(new Vector3D(1.0, 2.0, 3.0) == new Vector3D(1.0, 2.0, 3.0))
    assert(new Vector3D(8.3, 4.6, 2.9) == new Vector3D(8.3, 4.6, 2.9))
  }

  "Vector equality" should "not match different vectors" in {
    assert(!(new Vector3D(1.0, 2.0, 3.0) == new Vector3D(1.0, 2.0, 4.0)))
    assert(!(new Vector3D(1.0, 2.0, 3.0) == new Vector3D(1.0, 4.0, 3.0)))
    assert(!(new Vector3D(1.0, 2.0, 3.0) == new Vector3D(4.0, 2.0, 3.0)))
  }

  "Vector inequality" should "not match identical vectors" in {
    // DoubleNegation needed to test != behaviour.
    assert(!(new Vector3D(1.0, 2.0, 3.0) != new Vector3D(1.0, 2.0, 3.0)))
    assert(!(new Vector3D(8.3, 4.6, 2.9) != new Vector3D(8.3, 4.6, 2.9)))
  }

  "Vector inequality" should "match different vectors" in {
    assert(new Vector3D(1.0, 2.0, 3.0) != new Vector3D(1.0, 2.0, 4.0))
    assert(new Vector3D(1.0, 2.0, 3.0) != new Vector3D(1.0, 4.0, 3.0))
    assert(new Vector3D(1.0, 2.0, 3.0) != new Vector3D(4.0, 2.0, 3.0))
  }

  "unary negation" should "return the opposite vector" in {
    assert(-new Vector3D( 4,      5,    6) == new Vector3D(-4,   -5,   -6))
    assert(-new Vector3D(-9.1, -6.2, -3.3) == new Vector3D( 9.1,  6.2,  3.3))
  }

  "vector addition" should "add the elements in the vector" in {
    assert(new Vector3D(4, 5, 6) + new Vector3D( 1,  2,  3) == new Vector3D(5, 7, 9))
    assert(new Vector3D(3, 6, 9) + new Vector3D(-3, -6, -9) == new Vector3D())

    val v = new Vector3D(2, 4, 8)
    assert(v + v == new Vector3D(4, 8, 16))
  }

  "vector subtraction" should "subtract the elements in the vector" in {
    assert(new Vector3D(4, 5, 6) - new Vector3D( 1,  2,  3) == new Vector3D(3,  3,  3))
    assert(new Vector3D(3, 6, 9) - new Vector3D(-3, -6, -9) == new Vector3D(6, 12, 18))

    val v = new Vector3D(2, 4, 8)
    assert(v - v == new Vector3D())
  }

  "scalar multiplication" should "scale the vector" in {
    assert(new Vector3D(1, 2, 3) * 2 == new Vector3D(2,  4,  6))
    assert(2 * new Vector3D(1, 2, 3) == new Vector3D(2,  4,  6))
  }

  "scalar division" should "scale the vector" in {
    assert(new Vector3D(9, 6, 3) / 3 == new Vector3D(3,  2,  1))
  }

  "norm" should "calculate the magnitude of the vector" in {
    approx(new Vector3D( 3.0,  4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D(-3.0,  4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D( 3.0, -4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D( 3.0,  4.0, -5.0).norm, 7.0710678118654755)
  }

  "unit" should "calculate the unit vector" in {
    val u = new Vector3D(3, 6, 9).unit
    approx(u.x, 0.2672612419124244)
    approx(u.y, 0.5345224838248488)
    approx(u.z, 0.8017837257372732)
    assert(u.norm == 1.0)
  }

  "dot product" should "be the scalar product of two vectors" in {
    val a = new Vector3D(2, 3, 4)
    val b = new Vector3D(3, 6, 9)
    assert(a∙b == 60)
    assert(b∙a == 60)
  }

  "cross product" should "be the vector product of two vectors" in {
    val a = new Vector3D(4, 2, 1)
    val b = new Vector3D(3, 6, 9)
    val c = new Vector3D(1, 2, 3)
    assert(a×b == new Vector3D( 12, -33,  18))
    assert(b×a == new Vector3D(-12,  33, -18))
    assert(b×c == new Vector3D())
    assert(c×b == new Vector3D())
  }
}
