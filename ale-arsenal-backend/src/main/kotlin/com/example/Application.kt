package com.example

import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.routers.ingredientRouter
import initDB
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

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
