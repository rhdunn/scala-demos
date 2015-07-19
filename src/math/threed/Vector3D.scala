/** 3D Vector
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

package math.threed

class Vector3D(a: Double, b: Double, c: Double) {
  def this() = this(0, 0, 0)

  def x = a
  def y = b
  def z = c

  def ==(other: Vector3D) =
    this.x == other.x && this.y == other.y && this.z == other.z

  def !=(other: Vector3D) = !(this == other)

  def unary_-() = new Vector3D(-x, -y, -z)

  def +(other: Vector3D) =
    new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z)

  def -(other: Vector3D) =
    new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z)

  def *(s: Double) = new Vector3D(x*s, y*s, z*s)

  def /(s: Double) = new Vector3D(x/s, y/s, z/s)

  def norm = Math.sqrt(x*x + y*y + z*z)

  def unit = this/norm
}

object Vector3D {
  class Scalar(s: Double) {
    def *(v: Vector3D) = v*s
  }

  implicit def doubleToScalar(s: Double) : Scalar = new Scalar(s)
}
