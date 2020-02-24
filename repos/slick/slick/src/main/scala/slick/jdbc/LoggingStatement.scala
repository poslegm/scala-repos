package slick.jdbc

import scala.language.reflectiveCalls

import java.sql.{
  PreparedStatement,
  Connection,
  SQLWarning,
  ResultSet,
  Statement
}

/** A wrapper for `java.sql.Statement` that logs statements and benchmark results
  * to the appropriate [[JdbcBackend]] loggers. */
class LoggingStatement(st: Statement) extends Statement {
  private[this] val doStatement = JdbcBackend.statementLogger.isDebugEnabled
  private[this] val doBenchmark = JdbcBackend.benchmarkLogger.isDebugEnabled

  @inline protected[this] def logged[T](
      sql: String,
      what: String = "statement"
  )(f: => T) = {
    if (doStatement && (sql ne null))
      JdbcBackend.statementLogger.debug("Executing " + what + ": " + sql)
    val t0 = if (doBenchmark) System.nanoTime() else 0L
    val res = f
    if (doBenchmark)
      JdbcBackend.benchmarkLogger.debug(
        "Execution of " + what + " took " + formatNS(System.nanoTime() - t0)
      )
    res
  }

  private[this] def formatNS(ns: Long): String = {
    if (ns < 1000L) ns + "ns"
    else if (ns < 1000000L) (ns / 1000L) + "µs"
    else if (ns < 1000000000L) (ns / 1000000L) + "ms"
    else (ns / 1000000000L) + "s"
  }

  def addBatch(sql: String) = {
    if (doStatement)
      JdbcBackend.statementLogger.debug("Adding to batch: " + sql)
    st.addBatch(sql)
  }
  def execute(sql: String, columnNames: Array[String]): Boolean = logged(sql) {
    st.execute(sql, columnNames)
  }
  def execute(sql: String, columnIndexes: Array[Int]): Boolean = logged(sql) {
    st.execute(sql, columnIndexes)
  }
  def execute(sql: String, autoGeneratedKeys: Int): Boolean = logged(sql) {
    st.execute(sql, autoGeneratedKeys)
  }
  def execute(sql: String): Boolean = logged(sql) { st.execute(sql) }
  def executeQuery(sql: String): ResultSet = logged(sql, "query") {
    st.executeQuery(sql)
  }
  def executeUpdate(sql: String, columnNames: Array[String]): Int =
    logged(sql, "update") { st.executeUpdate(sql, columnNames) }
  def executeUpdate(sql: String, columnIndexes: Array[Int]): Int =
    logged(sql, "update") { st.executeUpdate(sql, columnIndexes) }
  def executeUpdate(sql: String, autoGeneratedKeys: Int): Int =
    logged(sql, "update") { st.executeUpdate(sql, autoGeneratedKeys) }
  def executeUpdate(sql: String): Int = logged(sql, "update") {
    st.executeUpdate(sql)
  }
  def executeBatch(): Array[Int] = logged(null, "batch") { st.executeBatch() }

  def setMaxFieldSize(max: Int) = st.setMaxFieldSize(max)
  def clearWarnings() = st.clearWarnings()
  def getMoreResults(current: Int) = st.getMoreResults(current)
  def getMoreResults: Boolean = st.getMoreResults
  def getGeneratedKeys: ResultSet = st.getGeneratedKeys
  def cancel() = st.cancel()
  def getResultSet: ResultSet = st.getResultSet
  def setPoolable(poolable: Boolean) = st.setPoolable(poolable)
  def isPoolable: Boolean = st.isPoolable
  def setCursorName(name: String) = st.setCursorName(name)
  def getUpdateCount: Int = st.getUpdateCount
  def getMaxRows: Int = st.getMaxRows
  def getResultSetType: Int = st.getResultSetType
  def unwrap[T](iface: Class[T]): T = st.unwrap(iface)
  def setMaxRows(max: Int) = st.setMaxRows(max)
  def getFetchSize: Int = st.getFetchSize
  def getResultSetHoldability: Int = st.getResultSetHoldability
  def setFetchDirection(direction: Int) = st.setFetchDirection(direction)
  def getFetchDirection: Int = st.getFetchDirection
  def getResultSetConcurrency: Int = st.getResultSetConcurrency
  def isWrapperFor(iface: Class[_]): Boolean = st.isWrapperFor(iface)
  def clearBatch() = st.clearBatch()
  def close() = st.close()
  def isClosed: Boolean = st.isClosed
  def getWarnings: SQLWarning = st.getWarnings
  def getQueryTimeout: Int = st.getQueryTimeout
  def setQueryTimeout(seconds: Int) = st.setQueryTimeout(seconds)
  def setFetchSize(rows: Int) = st.setFetchSize(rows)
  def setEscapeProcessing(enable: Boolean) = st.setEscapeProcessing(enable)
  def getConnection: Connection = st.getConnection
  def getMaxFieldSize: Int = st.getMaxFieldSize
  def closeOnCompletion(): Unit =
    st.asInstanceOf[{ def closeOnCompletion(): Unit }].closeOnCompletion()
  def isCloseOnCompletion(): Boolean =
    st.asInstanceOf[{ def isCloseOnCompletion(): Boolean }]
      .isCloseOnCompletion()
}

/** A wrapper for `java.sql.PreparedStatement` that logs statements and benchmark results
  * to the appropriate [[JdbcBackend]] loggers. */
class LoggingPreparedStatement(st: PreparedStatement)
    extends LoggingStatement(st)
    with PreparedStatement {
  def execute(): Boolean = logged(null, "prepared statement") { st.execute() }
  def executeQuery(): java.sql.ResultSet = logged(null, "prepared query") {
    st.executeQuery()
  }
  def executeUpdate(): Int = logged(null, "prepared update") {
    st.executeUpdate()
  }

  def addBatch(): Unit = st.addBatch()
  def clearParameters(): Unit = st.clearParameters()
  def getMetaData(): java.sql.ResultSetMetaData = st.getMetaData
  def getParameterMetaData(): java.sql.ParameterMetaData =
    st.getParameterMetaData()
  def setArray(idx: Int, value: java.sql.Array): Unit = st.setArray(idx, value)
  def setAsciiStream(idx: Int, value: java.io.InputStream): Unit =
    st.setAsciiStream(idx, value)
  def setAsciiStream(idx: Int, value: java.io.InputStream, len: Long): Unit =
    st.setAsciiStream(idx, value, len)
  def setAsciiStream(idx: Int, value: java.io.InputStream, len: Int): Unit =
    st.setAsciiStream(idx, value, len)
  def setBigDecimal(idx: Int, value: java.math.BigDecimal): Unit =
    st.setBigDecimal(idx, value)
  def setBinaryStream(idx: Int, value: java.io.InputStream): Unit =
    st.setBinaryStream(idx, value)
  def setBinaryStream(idx: Int, value: java.io.InputStream, len: Long): Unit =
    st.setBinaryStream(idx, value, len)
  def setBinaryStream(idx: Int, value: java.io.InputStream, len: Int): Unit =
    st.setBinaryStream(idx, value, len)
  def setBlob(idx: Int, value: java.io.InputStream): Unit =
    st.setBlob(idx, value)
  def setBlob(idx: Int, value: java.io.InputStream, len: Long): Unit =
    st.setBlob(idx, value, len)
  def setBlob(idx: Int, value: java.sql.Blob): Unit = st.setBlob(idx, value)
  def setBoolean(idx: Int, value: Boolean): Unit = st.setBoolean(idx, value)
  def setByte(idx: Int, value: Byte): Unit = st.setByte(idx, value)
  def setBytes(idx: Int, value: Array[Byte]): Unit = st.setBytes(idx, value)
  def setCharacterStream(idx: Int, value: java.io.Reader): Unit =
    st.setCharacterStream(idx, value)
  def setCharacterStream(idx: Int, value: java.io.Reader, len: Long): Unit =
    st.setCharacterStream(idx, value, len)
  def setCharacterStream(idx: Int, value: java.io.Reader, len: Int): Unit =
    st.setCharacterStream(idx, value, len)
  def setClob(idx: Int, value: java.io.Reader): Unit = st.setClob(idx, value)
  def setClob(idx: Int, value: java.io.Reader, len: Long): Unit =
    st.setClob(idx, value, len)
  def setClob(idx: Int, value: java.sql.Clob): Unit = st.setClob(idx, value)
  def setDate(idx: Int, value: java.sql.Date, cal: java.util.Calendar): Unit =
    st.setDate(idx, value, cal)
  def setDate(idx: Int, value: java.sql.Date): Unit = st.setDate(idx, value)
  def setDouble(idx: Int, value: Double): Unit = st.setDouble(idx, value)
  def setFloat(idx: Int, value: Float): Unit = st.setFloat(idx, value)
  def setInt(idx: Int, value: Int): Unit = st.setInt(idx, value)
  def setLong(idx: Int, value: Long): Unit = st.setLong(idx, value)
  def setNCharacterStream(idx: Int, value: java.io.Reader): Unit =
    st.setNCharacterStream(idx, value)
  def setNCharacterStream(idx: Int, value: java.io.Reader, len: Long): Unit =
    st.setNCharacterStream(idx, value, len)
  def setNClob(idx: Int, value: java.io.Reader): Unit = st.setNClob(idx, value)
  def setNClob(idx: Int, value: java.io.Reader, len: Long): Unit =
    st.setNClob(idx, value, len)
  def setNClob(idx: Int, value: java.sql.NClob): Unit = st.setNClob(idx, value)
  def setNString(idx: Int, value: String): Unit = st.setNString(idx, value)
  def setNull(idx: Int, tpe: Int, tpeString: String): Unit =
    st.setNull(idx, tpe, tpeString)
  def setNull(idx: Int, tpe: Int): Unit = st.setNull(idx, tpe)
  def setObject(idx: Int, value: Any, tpe: Int, scale: Int): Unit =
    st.setObject(idx, value, tpe, scale)
  def setObject(idx: Int, value: Any): Unit = st.setObject(idx, value)
  def setObject(idx: Int, value: Any, tpe: Int): Unit =
    st.setObject(idx, value, tpe)
  def setRef(idx: Int, value: java.sql.Ref): Unit = st.setRef(idx, value)
  def setRowId(idx: Int, value: java.sql.RowId): Unit = st.setRowId(idx, value)
  def setSQLXML(idx: Int, value: java.sql.SQLXML): Unit =
    st.setSQLXML(idx, value)
  def setShort(idx: Int, value: Short): Unit = st.setShort(idx, value)
  def setString(idx: Int, value: String): Unit = st.setString(idx, value)
  def setTime(idx: Int, value: java.sql.Time, cal: java.util.Calendar): Unit =
    st.setTime(idx, value, cal)
  def setTime(idx: Int, value: java.sql.Time): Unit = st.setTime(idx, value)
  def setTimestamp(
      idx: Int,
      value: java.sql.Timestamp,
      cal: java.util.Calendar
  ): Unit =
    st.setTimestamp(idx, value, cal)
  def setTimestamp(idx: Int, value: java.sql.Timestamp): Unit =
    st.setTimestamp(idx, value)
  def setURL(idx: Int, value: java.net.URL): Unit = st.setURL(idx, value)
  @deprecated("setUnicodeStream is deprecated", "")
  def setUnicodeStream(idx: Int, value: java.io.InputStream, len: Int): Unit =
    st.setUnicodeStream(idx, value, len)
}
