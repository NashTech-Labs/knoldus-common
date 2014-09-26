/**
 * Copyright (C) Knoldus Software LLP. <http://www.knoldus.com>
 */

package util

/**
 * This object contains common utility functions.
 * These functions are generally used in many projects.
 * For Example:- Sorting list of list index wise,
 * preserve ordering of collection while doing groupBy etc.
 *
 * @author ayush
 */

object CommonUtils {

  /**
   * Type-agnostic solution to do Cross Product of all sub list.
   *
   * Example:-
   * scala> val input = List(List(1,2,3),List("a","b"),List("@"))
   * input: List[List[Any]] = List(List(1, 2, 3), List(a, b), List(@))
   *
   * scala> crossProduct(input)
   * res0: List[List[Any]] = List(List(1, a, @), List(2, a, @), List(3, a, @), List(1, b, @), List(2, b, @), List(3, b, @))
   *
   * @param elements: List of sub lists of any type
   * @return List of crossed sub list
   */
  def crossProduct[A](elements: List[List[A]]): List[List[A]] =
    elements match {
      case element :: nextElement :: Nil => element.map(a => nextElement.map(b => List(a, b))).flatten
      case element :: currentElement :: nextElement =>
        crossProduct(currentElement :: nextElement).map(li => element.map(a => a :: li)).flatten
      case element :: Nil => element.map(a => List(List(a))).flatten
      case _ => elements
    }

  /**
   * Solution to sort sub list by list of indexes.
   *
   * Example:-
   * scala> val input = List(List(5,"a",7),List(7,"b",8),List(4,"a",3),List(1,"b",2),List(3,"c",8))
   * input: List[List[Any]] = List(List(5, a, 7), List(7, b, 8), List(4, a, 3), List(1, b, 2), List(3, c, 8))
   *
   * scala> sortSubListByIndexes(input,List(1,0))
   * res5: List[List[_]] = List(List(4, a, 3), List(5, a, 7), List(1, b, 2), List(7, b, 8), List(3, c, 8))
   *
   * If there is no index, default sorting would be applied on List
   * @param elements: List of sub lists of any type
   * @param indexes: List of indexes, on which sorting to be done
   * @return List of sorted sub list by indexes
   */

  def sortSubListByIndexes(elements: List[List[_]], indexes: List[Int]=Nil) = {
    elements sortBy { element => (indexes map { element(_) }).mkString("") + element.mkString("") }
  }

}
