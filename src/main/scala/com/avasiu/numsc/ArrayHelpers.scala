package com.avasiu.numsc

import com.avasiu.numsc.exceptions.ArrayLengthException

object ArrayHelpers {
  implicit class ArrayMethods(val array: Array[Double]) {
    private def applyOperation(other: Array[Double])(function: (Double, Double) => Double): Array[Double] = {
      if (array.length != other.length) {
        throw ArrayLengthException("The arrays must have the same size")
      }
      else {
        array.zip(other).map(element => function(element._1, element._2))
      }
    }

    def dot(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a * b)

    def dot(other: Double): Array[Double] = array.map(_ * other)

    def *(other: Array[Double]): Array[Double] = dot(other) // scalastyle:off

    def *(other: Double): Array[Double] = dot(other)

    def add(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a + b)

    def add(other: Double): Array[Double] = array.map(_ + other)

    def +(other: Array[Double]): Array[Double] = add(other)

    def +(other: Double): Array[Double] = add(other)

    def subtract(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a - b)

    def subtract(other: Double): Array[Double] = array.map(_ - other)

    def -(other: Array[Double]): Array[Double] = subtract(other)

    def -(other: Double): Array[Double] = subtract(other)

    def divide(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a / b)

    def /(other: Array[Double]): Array[Double] = divide(other)

    def divide(other: Double): Array[Double] = array.map(_ / other)

    def /(other: Double): Array[Double] = divide(other)
  }

  implicit class ArrayMethodsInt(val arrayInt: Array[Int]) extends ArrayMethods(arrayInt.map(_.toDouble))

  implicit class ArrayMethodsFloat(val arrayFloat: Array[Float]) extends ArrayMethods(arrayFloat.map(_.toDouble))

  implicit class ArrayMethodsNumber(val arrayNumber: Array[Number]) extends ArrayMethods(arrayNumber.map(_.doubleValue))

  implicit def conversionIntToDouble(array: Array[Int]): Array[Double] = array.map(_.toDouble)

  implicit def conversionIntToFloat(array: Array[Float]): Array[Double] = array.map(_.toDouble)

  implicit def conversionIntToNumber(array: Array[Number]): Array[Double] = array.map(_.doubleValue)
}