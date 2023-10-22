package com.example

import com.example.plugins.*
import com.example.routers.ingredientRouter
import initDB
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
  initDB()
  embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
    .start(wait = true)
}

fun Application.module() {
  configureHTTP()
  configureSecurity()
  ingredientRouter()
}
