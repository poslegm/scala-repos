package scala.scalajs.testsuite.javalibex

import org.scalajs.jasminetest.JasmineTest

import java.io._
import java.util.zip._

object ZipInputStreamTest extends JasmineTest {

  when("typedarray").describe("java.util.zip.ZipInputStream") {

    it("should read zip archives") {
      val in = new ZipInputStream(new ByteArrayInputStream(binZip))

      def expectBinEntry(name: String, data: Seq[Int]): Unit = {
        val e = in.getNextEntry()
        expect(e.getName()).toEqual(name)

        for (d <- data) expect(in.read()).toBe(d)

        expect(in.read()).toBe(-1)
      }

      def expectStrEntry(name: String, content: String): Unit = {
        val e = in.getNextEntry()
        expect(e.getName()).toEqual(name)

        val r = new InputStreamReader(in)

        for (c <- content) expect(r.read().toChar).toBe(c)

        expect(r.read()).toBe(-1)
      }

      expectBinEntry("greetings/", Seq())
      expectStrEntry("greetings/en.txt", "Hello World, how are you doing?\n")
      expectStrEntry("greetings/es.txt", "¿Hola mundo, cómo estás?\n")
      expectStrEntry("greetings/fr.txt", "Bonjour, comment ça va?\n")
      expectStrEntry("greetings/ja.txt", "こんにちは、お元気ですか。\n")
      expectBinEntry("binary/", Seq())
      expectBinEntry("binary/bytes_0_to_50.bin", 0 to 50)

      expect(in.getNextEntry() == null).toBeTruthy
      in.close()
    }
  }

  /** A zip archive for testing:
    *
    *  $ zipinfo test.zip
    *  Archive:  test.zip   1304 bytes   7 files
    *  drwxr-xr-x  3.0 unx        0 bx stor 13-Aug-14 07:42 greetings/
    *  -rw-r--r--  3.0 unx       32 tx stor 13-Aug-14 07:40 greetings/en.txt
    *  -rw-r--r--  3.0 unx       28 tx stor 13-Aug-14 07:42 greetings/es.txt
    *  -rw-r--r--  3.0 unx       25 tx stor 13-Aug-14 07:41 greetings/fr.txt
    *  -rw-r--r--  3.0 unx       40 tx stor 13-Aug-14 07:40 greetings/ja.txt
    *  drwxr-xr-x  3.0 unx        0 bx stor 13-Aug-14 07:48 binary/
    *  -rw-r--r--  3.0 unx       51 bx stor 13-Aug-14 07:48 binary/bytes_0_to_50.bin
    *  7 files, 176 bytes uncompressed, 176 bytes compressed:  0.0%
    */
  val binZip = Array[Byte](80, 75, 3, 4, 10, 0, 0, 0, 0, 0, 89, 61, 13, 69, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 28, 0, 103, 114, 101, 101, 116, 105,
    110, 103, 115, 47, 85, 84, 9, 0, 3, -39, -6, -22, 83, -44, -4, -22, 83, 117,
    120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 3, 4, 10, 0, 2, 0, 0,
    0, 13, 61, 13, 69, -125, -110, -96, -74, 32, 0, 0, 0, 32, 0, 0, 0, 16, 0,
    28, 0, 103, 114, 101, 101, 116, 105, 110, 103, 115, 47, 101, 110, 46, 116,
    120, 116, 85, 84, 9, 0, 3, 73, -6, -22, 83, -108, -4, -22, 83, 117, 120, 11,
    0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 72, 101, 108, 108, 111, 32, 87, 111,
    114, 108, 100, 44, 32, 104, 111, 119, 32, 97, 114, 101, 32, 121, 111, 117,
    32, 100, 111, 105, 110, 103, 63, 10, 80, 75, 3, 4, 10, 0, 2, 0, 0, 0, 89,
    61, 13, 69, -27, 99, -56, -20, 28, 0, 0, 0, 28, 0, 0, 0, 16, 0, 28, 0, 103,
    114, 101, 101, 116, 105, 110, 103, 115, 47, 101, 115, 46, 116, 120, 116, 85,
    84, 9, 0, 3, -39, -6, -22, 83, -108, -4, -22, 83, 117, 120, 11, 0, 1, 4, -4,
    1, 0, 0, 4, 0, 0, 0, 0, -62, -65, 72, 111, 108, 97, 32, 109, 117, 110, 100,
    111, 44, 32, 99, -61, -77, 109, 111, 32, 101, 115, 116, -61, -95, 115, 63,
    10, 80, 75, 3, 4, 10, 0, 2, 0, 0, 0, 42, 61, 13, 69, -2, -58, -42, 30, 25,
    0, 0, 0, 25, 0, 0, 0, 16, 0, 28, 0, 103, 114, 101, 101, 116, 105, 110, 103,
    115, 47, 102, 114, 46, 116, 120, 116, 85, 84, 9, 0, 3, -128, -6, -22, 83,
    -108, -4, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 66,
    111, 110, 106, 111, 117, 114, 44, 32, 99, 111, 109, 109, 101, 110, 116, 32,
    -61, -89, 97, 32, 118, 97, 63, 10, 80, 75, 3, 4, 10, 0, 2, 0, 0, 0, 24, 61,
    13, 69, -26, -5, 76, 91, 40, 0, 0, 0, 40, 0, 0, 0, 16, 0, 28, 0, 103, 114,
    101, 101, 116, 105, 110, 103, 115, 47, 106, 97, 46, 116, 120, 116, 85, 84,
    9, 0, 3, 96, -6, -22, 83, -108, -4, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1,
    0, 0, 4, 0, 0, 0, 0, -29, -127, -109, -29, -126, -109, -29, -127, -85, -29,
    -127, -95, -29, -127, -81, -29, -128, -127, -29, -127, -118, -27, -123,
    -125, -26, -80, -105, -29, -127, -89, -29, -127, -103, -29, -127, -117, -29,
    -128, -126, 10, 80, 75, 3, 4, 10, 0, 0, 0, 0, 0, 6, 62, 13, 69, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 28, 0, 98, 105, 110, 97, 114, 121, 47, 85, 84,
    9, 0, 3, 28, -4, -22, 83, -44, -4, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0,
    0, 4, 0, 0, 0, 0, 80, 75, 3, 4, 10, 0, 2, 0, 0, 0, 3, 62, 13, 69, -7, 93,
    98, 55, 51, 0, 0, 0, 51, 0, 0, 0, 24, 0, 28, 0, 98, 105, 110, 97, 114, 121,
    47, 98, 121, 116, 101, 115, 95, 48, 95, 116, 111, 95, 53, 48, 46, 98, 105,
    110, 85, 84, 9, 0, 3, 22, -4, -22, 83, -108, -4, -22, 83, 117, 120, 11, 0,
    1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
    13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
    32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
    80, 75, 1, 2, 30, 3, 10, 0, 0, 0, 0, 0, 89, 61, 13, 69, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 10, 0, 24, 0, 0, 0, 0, 0, 0, 0, 16, 0, -19, 65, 0, 0, 0, 0,
    103, 114, 101, 101, 116, 105, 110, 103, 115, 47, 85, 84, 5, 0, 3, -39, -6,
    -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 1, 2,
    30, 3, 10, 0, 2, 0, 0, 0, 13, 61, 13, 69, -125, -110, -96, -74, 32, 0, 0, 0,
    32, 0, 0, 0, 16, 0, 24, 0, 0, 0, 0, 0, 1, 0, 0, 0, -92, -127, 68, 0, 0, 0,
    103, 114, 101, 101, 116, 105, 110, 103, 115, 47, 101, 110, 46, 116, 120,
    116, 85, 84, 5, 0, 3, 73, -6, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0, 0,
    4, 0, 0, 0, 0, 80, 75, 1, 2, 30, 3, 10, 0, 2, 0, 0, 0, 89, 61, 13, 69, -27,
    99, -56, -20, 28, 0, 0, 0, 28, 0, 0, 0, 16, 0, 24, 0, 0, 0, 0, 0, 1, 0, 0,
    0, -92, -127, -82, 0, 0, 0, 103, 114, 101, 101, 116, 105, 110, 103, 115, 47,
    101, 115, 46, 116, 120, 116, 85, 84, 5, 0, 3, -39, -6, -22, 83, 117, 120,
    11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 1, 2, 30, 3, 10, 0, 2, 0,
    0, 0, 42, 61, 13, 69, -2, -58, -42, 30, 25, 0, 0, 0, 25, 0, 0, 0, 16, 0, 24,
    0, 0, 0, 0, 0, 1, 0, 0, 0, -92, -127, 20, 1, 0, 0, 103, 114, 101, 101, 116,
    105, 110, 103, 115, 47, 102, 114, 46, 116, 120, 116, 85, 84, 5, 0, 3, -128,
    -6, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 1,
    2, 30, 3, 10, 0, 2, 0, 0, 0, 24, 61, 13, 69, -26, -5, 76, 91, 40, 0, 0, 0,
    40, 0, 0, 0, 16, 0, 24, 0, 0, 0, 0, 0, 1, 0, 0, 0, -92, -127, 119, 1, 0, 0,
    103, 114, 101, 101, 116, 105, 110, 103, 115, 47, 106, 97, 46, 116, 120, 116,
    85, 84, 5, 0, 3, 96, -6, -22, 83, 117, 120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0,
    0, 0, 0, 80, 75, 1, 2, 30, 3, 10, 0, 0, 0, 0, 0, 6, 62, 13, 69, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 24, 0, 0, 0, 0, 0, 0, 0, 16, 0, -19, 65, -23,
    1, 0, 0, 98, 105, 110, 97, 114, 121, 47, 85, 84, 5, 0, 3, 28, -4, -22, 83,
    117, 120, 11, 0, 1, 4, -4, 1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 1, 2, 30, 3, 10,
    0, 2, 0, 0, 0, 3, 62, 13, 69, -7, 93, 98, 55, 51, 0, 0, 0, 51, 0, 0, 0, 24,
    0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, -92, -127, 42, 2, 0, 0, 98, 105, 110, 97,
    114, 121, 47, 98, 121, 116, 101, 115, 95, 48, 95, 116, 111, 95, 53, 48, 46,
    98, 105, 110, 85, 84, 5, 0, 3, 22, -4, -22, 83, 117, 120, 11, 0, 1, 4, -4,
    1, 0, 0, 4, 0, 0, 0, 0, 80, 75, 5, 6, 0, 0, 0, 0, 7, 0, 7, 0, 83, 2, 0, 0,
    -81, 2, 0, 0, 0, 0)
}
