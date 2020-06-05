package com.avasiu.numsc

import com.avasiu.numsc.exceptions.ArrayLengthException
import ArrayHelpers._
import org.scalatest.funsuite.AnyFunSuite

class Array1DMethodsWithArrayTest extends AnyFunSuite {
  final val Array1: Array[Int] = Array(1, 2, 3)
  final val Array2: Array[Int] = Array(1, 2)

  test("dot of two arrays with the same length should return an number") {
    assert(Array1.dot(Array1) == 14)
  }

  test("product of two arrays with the same length should return an array") {
    assert(Array1 multiply Array1 sameElements Array(1.0, 4.0, 9.0)) // scalastyle:off
    assert(Array1 * Array1 sameElements Array(1.0, 4.0, 9.0)) // scalastyle:off
  }

  test("product of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException](
      Array1.multiply(Array2)
    )

    assertThrows[ArrayLengthException](
      Array1 * Array2
    )
  }

  test("addition of two arrays with the same length should return an array") {
    assert(Array1.add(Array1) sameElements Array(2, 4, 6)) // scalastyle:off
    assert(Array1 + Array1 sameElements Array(2, 4, 6)) // scalastyle:off
  }

  test("addition of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException](
      Array1.add(Array2)
    )

    assertThrows[ArrayLengthException](
      Array1 + Array2
    )
  }

  test("subtract of two arrays with the same length should return an array") {
    assert(Array1.subtract(Array1) sameElements Array(0, 0, 0))
    assert(Array1 - Array1 sameElements Array(0, 0, 0))
  }

  test("subtract of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException]{
      Array1.subtract(Array2)
    }

    assertThrows[ArrayLengthException]{
      Array1 - Array2
    }
  }

  test("division of two arrays with the same length should return an array") {
    assert(Array1.divide(Array1) sameElements Array(1, 1, 1))
    assert(Array1 / Array1 sameElements Array(1, 1, 1))
  }

  test("division of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException]{
      Array1.divide(Array2)
    }

    assertThrows[ArrayLengthException]{
      Array1 / Array2
    }
  }

  test("modulo of two arrays with the same length should return an array") {
    assert(Array1.mod(Array1) sameElements Array(0, 0, 0))
    assert(Array1 % Array1 sameElements Array(0, 0, 0))
  }

  test("modulo of two arrays with the different length should throw an exception") {
    assertThrows[ArrayLengthException]{
      Array1.mod(Array2)
    }

    assertThrows[ArrayLengthException]{
      Array1 % Array2
    }
  }
}
