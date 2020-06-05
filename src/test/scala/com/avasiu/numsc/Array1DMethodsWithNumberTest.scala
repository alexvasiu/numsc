package com.avasiu.numsc

import org.scalatest.funsuite.AnyFunSuite
import ArrayHelpers._

class Array1DMethodsWithNumberTest extends AnyFunSuite {
  final val ArrayForTest: Array[Int] = Array(1, 2, 3)
  final val Number: Int = 3
  final val ArrayAdditionResult: Array[Int] = Array(4, 5, 6) // scalastyle:off
  final val ArrayMultiplicationResult: Array[Int] = Array(3, 6, 9) // scalastyle:off
  final val ArraySubtractionResult: Array[Int] = Array(-2, -1, 0) // scalastyle:off
  final val ArrayDivisionResult: Array[Double] = Array(1.0 / 3, 2.0 / 3, 1) // scalastyle:off
  final val ArrayModuloResult: Array[Int] = Array(1, 2, 0) // scalastyle:off

  test("addition of a number should increase each element of the array with that number") {
    assert(ArrayForTest + Number sameElements ArrayAdditionResult)
    assert(ArrayForTest add Number sameElements ArrayAdditionResult)
  }

  test("multiplication of a number should multiply each element of the array with that number") {
    assert(ArrayForTest * Number sameElements ArrayMultiplicationResult)
    assert(ArrayForTest dot Number sameElements ArrayMultiplicationResult)
  }

  test("subtraction of a number should decrease each element of the array with that number") {
    assert(ArrayForTest - Number sameElements ArraySubtractionResult)
    assert(ArrayForTest subtract Number sameElements ArraySubtractionResult)
  }

  test("division of a number should divide each element of the array with that number") {
    assert(ArrayForTest / Number sameElements ArrayDivisionResult)
    assert(ArrayForTest divide Number sameElements ArrayDivisionResult)
  }

  test("modulo of a number should apply modulo operator on each element of the array with that number") {
    assert(ArrayForTest % Number sameElements ArrayModuloResult)
    assert(ArrayForTest mod Number sameElements ArrayModuloResult)
  }
}
