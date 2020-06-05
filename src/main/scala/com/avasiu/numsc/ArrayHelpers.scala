package com.avasiu.numsc

import com.avasiu.numsc.exceptions.ArrayLengthException

object ArrayHelpers {
  implicit class Array2DMethods(val array: Array[Array[Double]]) {
    def dot(other: Array[Array[Double]]): Array[Array[Double]] = {
      if ((if (array.length > 0) array(0).length else 0) != other.length) {
        throw ArrayLengthException("The number of columns from the first matrix should match " +
          "the number of rows from the second matrix")
      }

      var result: Array[Array[Double]] = Array()
      var current: Array[Double] = Array()
      val noRows: Int = array.length
      val noCols: Int = if (noRows > 0) other(0).length else 0

      for (_ <- 0 until noRows; j <- 0 until noCols) {
        if (j == 0) {
          if (current.nonEmpty) {
            result :+= current
          }
          current = Array()
        }
        current :+= 0.0
      }

      result :+= current

      for (k <- 0 until noCols) {
        for (j <- 0 until noCols) {
          for (i <- 0 until noRows) {
            result(i)(j) += array(i)(k) * other(k)(j)
          }
        }
      }

      result
    }

    def dot(other: Array[Double]): Array[Double] = {
      if ((if (array.length > 0) array(0).length else 0) != other.length) {
        throw ArrayLengthException("The number of columns from the matrix should match " +
          "the number of elements from the array")
      }

      array.map(row => row.multiply(other).sum)
    }

    def dot(other: Double): Array[Array[Double]] = multiply(other)

    //<editor-fold desc="Multiplication">

    def multiply(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)((a, b) => a * b)

    def multiply(other: Array[Double]): Array[Array[Double]] = array.map(el => el.multiply(other))

    def multiply(other: Double): Array[Array[Double]] = array.map(el => el.multiply(other))

    def *(other: Array[Array[Double]]): Array[Array[Double]] = multiply(other) // scalastyle:off

    def *(other: Array[Double]): Array[Array[Double]]  = multiply(other)

    def *(other: Double): Array[Array[Double]]  = multiply(other)

    //</editor-fold>

    //<editor-fold desc="Addition">

    def add(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)((a, b) => a + b)

    def add(other: Array[Double]): Array[Array[Double]] = array.map(el => el.add(other))

    def add(other: Double): Array[Array[Double]] = array.map(el => el.add(other))

    def +(other: Array[Array[Double]]): Array[Array[Double]] = add(other) // scalastyle:off

    def +(other: Array[Double]): Array[Array[Double]]  = add(other)

    def +(other: Double): Array[Array[Double]]  = add(other)

    //</editor-fold>

    //<editor-fold desc="Subtraction">

    def subtract(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)((a, b) => a - b)

    def subtract(other: Array[Double]): Array[Array[Double]] = array.map(el => el.subtract(other))

    def subtract(other: Double): Array[Array[Double]] = array.map(el => el.subtract(other))

    def -(other: Array[Array[Double]]): Array[Array[Double]] = subtract(other) // scalastyle:off

    def -(other: Array[Double]): Array[Array[Double]]  = subtract(other)

    def -(other: Double): Array[Array[Double]]  = subtract(other)

    //</editor-fold>

    //<editor-fold desc="Division">

    def divide(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)((a, b) => a / b)

    def divide(other: Array[Double]): Array[Array[Double]] = array.map(el => el.divide(other))

    def divide(other: Double): Array[Array[Double]] = array.map(el => el.divide(other))

    def /(other: Array[Array[Double]]): Array[Array[Double]] = divide(other) // scalastyle:off

    def /(other: Array[Double]): Array[Array[Double]]  = divide(other)

    def /(other: Double): Array[Array[Double]]  = divide(other)

    //</editor-fold>

    //<editor-fold desc="Modulo">

    def mod(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)((a, b) => a % b)

    def mod(other: Array[Double]): Array[Array[Double]] = array.map(el => el.mod(other))

    def mod(other: Double): Array[Array[Double]] = array.map(el => el.mod(other))

    def %(other: Array[Array[Double]]): Array[Array[Double]] = mod(other) // scalastyle:off

    def %(other: Array[Double]): Array[Array[Double]]  = mod(other)

    def %(other: Double): Array[Array[Double]]  = mod(other)

    //</editor-fold>

    //<editor-fold desc="Trigonometric functions">

    def sin: Array[Array[Double]] = applyOperator(Math.sin)

    def cos: Array[Array[Double]] = applyOperator(Math.cos)

    def tan: Array[Array[Double]] = applyOperator(Math.tan)

    def asin: Array[Array[Double]] = applyOperator(Math.asin)

    def acos: Array[Array[Double]] = applyOperator(Math.acos)

    def atan: Array[Array[Double]] = applyOperator(Math.atan)

    def hypot(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)(Math.hypot)

    def arctan2(other: Array[Array[Double]]): Array[Array[Double]] = applyOperation(other)(Math.atan2)

    def degrees: Array[Array[Double]] = applyOperator(Math.toDegrees)

    def radians: Array[Array[Double]] = applyOperator(Math.toRadians)

    def deg2rad: Array[Array[Double]] = radians

    def rad2deg: Array[Array[Double]] = degrees

    def sinh: Array[Array[Double]] = applyOperator(Math.sinh)

    def cosh: Array[Array[Double]] = applyOperator(Math.cosh)

    def tanh: Array[Array[Double]] = applyOperator(Math.tanh)

    //</editor-fold>

    //<editor-fold desc="Rounding functions">

    def around: Array[Array[Double]] = applyOperator(x => Math.round(x.toFloat))

    def floor: Array[Array[Double]] = applyOperator(Math.floor)

    def ceil: Array[Array[Double]] = applyOperator(Math.ceil)

    def rint: Array[Array[Double]] = applyOperator(Math.rint)

    //</editor-fold>

    //<editor-fold desc="Private helper functions">

    private def applyOperation(other: Array[Array[Double]])(function: (Double, Double) => Double): Array[Array[Double]] = {
      if (array.length != other.length) {
        throw ArrayLengthException("The arrays must have the same size")
      }
      else {
        array.zip(other).map(element => element._1.zip(element._2).map(elementDeep => function(elementDeep._1, elementDeep._2)))
      }
    }

    private def applyOperator(operator: Double => Double): Array[Array[Double]] = array.map(elements => elements.map(operator))

    //</editor-fold>
  }

  implicit class Array2DMethodsInt(val arrayInt: Array[Array[Int]]) extends Array2DMethods(arrayInt.map(_.map(_.toDouble)))

  implicit class Array2DMethodsFloat(val arrayFloat: Array[Array[Float]]) extends Array2DMethods(arrayFloat.map(_.map(_.toDouble)))

  implicit class Array2DMethodsNumber(val arrayNumber: Array[Array[Number]]) extends Array2DMethods(arrayNumber.map(_.map(_.doubleValue)))

  implicit class Array2DMethodsLong(val arrayLong: Array[Array[Long]]) extends Array2DMethods(arrayLong.map(_.map(_.toDouble)))

  implicit def conversionIntToDouble(array: Array[Array[Int]]): Array[Array[Double]] = array.map(_.map(_.toDouble))

  implicit def conversionIntToFloat(array: Array[Array[Float]]): Array[Array[Double]] = array.map(_.map(_.toDouble))

  implicit def conversionIntToNumber(array: Array[Array[Number]]): Array[Array[Double]] = array.map(_.map(_.doubleValue))

  implicit def conversionIntToLong(array: Array[Array[Long]]): Array[Array[Double]] = array.map(_.map(_.toDouble))

  implicit class ArrayMethods(val array: Array[Double]) {
    def dot(other: Array[Double]): Double = multiply(other).sum

    def dot(other: Double): Array[Double] = multiply(other)

    //<editor-fold desc="Multiplication">

    def multiply(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a * b)

    def multiply(other: Double): Array[Double] = applyOperator(_ * other)

    def *(other: Array[Double]): Array[Double] = multiply(other) // scalastyle:off

    def *(other: Double): Array[Double] = multiply(other)

    //</editor-fold>

    //<editor-fold desc="Addition">

    def add(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a + b)

    def add(other: Double): Array[Double] = applyOperator(_ + other)

    def +(other: Array[Double]): Array[Double] = add(other)

    def +(other: Double): Array[Double] = add(other)

    //</editor-fold>

    //<editor-fold desc="Subtraction">

    def subtract(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a - b)

    def subtract(other: Double): Array[Double] = applyOperator(_ - other)

    def -(other: Array[Double]): Array[Double] = subtract(other)

    def -(other: Double): Array[Double] = subtract(other)

    //</editor-fold>

    //<editor-fold desc="Division">

    def divide(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a / b)

    def /(other: Array[Double]): Array[Double] = divide(other)

    def divide(other: Double): Array[Double] = applyOperator(_ / other)

    def /(other: Double): Array[Double] = divide(other)

    //</editor-fold>

    //<editor-fold desc="Modulo">

    def mod(other: Double): Array[Double] = applyOperator(_ % other)

    def %(other: Double): Array[Double] = mod(other)

    def mod(other: Array[Double]): Array[Double] = applyOperation(other)((a, b) => a % b)

    def %(other: Array[Double]): Array[Double] = mod(other)

    //</editor-fold>

    //<editor-fold desc="Trigonometric functions">

    def sin: Array[Double] = applyOperator(Math.sin)

    def cos: Array[Double] = applyOperator(Math.cos)

    def tan: Array[Double] = applyOperator(Math.tan)

    def asin: Array[Double] = applyOperator(Math.asin)

    def acos: Array[Double] = applyOperator(Math.acos)

    def atan: Array[Double] = applyOperator(Math.atan)

    def hypot(other: Array[Double]): Array[Double] = applyOperation(other)(Math.hypot)

    def arctan2(other: Array[Double]): Array[Double] = applyOperation(other)(Math.atan2)

    def degrees: Array[Double] = applyOperator(Math.toDegrees)

    def radians: Array[Double] = applyOperator(Math.toRadians)

    def deg2rad: Array[Double] = radians

    def rad2deg: Array[Double] = degrees

    def sinh: Array[Double] = applyOperator(Math.sinh)

    def cosh: Array[Double] = applyOperator(Math.cosh)

    def tanh: Array[Double] = applyOperator(Math.tanh)

    //</editor-fold>

    //<editor-fold desc="Rounding functions">

    def around: Array[Double] = applyOperator(x => Math.round(x.toFloat))

    def floor: Array[Double] = applyOperator(Math.floor)

    def ceil: Array[Double] = applyOperator(Math.ceil)

    def rint: Array[Double] = applyOperator(Math.rint)

    //</editor-fold>

    //<editor-fold desc="Private helper functions">

    private def applyOperation(other: Array[Double])(function: (Double, Double) => Double): Array[Double] = {
      if (array.length != other.length) {
        throw ArrayLengthException("The arrays must have the same size")
      }
      else {
        array.zip(other).map(element => function(element._1, element._2))
      }
    }

    private def applyOperator(operator: Double => Double): Array[Double] = array.map(operator)

    //</editor-fold>
  }

  implicit class ArrayMethodsInt(val arrayInt: Array[Int]) extends ArrayMethods(arrayInt.map(_.toDouble))

  implicit class ArrayMethodsFloat(val arrayFloat: Array[Float]) extends ArrayMethods(arrayFloat.map(_.toDouble))

  implicit class ArrayMethodsNumber(val arrayNumber: Array[Number]) extends ArrayMethods(arrayNumber.map(_.doubleValue))

  implicit class ArrayMethodsLong(val arrayLong: Array[Long]) extends ArrayMethods(arrayLong.map(_.toDouble))

  implicit def conversionIntToDouble(array: Array[Int]): Array[Double] = array.map(_.toDouble)

  implicit def conversionIntToFloat(array: Array[Float]): Array[Double] = array.map(_.toDouble)

  implicit def conversionIntToNumber(array: Array[Number]): Array[Double] = array.map(_.doubleValue)

  implicit def conversionIntToLong(array: Array[Long]): Array[Double] = array.map(_.toDouble)
}