package com.example.routers

import NewOwnBeerCommand
import com.example.errors.OwnBeerValidationError
import com.example.services.addOwnBeerService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.ownBeerRouter() {
    routing {
        route("/api/ownBeer") {
            post {
                val newOwnBeer = call.receive<NewOwnBeerCommand>()
                try {
                    val returnVal = addOwnBeerService(newOwnBeer)
                    call.response.status(HttpStatusCode.Created)
                    call.respond(returnVal)
                } catch (e: OwnBeerValidationError) {
                    println(e.message)
                    call.response.status(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}
