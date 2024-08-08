package com.matheus

import scala.annotation.static

object Basics extends App {


  // defining a value
  val meaningOfLife: Int = 42 // The same in Java -> const int meaningOfLife = 42;
  println(meaningOfLife)

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false; // dynamic type, don't need to specify the type
  val aTest = 1 // Int
  val aTest2 = 1.0 // Double
  val aTest3 = 1L // Long
  val aTest4 = 1.0F // Float

  // Strings
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife" // Is equals in Dart

  // Expressions = Structures that can be reduced to a value
  val anExpression = 2 + 3

  // If expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // The same to ternary operator -> meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression = if (meaningOfLife > 43) 56
  else if (meaningOfLife < 0) -2
  else if (meaningOfLife > 999) 78
  else 0

  // Code blocks
  val aCodeBlock = {
    // Definitions
    val aLocalValue = 67

    // Value of block is the value of the last expression
    aLocalValue + 3
  }

  // Define a function
  def myFunction(x: Int, y: String): String = y + " " + x // single expression

  def myFunction2(x: Int, y: String): String = {
    y + " " + x
  }

  // Recursive functions
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
  factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  factorial(4) = 4 * factorial(3) = 4 * 6
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
   */

  // In Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === void in java/dart
  // type of SIDE EFFECTS (Messages in screens, to server, to socket, etc...)
  println("I love Scala") // System.out.println("Hello, Java"), log("Hello, Dart")

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
  
}
