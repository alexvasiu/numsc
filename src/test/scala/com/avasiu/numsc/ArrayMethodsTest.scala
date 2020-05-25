package com.avasiu.numsc

import com.avasiu.numsc.exceptions.ArrayLengthException
import ArrayHelpers._
import org.scalatest.funsuite.AnyFunSuite

class ArrayMethodsTest extends AnyFunSuite {
  final val Array1: Array[Int] = Array(1, 2, 3)
  final val Array2: Array[Int] = Array(1, 2, 3)
  final val Array3: Array[Int] = Array(1, 2)

  test("product of two arrays with the same length should return an array") {
    assert(Array1.dot(Array2) sameElements Array(1.0, 4.0, 9.0)) // scalastyle:off
    assert(Array1 * Array2 sameElements Array(1.0, 4.0, 9.0)) // scalastyle:off
  }

  test("product of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException](
      Array1.dot(Array3)
    )

    assertThrows[ArrayLengthException](
      Array1 * Array3
    )
  }

  test("addition of two arrays with the same length should return an array") {
    assert(Array1.add(Array2) sameElements Array(2, 4, 6)) // scalastyle:off
    assert(Array1 + Array2 sameElements Array(2, 4, 6)) // scalastyle:off
  }

  test("addition of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException](
      Array1.add(Array3)
    )

    assertThrows[ArrayLengthException](
      Array1 + Array3
    )
  }

  test("subtract of two arrays with the same length should return an array") {
    assert(Array1.subtract(Array2) sameElements Array(0, 0, 0))
    assert(Array1 - Array2 sameElements Array(0, 0, 0))
  }

  test("subtract of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException]{
      Array1.subtract(Array3)
    }

    assertThrows[ArrayLengthException]{
      Array1 - Array3
    }
  }

  test("division of two arrays with the same length should return an array") {
    assert(Array1.divide(Array2) sameElements Array(1, 1, 1))
    assert(Array1 / Array2 sameElements Array(1, 1, 1))
  }

  test("division of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException]{
      Array1.divide(Array3)
    }

    assertThrows[ArrayLengthException]{
      Array1 / Array3
    }
  }
}
