package com.example

import com.example.dto.IngredientDto
import com.example.dto.NewIngredientCommand
import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.routers.ingredientRouter
import initDB
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class IngredientRouterTest {
    @Test
    fun ingredientAddition() = testApplication {
        application {
            configureHTTP()
            configureSecurity()
            ingredientRouter()
        }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        initDB()
        val res = client.post("/api/ingredient") {
            contentType(ContentType.Application.Json)
            setBody(NewIngredientCommand(
                "barley malt",
                1.0,
                "malt"
            ))
        }
        assertEquals(HttpStatusCode.Created, res.status)
    }
}