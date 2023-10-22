package com.example.routers

import com.example.controllers.addIngredientController
import com.example.controllers.getIngredientsController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.ingredientRouter() {
    routing {
        route("/api/ingredient") {
            get() {
                getIngredientsController(call)
            }
            post() {
                addIngredientController(call)
            }
        }
    }
}