package com.example.controllers

import com.example.dao.addIngredient
import com.example.dao.getIngredients
import com.example.dto.NewIngredientCommand
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import org.jetbrains.exposed.exceptions.ExposedSQLException

suspend fun addIngredientController(call: ApplicationCall) {
    val newIngredient = call.receive<NewIngredientCommand>()
    try {
        val returnVal = addIngredient(newIngredient)
        call.response.status(HttpStatusCode.Created)
        call.respond(returnVal)
    } catch (e: ExposedSQLException) {
        println(e.message)
        call.response.status(HttpStatusCode.BadRequest)
    }
}

suspend fun getIngredientsController(call: ApplicationCall) {
    try {
        val returnVal = getIngredients()
        call.respond(returnVal)
    } catch (e: ExposedSQLException) {
        println(e.message)
        call.respond(HttpStatusCode.NotFound)
    }
}
