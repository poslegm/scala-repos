/*
 *  ____    ____    _____    ____    ___     ____ 
 * |  _ \  |  _ \  | ____|  / ___|  / _/    / ___|        Precog (R)
 * | |_) | | |_) | |  _|   | |     | |  /| | |  _         Advanced Analytics Engine for NoSQL Data
 * |  __/  |  _ <  | |___  | |___  |/ _| | | |_| |        Copyright (C) 2010 - 2013 SlamData, Inc.
 * |_|     |_| \_\ |_____|  \____|   /__/   \____|        All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the 
 * GNU Affero General Public License as published by the Free Software Foundation, either version 
 * 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See 
 * the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this 
 * program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.precog.yggdrasil
package table

import org.joda.time.{DateTime, Period}

import com.precog.common._
import com.precog.util.{BitSet, BitSetUtil, Loop}

import scala.{specialized => spec}
import scala.collection._

trait DefinedAtIndex {
  private[table] val defined: BitSet
  def isDefinedAt(row: Int) = defined(row)
}

trait ArrayColumn[@spec(Boolean, Long, Double) A]
    extends DefinedAtIndex with ExtensibleColumn {
  def update(row: Int, value: A): Unit
}

class ArrayHomogeneousArrayColumn[@spec(Boolean, Long, Double) A](
    val defined: BitSet, values: Array[Array[A]])(val tpe: CArrayType[A])
    extends HomogeneousArrayColumn[A] with ArrayColumn[Array[A]] {
  def apply(row: Int) = values(row)

  def update(row: Int, value: Array[A]) {
    defined.set(row)
    values(row) = value
  }
}

object ArrayHomogeneousArrayColumn {
  def apply[@spec(Boolean, Long, Double) A : CValueType](
      values: Array[Array[A]]) =
    new ArrayHomogeneousArrayColumn(
        BitSetUtil.range(0, values.length), values)(CArrayType(CValueType[A]))
  def apply[@spec(Boolean, Long, Double) A : CValueType](
      defined: BitSet, values: Array[Array[A]]) =
    new ArrayHomogeneousArrayColumn(defined.copy, values)(
        CArrayType(CValueType[A]))
  def empty[@spec(Boolean, Long, Double) A](size: Int)(
      implicit elemType: CValueType[A]): ArrayHomogeneousArrayColumn[A] = {
    implicit val m: Manifest[A] = elemType.manifest

    new ArrayHomogeneousArrayColumn(new BitSet, new Array[Array[A]](size))(
        CArrayType(elemType))
  }
}

class ArrayBoolColumn(val defined: BitSet, values: BitSet)
    extends ArrayColumn[Boolean] with BoolColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: Boolean) = {
    defined.set(row)
    if (value) values.set(row) else values.clear(row)
  }
}

object ArrayBoolColumn {
  def apply(defined: BitSet, values: BitSet) =
    new ArrayBoolColumn(defined.copy, values.copy)
  def apply(defined: BitSet, values: Array[Boolean]) =
    new ArrayBoolColumn(
        defined.copy, BitSetUtil.filteredRange(0, values.length)(values))
  def apply(values: Array[Boolean]) = {
    val d = BitSetUtil.range(0, values.length)
    val v = BitSetUtil.filteredRange(0, values.length)(values)
    new ArrayBoolColumn(d, v)
  }

  def empty(): ArrayBoolColumn =
    new ArrayBoolColumn(new BitSet, new BitSet)
}

class ArrayLongColumn(val defined: BitSet, val values: Array[Long])
    extends ArrayColumn[Long] with LongColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: Long) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayLongColumn {
  def apply(values: Array[Long]) =
    new ArrayLongColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[Long]) =
    new ArrayLongColumn(defined.copy, values)
  def empty(size: Int): ArrayLongColumn =
    new ArrayLongColumn(new BitSet, new Array[Long](size))
}

class ArrayDoubleColumn(val defined: BitSet, values: Array[Double])
    extends ArrayColumn[Double] with DoubleColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: Double) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayDoubleColumn {
  def apply(values: Array[Double]) =
    new ArrayDoubleColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[Double]) =
    new ArrayDoubleColumn(defined.copy, values)
  def empty(size: Int): ArrayDoubleColumn =
    new ArrayDoubleColumn(new BitSet, new Array[Double](size))
}

class ArrayNumColumn(val defined: BitSet, values: Array[BigDecimal])
    extends ArrayColumn[BigDecimal] with NumColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: BigDecimal) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayNumColumn {
  def apply(values: Array[BigDecimal]) =
    new ArrayNumColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[BigDecimal]) =
    new ArrayNumColumn(defined.copy, values)
  def empty(size: Int): ArrayNumColumn =
    new ArrayNumColumn(new BitSet, new Array[BigDecimal](size))
}

class ArrayStrColumn(val defined: BitSet, values: Array[String])
    extends ArrayColumn[String] with StrColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: String) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayStrColumn {
  def apply(values: Array[String]) =
    new ArrayStrColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[String]) =
    new ArrayStrColumn(defined.copy, values)
  def empty(size: Int): ArrayStrColumn =
    new ArrayStrColumn(new BitSet, new Array[String](size))
}

class ArrayDateColumn(val defined: BitSet, values: Array[DateTime])
    extends ArrayColumn[DateTime] with DateColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: DateTime) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayDateColumn {
  def apply(values: Array[DateTime]) =
    new ArrayDateColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[DateTime]) =
    new ArrayDateColumn(defined.copy, values)
  def empty(size: Int): ArrayDateColumn =
    new ArrayDateColumn(new BitSet, new Array[DateTime](size))
}

class ArrayPeriodColumn(val defined: BitSet, values: Array[Period])
    extends ArrayColumn[Period] with PeriodColumn {
  def apply(row: Int) = values(row)

  def update(row: Int, value: Period) = {
    defined.set(row)
    values(row) = value
  }
}

object ArrayPeriodColumn {
  def apply(values: Array[Period]) =
    new ArrayPeriodColumn(BitSetUtil.range(0, values.length), values)
  def apply(defined: BitSet, values: Array[Period]) =
    new ArrayPeriodColumn(defined.copy, values)
  def empty(size: Int): ArrayPeriodColumn =
    new ArrayPeriodColumn(new BitSet, new Array[Period](size))
}

class MutableEmptyArrayColumn(val defined: BitSet)
    extends ArrayColumn[Boolean] with EmptyArrayColumn {
  def update(row: Int, value: Boolean) = {
    if (value) defined.set(row) else defined.clear(row)
  }
}

object MutableEmptyArrayColumn {
  def empty(): MutableEmptyArrayColumn =
    new MutableEmptyArrayColumn(new BitSet)
}

class MutableEmptyObjectColumn(val defined: BitSet)
    extends ArrayColumn[Boolean] with EmptyObjectColumn {
  def update(row: Int, value: Boolean) = {
    if (value) defined.set(row) else defined.clear(row)
  }
}

object MutableEmptyObjectColumn {
  def empty(): MutableEmptyObjectColumn =
    new MutableEmptyObjectColumn(new BitSet)
}

class MutableNullColumn(val defined: BitSet)
    extends ArrayColumn[Boolean] with NullColumn {
  def update(row: Int, value: Boolean) = {
    if (value) defined.set(row) else defined.clear(row)
  }
}

object MutableNullColumn {
  def empty(): MutableNullColumn = new MutableNullColumn(new BitSet)
}

/* help for ctags
type ArrayColumn */
