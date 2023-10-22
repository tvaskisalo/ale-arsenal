package com.example.controllers

import com.example.dao.*
import com.example.dto.NewIngredientCommand
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

suspend fun addIngredientController(call: ApplicationCall) {
    val newIngredient = call.receive<NewIngredientCommand>()
    try {
        val returnVal = addIngredient(newIngredient)
        call.response.status(HttpStatusCode.Created)
        call.respond(returnVal)
    } catch (e: Error) {
        call.response.status(HttpStatusCode.BadRequest)
    }
}

suspend fun getIngredientsController(call: ApplicationCall) {
    try {
        val returnVal = getIngredients()
        call.respond(returnVal)
    } catch (e: Error) {
        call.respond(HttpStatusCode.NotFound)
    }
}