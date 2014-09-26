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

}