/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.ui.storage

import java.net.URLEncoder
import javax.servlet.http.HttpServletRequest

import scala.xml.{Node, Unparsed}

import org.apache.spark.status.api.v1.{AllRDDResource, RDDDataDistribution, RDDPartitionInfo}
import org.apache.spark.ui.{PagedDataSource, PagedTable, UIUtils, WebUIPage}
import org.apache.spark.util.Utils

/** Page showing storage details for a given RDD */
private[ui] class RDDPage(parent: StorageTab) extends WebUIPage("rdd") {
  private val listener = parent.listener

  def render(request: HttpServletRequest): Seq[Node] = {
    val parameterId = request.getParameter("id")
    require(
        parameterId != null && parameterId.nonEmpty, "Missing id parameter")

    val parameterBlockPage = request.getParameter("block.page")
    val parameterBlockSortColumn = request.getParameter("block.sort")
    val parameterBlockSortDesc = request.getParameter("block.desc")
    val parameterBlockPageSize = request.getParameter("block.pageSize")
    val parameterBlockPrevPageSize = request.getParameter("block.prevPageSize")

    val blockPage = Option(parameterBlockPage).map(_.toInt).getOrElse(1)
    val blockSortColumn =
      Option(parameterBlockSortColumn).getOrElse("Block Name")
    val blockSortDesc =
      Option(parameterBlockSortDesc).map(_.toBoolean).getOrElse(false)
    val blockPageSize =
      Option(parameterBlockPageSize).map(_.toInt).getOrElse(100)
    val blockPrevPageSize =
      Option(parameterBlockPrevPageSize).map(_.toInt).getOrElse(blockPageSize)

    val rddId = parameterId.toInt
    val rddStorageInfo = AllRDDResource
      .getRDDStorageInfo(rddId, listener, includeDetails = true)
      .getOrElse {
        // Rather than crashing, render an "RDD Not Found" page
        return UIUtils.headerSparkPage("RDD Not Found", Seq[Node](), parent)
      }

    // Worker table
    val workerTable = UIUtils.listingTable(
        workerHeader,
        workerRow,
        rddStorageInfo.dataDistribution.get,
        id = Some("rdd-storage-by-worker-table"))

    // Block table
    val page: Int = {
      // If the user has changed to a larger page size, then go to page 1 in order to avoid
      // IndexOutOfBoundsException.
      if (blockPageSize <= blockPrevPageSize) {
        blockPage
      } else {
        1
      }
    }
    val blockTableHTML = try {
      val _blockTable = new BlockPagedTable(
          UIUtils.prependBaseUri(parent.basePath) +
          s"/storage/rdd/?id=${rddId}",
          rddStorageInfo.partitions.get,
          blockPageSize,
          blockSortColumn,
          blockSortDesc)
      _blockTable.table(page)
    } catch {
      case e @ (_: IllegalArgumentException | _: IndexOutOfBoundsException) =>
        <div class="alert alert-error">{e.getMessage}</div>
    }

    val jsForScrollingDownToBlockTable = <script>
        {
          Unparsed {
            """
              |$(function() {
              |  if (/.*&block.sort=.*$/.test(location.search)) {
              |    var topOffset = $("#blocks-section").offset().top;
              |    $("html,body").animate({scrollTop: topOffset}, 200);
              |  }
              |});
            """.stripMargin
          }
        }
      </script>

    val content = <div class="row-fluid">
        <div class="span12">
          <ul class="unstyled">
            <li>
              <strong>Storage Level:</strong>
              {rddStorageInfo.storageLevel}
            </li>
            <li>
              <strong>Cached Partitions:</strong>
              {rddStorageInfo.numCachedPartitions}
            </li>
            <li>
              <strong>Total Partitions:</strong>
              {rddStorageInfo.numPartitions}
            </li>
            <li>
              <strong>Memory Size:</strong>
              {Utils.bytesToString(rddStorageInfo.memoryUsed)}
            </li>
            <li>
              <strong>Disk Size:</strong>
              {Utils.bytesToString(rddStorageInfo.diskUsed)}
            </li>
          </ul>
        </div>
      </div>

      <div class="row-fluid">
        <div class="span12">
          <h4>
            Data Distribution on {rddStorageInfo.dataDistribution.map(_.size).getOrElse(0)}
            Executors
          </h4>
          {workerTable}
        </div>
      </div>

      <div>
        <h4 id="blocks-section">
          {rddStorageInfo.partitions.map(_.size).getOrElse(0)} Partitions
        </h4>
        {blockTableHTML ++ jsForScrollingDownToBlockTable}
      </div>;

    UIUtils.headerSparkPage(
        "RDD Storage Info for " + rddStorageInfo.name, content, parent)
  }

  /** Header fields for the worker table */
  private def workerHeader = Seq("Host", "Memory Usage", "Disk Usage")

  /** Render an HTML row representing a worker */
  private def workerRow(worker: RDDDataDistribution): Seq[Node] = {
    <tr>
      <td>{worker.address}</td>
      <td>
        {Utils.bytesToString(worker.memoryUsed)}
        ({Utils.bytesToString(worker.memoryRemaining)} Remaining)
      </td>
      <td>{Utils.bytesToString(worker.diskUsed)}</td>
    </tr>
  }
}

private[ui] case class BlockTableRowData(blockName: String,
                                         storageLevel: String,
                                         memoryUsed: Long,
                                         diskUsed: Long,
                                         executors: String)

private[ui] class BlockDataSource(rddPartitions: Seq[RDDPartitionInfo],
                                  pageSize: Int,
                                  sortColumn: String,
                                  desc: Boolean)
    extends PagedDataSource[BlockTableRowData](pageSize) {

  private val data =
    rddPartitions.map(blockRow).sorted(ordering(sortColumn, desc))

  override def dataSize: Int = data.size

  override def sliceData(from: Int, to: Int): Seq[BlockTableRowData] = {
    data.slice(from, to)
  }

  private def blockRow(rddPartition: RDDPartitionInfo): BlockTableRowData = {
    BlockTableRowData(rddPartition.blockName,
                      rddPartition.storageLevel,
                      rddPartition.memoryUsed,
                      rddPartition.diskUsed,
                      rddPartition.executors.mkString(" "))
  }

  /**
    * Return Ordering according to sortColumn and desc
    */
  private def ordering(
      sortColumn: String, desc: Boolean): Ordering[BlockTableRowData] = {
    val ordering = sortColumn match {
      case "Block Name" =>
        new Ordering[BlockTableRowData] {
          override def compare(
              x: BlockTableRowData, y: BlockTableRowData): Int =
            Ordering.String.compare(x.blockName, y.blockName)
        }
      case "Storage Level" =>
        new Ordering[BlockTableRowData] {
          override def compare(
              x: BlockTableRowData, y: BlockTableRowData): Int =
            Ordering.String.compare(x.storageLevel, y.storageLevel)
        }
      case "Size in Memory" =>
        new Ordering[BlockTableRowData] {
          override def compare(
              x: BlockTableRowData, y: BlockTableRowData): Int =
            Ordering.Long.compare(x.memoryUsed, y.memoryUsed)
        }
      case "Size on Disk" =>
        new Ordering[BlockTableRowData] {
          override def compare(
              x: BlockTableRowData, y: BlockTableRowData): Int =
            Ordering.Long.compare(x.diskUsed, y.diskUsed)
        }
      case "Executors" =>
        new Ordering[BlockTableRowData] {
          override def compare(
              x: BlockTableRowData, y: BlockTableRowData): Int =
            Ordering.String.compare(x.executors, y.executors)
        }
      case unknownColumn =>
        throw new IllegalArgumentException(s"Unknown column: $unknownColumn")
    }
    if (desc) {
      ordering.reverse
    } else {
      ordering
    }
  }
}

private[ui] class BlockPagedTable(basePath: String,
                                  rddPartitions: Seq[RDDPartitionInfo],
                                  pageSize: Int,
                                  sortColumn: String,
                                  desc: Boolean)
    extends PagedTable[BlockTableRowData] {

  override def tableId: String = "rdd-storage-by-block-table"

  override def tableCssClass: String =
    "table table-bordered table-condensed table-striped table-head-clickable"

  override def pageSizeFormField: String = "block.pageSize"

  override def prevPageSizeFormField: String = "block.prevPageSize"

  override def pageNumberFormField: String = "block.page"

  override val dataSource: BlockDataSource = new BlockDataSource(
      rddPartitions, pageSize, sortColumn, desc)

  override def pageLink(page: Int): String = {
    val encodedSortColumn = URLEncoder.encode(sortColumn, "UTF-8")
    basePath + s"&$pageNumberFormField=$page" +
    s"&block.sort=$encodedSortColumn" + s"&block.desc=$desc" +
    s"&$pageSizeFormField=$pageSize"
  }

  override def goButtonFormPath: String = {
    val encodedSortColumn = URLEncoder.encode(sortColumn, "UTF-8")
    s"$basePath&block.sort=$encodedSortColumn&block.desc=$desc"
  }

  override def headers: Seq[Node] = {
    val blockHeaders = Seq("Block Name",
                           "Storage Level",
                           "Size in Memory",
                           "Size on Disk",
                           "Executors")

    if (!blockHeaders.contains(sortColumn)) {
      throw new IllegalArgumentException(s"Unknown column: $sortColumn")
    }

    val headerRow: Seq[Node] = {
      blockHeaders.map { header =>
        if (header == sortColumn) {
          val headerLink = Unparsed(
              basePath + s"&block.sort=${URLEncoder.encode(header, "UTF-8")}" +
              s"&block.desc=${!desc}" + s"&block.pageSize=$pageSize")
          val arrow = if (desc) "&#x25BE;" else "&#x25B4;" // UP or DOWN
          <th>
            <a href={headerLink}>
              {header}
              <span>&nbsp;{Unparsed(arrow)}</span>
            </a>
          </th>
        } else {
          val headerLink = Unparsed(
              basePath + s"&block.sort=${URLEncoder.encode(header, "UTF-8")}" +
              s"&block.pageSize=$pageSize")
          <th>
            <a href={headerLink}>
              {header}
            </a>
          </th>
        }
      }
    }
    <thead>{headerRow}</thead>
  }

  override def row(block: BlockTableRowData): Seq[Node] = {
    <tr>
      <td>{block.blockName}</td>
      <td>{block.storageLevel}</td>
      <td>{Utils.bytesToString(block.memoryUsed)}</td>
      <td>{Utils.bytesToString(block.diskUsed)}</td>
      <td>{block.executors}</td>
    </tr>
  }
}
