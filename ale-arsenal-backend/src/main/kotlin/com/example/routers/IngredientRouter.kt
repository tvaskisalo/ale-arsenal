package com.example.routers

import com.example.controllers.addIngredientController
import com.example.controllers.getIngredientsController
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.ingredientRouter() {
    routing {
        route("/api/ingredient") {
            get {
                getIngredientsController(call)
            }
            post {
                addIngredientController(call)
            }
        }
    }
}
