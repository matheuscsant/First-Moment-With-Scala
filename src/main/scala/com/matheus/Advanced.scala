package com.matheus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 2

  // useful in infinite collections

  // "pseudo-collections": Option, Try

  def methodWhichCanReturnNull(): String = "Hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello, Scala")
  // option = "collection" which contains as most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException()

  //  try {
  //    methodWhichCanThrowException()
  //  } catch {
  //    case e: Exception => println("Defend against this evil exception")
  //  }

  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection"  with either a value if the code went null, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"I have obtained an expcetion: $exception"
  }
  // map, flatMap, filter

  /**
   * Evaluate something on another thread
   * (asynchronous programing)
   */

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed value.")
    67
  }

  // future is a "collection" which contains a value when It's evaluated
  // future is composable with map, flatMap and filter
  // monads

  /**
   * Implicits basics
   */
  // #1: Implict arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: Implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23).isEven()
  // use this carefully
}
