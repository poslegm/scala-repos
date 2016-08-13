/*
 * Copyright (c) 2011-2014, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.scene.layout

import javafx.scene.{layout => jfxsl}
import javafx.{geometry => jfxg, scene => jfxs}

import scala.collection.JavaConversions._
import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty}
import scalafx.delegate.{AlignmentDelegate, SFXDelegate}
import scalafx.geometry.Insets._
import scalafx.geometry.{HPos, Insets, VPos}
import scalafx.scene.Node
import scalafx.scene.Node._

object GridPane {
  implicit def sfxGridPane2jfx(v: GridPane): jfxsl.GridPane =
    if (v != null) v.delegate else null

  /**
    * Sentinel value which may be set on a child's row/column span constraint to indicate that it should span the
    * remaining rows/columns.
    */
  val Remaining = jfxsl.GridPane.REMAINING
  @deprecated("Use Remaining; REMAINING will be removed in a future release",
              "8.0.60-R10")
  val REMAINING = Remaining

  /**
    * Removes all gridpane constraints from the child node.
    */
  def clearConstraints(child: jfxs.Node) {
    jfxsl.GridPane.clearConstraints(child)
  }

  /**
    * Returns the child's column index constraint if set.
    */
  def getColumnIndex(child: Node) = jfxsl.GridPane.getColumnIndex(child)

  /**
    * Sets the column index for the child when contained by a gridpane so that it will be positioned
    * starting in that column of the gridpane.
    */
  def setColumnIndex(child: Node, value: Int) {
    jfxsl.GridPane.setColumnIndex(child, value)
  }

  /**
    * Returns the child's column-span constraint if set.
    */
  def getColumnSpan(child: Node) = jfxsl.GridPane.getColumnSpan(child)

  /**
    * Returns the child's halignment constraint if set.
    */
  def getHalignment(child: Node) = jfxsl.GridPane.getHalignment(child)

  /**
    * Sets the horizontal alignment for the child when contained by a GridPane.
    */
  def setHalignment(node: Node, hp: HPos) {
    jfxsl.GridPane.setHalignment(node, hp)
  }

  /**
    * Returns the child's hgrow constraint if set.
    */
  def getHgrow(child: Node) = jfxsl.GridPane.getHgrow(child)

  /**
    * Sets the value of the property hgap.
    */
  def setHgrow(child: Node, value: jfxsl.Priority) {
    jfxsl.GridPane.setHgrow(child, value)
  }

  /**
    * Returns the child's margin constraint if set.
    */
  def getMargin(child: Node) = jfxsl.GridPane.getMargin(child)

  /**
    * Sets the margin for the child when contained by a gridpane.
    */
  def setMargin(child: Node, value: Insets) {
    jfxsl.GridPane.setMargin(child, value)
  }

  /**
    * Returns the child's row index constraint if set.
    */
  def getRowIndex(child: Node) = jfxsl.GridPane.getRowIndex(child)

  /**
    * Sets the row index for the child when contained by a gridpane so that it will be positioned
    * starting in that row of the gridpane.
    */
  def setRowIndex(child: Node, value: Int) {
    jfxsl.GridPane.setRowIndex(child, value)
  }

  /**
    * Returns the child's row-span constraint if set.
    */
  def getRowSpan(child: Node) = jfxsl.GridPane.getRowSpan(child)

  /**
    * Sets the row span for the child when contained by a gridpane so that it will span that number
    * of rows vertically.
    */
  def setRowSpan(child: Node, value: Int) {
    jfxsl.GridPane.setRowSpan(child, value)
  }

  /**
    * Returns the child's valignment constraint if set.
    */
  def getValignment(child: Node) = jfxsl.GridPane.getValignment(child)

  // added object method (is this a good practice?)
  /**
    * Sets the vertical alignment for the child when contained by a gridpane.
    */
  def setValignment(node: Node, vp: VPos) {
    jfxsl.GridPane.setValignment(node, vp)
  }

  /**
    * Returns the child's vgrow constraint if set.
    */
  def getVgrow(child: Node) = jfxsl.GridPane.getVgrow(child)

  /**
    * Sets the vertical grow priority for the child when contained by a gridpane.
    */
  def setVgrow(child: Node, value: Priority) {
    jfxsl.GridPane.setVgrow(child, value)
  }

  /**
    * Sets the column span for the child when contained by a gridpane so that it will span that
    * number of columns horizontally.
    */
  def setColumnSpan(child: Node, value: Int) {
    jfxsl.GridPane.setColumnSpan(child, value)
  }

  /**
    * Sets the column,row indices for the child when contained in a gridpane.
    */
  def setConstraints(child: Node, columnIndex: Int, rowIndex: Int) {
    jfxsl.GridPane.setConstraints(child, columnIndex, rowIndex)
  }

  /**
    * Sets the column, row, column-span, and row-span value for the child when contained in a
    * gridpane.
    */
  def setConstraints(child: Node,
                     columnIndex: Int,
                     rowIndex: Int,
                     columnspan: Int,
                     rowspan: Int) {
    jfxsl.GridPane
      .setConstraints(child, columnIndex, rowIndex, columnspan, rowspan)
  }

  /**
    * Sets the grid position, spans, and alignment for the child when contained in a gridpane.
    */
  def setConstraints(child: Node,
                     columnIndex: Int,
                     rowIndex: Int,
                     columnspan: Int,
                     rowspan: Int,
                     halignment: HPos,
                     valignment: VPos) {
    jfxsl.GridPane.setConstraints(child,
                                  columnIndex,
                                  rowIndex,
                                  columnspan,
                                  rowspan,
                                  halignment,
                                  valignment)
  }

  /**
    * Sets the grid position, spans, and alignment for the child when contained in a gridpane.
    */
  def setConstraints(child: Node,
                     columnIndex: Int,
                     rowIndex: Int,
                     columnspan: Int,
                     rowspan: Int,
                     halignment: HPos,
                     valignment: VPos,
                     hgrow: Priority,
                     vgrow: Priority) {
    jfxsl.GridPane.setConstraints(child,
                                  columnIndex,
                                  rowIndex,
                                  columnspan,
                                  rowspan,
                                  halignment,
                                  valignment,
                                  hgrow,
                                  vgrow)
  }

  /**
    * Sets the grid position, spans, alignment, grow priorities, and margin for the child when
    * contained in a gridpane.
    */
  def setConstraints(child: Node,
                     columnIndex: Int,
                     rowIndex: Int,
                     columnspan: Int,
                     rowspan: Int,
                     halignment: HPos,
                     valignment: VPos,
                     hgrow: Priority,
                     vgrow: Priority,
                     margin: Insets) {
    jfxsl.GridPane.setConstraints(child,
                                  columnIndex,
                                  rowIndex,
                                  columnspan,
                                  rowspan,
                                  halignment,
                                  valignment,
                                  hgrow,
                                  vgrow,
                                  margin)
  }
}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html]]
  */
class GridPane(override val delegate: jfxsl.GridPane = new jfxsl.GridPane)
    extends Pane(delegate)
    with AlignmentDelegate[jfxsl.GridPane]
    with SFXDelegate[jfxsl.GridPane] {

  /**
    * For debug purposes only: controls whether lines are displayed to show the gridpane's rows and
    * columns.
    */
  def gridLinesVisible: BooleanProperty = delegate.gridLinesVisibleProperty
  def gridLinesVisible_=(v: Boolean) {
    gridLinesVisible() = v
  }

  /**
    * The width of the horizontal gaps between columns.
    */
  def hgap: DoubleProperty = delegate.hgapProperty
  def hgap_=(v: Double) {
    hgap() = v
  }

  /**
    * The height of the vertical gaps between rows.
    */
  def vgap: DoubleProperty = delegate.vgapProperty
  def vgap_=(v: Double) {
    vgap() = v
  }

  /**
    * List of column constraints.
    */
  def columnConstraints = delegate.getColumnConstraints

  /**
    * Sets the list of column constraints, replacing the prior content. If you want append to current content, use `add` or
    * similar.
    *
    * @param c list of column constraints to replace prior content.
    */
  def columnConstraints_=(c: Iterable[ColumnConstraints]) {
    if (null == c) {
      columnConstraints.clear()
    } else {
      columnConstraints.setAll(c.map(_.delegate))
    }
  }

  /**
    * List of row constraints.
    */
  def rowConstraints = delegate.getRowConstraints

  /**
    * Sets the list of row constraints, replacing the prior content. If you want append to current content, use `add` or
    * similar.
    *
    * @param c list of row constraints to replace prior content.
    */
  def rowConstraints_=(c: Iterable[RowConstraints]) {
    if (null == c) {
      rowConstraints.clear()
    } else {
      rowConstraints.setAll(c.map(_.delegate))
    }
  }

  /**
    * Adds a child to the gridpane at the specified column,row position.
    */
  def add(child: Node, columnIndex: Int, rowIndex: Int) {
    delegate.add(child, columnIndex, rowIndex)
  }

  /**
    * Adds a child to the gridpane at the specified column,row position and spans.
    */
  def add(child: Node,
          columnIndex: Int,
          rowIndex: Int,
          colspan: Int,
          rowspan: Int) {
    delegate.add(child, columnIndex, rowIndex, colspan, rowspan)
  }

  /**
    * Convenience method for placing the specified nodes sequentially in a given column of the gridpane.
    */
  def addColumn(columnIndex: Int, children: jfxs.Node*) {
    delegate.addColumn(columnIndex, children: _*)
  }

  /**
    * Convenience method for placing the specified nodes sequentially in a given row of the gridpane.
    */
  def addRow(rowIndex: Int, children: jfxs.Node*) {
    delegate.addRow(rowIndex, children: _*)
  }

  /**
    * Requests a layout pass to be performed before the next scene is rendered.
    */
  def requestLayout() {
    delegate.requestLayout()
  }
}
