package com.example.routers

import NewOwnBeerCommand
import NewOwnBeerDto
import com.example.dao.getOwnBeerById
import com.example.initDB
import com.example.models.OwnBeers
import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.resetDB
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class OwnBeerRouterTest {
    @Test
    fun `Own beer can be added`() = testApplication {
        resetDB()
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
        val res = client.post("/api/ownBeer") {
            contentType(ContentType.Application.Json)
            setBody(
                NewOwnBeerCommand(
                    name = TestData.someOwnBeerName,
                    bottleSize = TestData.someOwnBeerBottleSize,
                    bottleAmount = TestData.someOwnBeerBottleAmount,
                    kegSize = TestData.someOwnBeerKegSize,
                    kegAmount = TestData.someOwnBeerKegAmount,
                    style = TestData.someOwnBeerStyle,
                    abv = TestData.someOwnBeerAbv,
                    brewDate = TestData.someOwnBeerBrewDate,
                )
            )
        }
        assertEquals(HttpStatusCode.Created, res.status)
        val dbOwnBeer = getOwnBeerById(res.body<NewOwnBeerDto>().id)
        assertEquals(dbOwnBeer[OwnBeers.abv], TestData.someOwnBeerAbv)
        assertEquals(dbOwnBeer[OwnBeers.brewDate], TestData.someOwnBeerBrewDate)
        assertEquals(dbOwnBeer[OwnBeers.bottleAmount], TestData.someOwnBeerBottleAmount)
        assertEquals(dbOwnBeer[OwnBeers.bottleSize], TestData.someOwnBeerBottleSize)
        assertEquals(dbOwnBeer[OwnBeers.kegAmount], TestData.someOwnBeerKegAmount)
        assertEquals(dbOwnBeer[OwnBeers.kegSize], TestData.someOwnBeerKegSize)
        assertEquals(dbOwnBeer[OwnBeers.name], TestData.someOwnBeerName)
        assertEquals(dbOwnBeer[OwnBeers.style], TestData.someOwnBeerStyle)
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun initDatabase() {
            initDB()
        }
    }
}
