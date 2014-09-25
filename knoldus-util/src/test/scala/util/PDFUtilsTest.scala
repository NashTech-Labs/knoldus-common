package util

import org.scalatest.FunSuite

class PDFUtilsTest extends FunSuite {

  test("Passing a pdf file and getting size of list of converted images") {
    val listOfImage = PDFUtils.convertPdfToBufferedImage("src/test/resources", "testing.pdf")
    assert(listOfImage.right.get.length === 2)
  }

  test("Passing a non pdf file and getting error message") {
    val listOfImage = PDFUtils.convertPdfToBufferedImage("src/test/resources", "testing.jpg")
    assert(listOfImage.left.get === "There is error in file reading")
  }
  
    test("Passing a file path which is not vallid") {
    val listOfImage = PDFUtils.convertPdfToBufferedImage("src/test/resources", "invalid.pdf")
    assert(listOfImage.left.get === "File does not exisit")
  }

}