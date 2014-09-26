package util

import org.scalatest.FunSuite

class CommonUtilsTest extends FunSuite {

  test("Cross product of a list of sublist") {
    val input = List(List(1, 2, 3), List("a", "b"), List("@"))
    val output = List(List(1, "a", "@"), List(2, "a", "@"), List(3, "a", "@"), List(1, "b", "@"), List(2, "b", "@"), List(3, "b", "@"))
    assert(CommonUtils.crossProduct(input) === output)
  }

  test("Cross product of a list of sublist having an empty list") {
    val input = List(List(1, 2, 3), List("a", "b"), List("@"), List())
    assert(CommonUtils.crossProduct(input) === Nil)
  }

  test("Cross product of  an empty list") {
    val input = List()
    assert(CommonUtils.crossProduct(input) === Nil)
  }

  test("Cross product of a list with an empty sub list") {
    val input = List(List())
    assert(CommonUtils.crossProduct(input) === Nil)
  }

  test("Cross product of a list with only one sub list") {
    val input = List(List(1, 2, 3))
    assert(CommonUtils.crossProduct(input) === List(List(1), List(2), List(3)))
  }

  test("Sort a list of sublist by indexes") {
    val input = List(List(5, "a", 7), List(7, "b", 8), List(4, "a", 3), List(1, "b", 2), List(3, "c", 8))
    val output = List(List(4, "a", 3), List(5, "a", 7), List(1, "b", 2), List(7, "b", 8), List(3, "c", 8))
    assert(CommonUtils.sortSubListByIndexes(input, List(1, 0)) === output)
  }

  test("Sort a list of sublist without indexes") {
    val input = List(List(5, "a", 7), List(7, "b", 8), List(4, "a", 3), List(1, "b", 2), List(3, "c", 8))
    val output = List(List(1, "b", 2), List(3, "c", 8), List(4, "a", 3), List(5, "a", 7), List(7, "b", 8))
    assert(CommonUtils.sortSubListByIndexes(input) === output)
  }

  test("Sort a list of sublist having an empty list") {
    val input = List(List(5, "a", 7), List(7, "b", 8), List(4, "a", 3), List(1, "b", 2), List(3, "c", 8), List())
    val output = List(List(), List(1, "b", 2), List(3, "c", 8), List(4, "a", 3), List(5, "a", 7), List(7, "b", 8))
    assert(CommonUtils.sortSubListByIndexes(input) === output)
  }

  test("Filter a list of date greater than 21-03-2011 using a genric compare method") {
    val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val input = List(format.parse("21-03-2011"), format.parse("23-02-1911"), format.parse("21-04-2011"), format.parse("01-05-2011"))
    val isFilter = CommonUtils.compare(format.parse("21-03-2011"), "gt")
    assert((input filter (isFilter(_))) === List(format.parse("21-04-2011"), format.parse("01-05-2011")))
  }

  test("Filter a list of date greater equal than 21-03-2011 using a genric compare method") {
    val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val input = List(format.parse("21-03-2011"), format.parse("23-02-1911"), format.parse("21-04-2011"), format.parse("01-05-2011"))
    val isFilter = CommonUtils.compare(format.parse("21-03-2011"), "gte")
    assert((input filter (isFilter(_))) === List(format.parse("21-03-2011"), format.parse("21-04-2011"), format.parse("01-05-2011")))
  }

  test("Filter a list of integer less than equal 5 using a genric compare method") {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val isFilter = CommonUtils.compare(5, "lte")
    assert((input filter (isFilter(_))) === List(1, 2, 3, 4, 5))
  }

  test("Filter a list of integer less than 5 using a genric compare method") {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val isFilter = CommonUtils.compare(5, "lt")
    assert((input filter (isFilter(_))) === List(1, 2, 3, 4))
  }

  test("Filter a list of integer equal to 5 using a genric compare method") {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val isFilter = CommonUtils.compare(5, "eq")
    assert((input filter (isFilter(_))) === List(5))
  }

}