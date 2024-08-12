package com.matheus.api


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.*
import akka.http.scaladsl.server.Directives.*

import scala.concurrent.ExecutionContext.Implicits.global

// https://www.baeldung.com/scala/akka-http
object UndestandingOpeningServer extends App {

  implicit val system: ActorSystem = ActorSystem("UndestandingOpeningServer")

  val route: Route = concat(get {
    pathPrefix("path") {
      complete({
        println("Finally right")
        "Success"
      })
    }
  },
    get {
      pathPrefix("other") {
        complete({
          println("Finally right 2")
          "Success 2"
        })
      }
    }
  )

  val server = Http().newServerAt("localhost", 8080).bind(route)
  server.map { _ => println("Success to start the server on: localhost:8080")
  } recover {
    case e => println(s"Failed to start the server: ${e.getMessage}")
  }
}