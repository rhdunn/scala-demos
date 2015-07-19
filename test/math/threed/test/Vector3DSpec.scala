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

  "norm" should "calculate the magnitude of the vector" in {
    approx(new Vector3D( 3.0,  4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D(-3.0,  4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D( 3.0, -4.0,  5.0).norm, 7.0710678118654755)
    approx(new Vector3D( 3.0,  4.0, -5.0).norm, 7.0710678118654755)
  }
}
