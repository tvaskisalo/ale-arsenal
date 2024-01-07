package com.example.routers

import com.example.dto.NewIngredientCommand
import com.example.errors.IngredientValidationError
import com.example.services.addIngredientService
import com.example.services.getAllIngredientsService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.ingredientRouter() {
    routing {
        route("/api/ingredient") {
            get {
                val returnVal = getAllIngredientsService()
                if (returnVal.isEmpty()) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    call.respond(returnVal)
                }
            }
            post {
                val newIngredient = call.receive<NewIngredientCommand>()
                try {
                    val returnVal = addIngredientService(newIngredient)
                    call.response.status(HttpStatusCode.Created)
                    call.respond(returnVal)
                } catch (e: IngredientValidationError) {
                    println(e.message)
                    call.response.status(HttpStatusCode.BadRequest)
                }
            }
        }
    }
}
