package com.example.routers

import NewOwnBeerCommand
import com.example.initDB
import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.resetDB
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OwnBeerRouterTest {
    @Test
    fun ownBeerAddition() = testApplication {
        application {
            configureHTTP()
            configureSecurity()
            ownBeerRouter()
        }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        initDB()
        resetDB()
        val res = client.post("/api/ownBeer") {
            contentType(ContentType.Application.Json)
            setBody(
                NewOwnBeerCommand(
                    name = "Own IPA",
                    bottleSize = null,
                    kegSize = null,
                    style = "IPA",
                    abv = null,
                    brewDate = "6.1.2024",
                )
            )
        }
        assertEquals(HttpStatusCode.Created, res.status)
    }
}
