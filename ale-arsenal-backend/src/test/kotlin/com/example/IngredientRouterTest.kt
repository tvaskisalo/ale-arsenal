package com.example

import com.example.dto.NewIngredientCommand
import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.routers.ingredientRouter
import initDB
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
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
            setBody(
                NewIngredientCommand(
                    "barley malt",
                    1.0,
                    "malt"
                )
            )
        }
        assertEquals(HttpStatusCode.Created, res.status)
    }
}
