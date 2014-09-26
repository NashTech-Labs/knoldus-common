package util

import org.scalatest.FunSuite

class PPTUtilsTest extends FunSuite{

  test("Passing a ppt file and getting size of list of converted images") {
    val listOfImage = PPTUtils.convertPptToBufferedImage("src/test/resources", "testing.ppt")
    assert(listOfImage.right.get.length === 1)
  }

  test("Passing a non ppt file and getting error message") {
    val listOfImage = PPTUtils.convertPptToBufferedImage("src/test/resources", "testing.jpg")
    assert(listOfImage.left.get === "There is error in file reading")
  }
  
    test("Passing a file path which is not vallid") {
    val listOfImage = PPTUtils.convertPptToBufferedImage("src/test/resources", "invalid.pdf")
    assert(listOfImage.left.get === "File does not exisit")
  }
}