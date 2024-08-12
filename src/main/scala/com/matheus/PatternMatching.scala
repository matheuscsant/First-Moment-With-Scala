package com.matheus

object PatternMatching extends App {

  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInteger + "th"
  }
  // PM is an EXPRESSION

  println(order)

  // Case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a year old."
    case _ => "Something else"
  }

  println(personGreeting)

  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing List
  val aList = List(1, 2, 3, 4)
  val listDescriptions = aList match {
    case List(_, 2, _) => "List containing 2 in its second position"
    case _ => "Unknow list"
  }

  // if PM doesn't math anything, it wil throw a MathError
  // PM will try all cases in sequence
}
