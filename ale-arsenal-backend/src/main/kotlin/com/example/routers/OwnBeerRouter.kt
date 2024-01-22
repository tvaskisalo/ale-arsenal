package com.example.routers

import NewOwnBeerCommand
import com.example.errors.OwnBeerValidationError
import com.example.services.addOwnBeerService
import com.example.services.getAllOwnBeersService
import com.example.services.getOwnBeerByIdService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
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
            get("/{id}") {
                val id = call.parameters["id"]
                if (id?.toIntOrNull() == null) {
                    call.respond(HttpStatusCode.BadRequest)
                } else {
                    val returnVal = getOwnBeerByIdService(id.toInt())
                    call.respond(returnVal)
                }
            }
            get {
                val returnVal = getAllOwnBeersService()
                if (returnVal.isEmpty()) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    call.respond(returnVal)
                }
            }
        }
    }
}
