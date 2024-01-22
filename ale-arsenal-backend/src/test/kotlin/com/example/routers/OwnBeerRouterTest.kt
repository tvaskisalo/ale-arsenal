package com.example.routers

import NewOwnBeerDto
import OwnBeerDetailsDto
import OwnBeerListItemDto
import com.example.dao.addOwnBeer
import com.example.dao.getOwnBeerById
import com.example.initDB
import com.example.models.OwnBeers
import com.example.plugins.configureHTTP
import com.example.plugins.configureSecurity
import com.example.resetDB
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
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
                TestData.someNewOwnBeerCommand
            )
        }
        assertEquals(HttpStatusCode.Created, res.status)
        val dbOwnBeer = getOwnBeerById(res.body<NewOwnBeerDto>().id)
        assertEquals(dbOwnBeer[OwnBeers.abv], TestData.someNewOwnBeerCommand.abv)
        assertEquals(dbOwnBeer[OwnBeers.brewDate], TestData.someNewOwnBeerCommand.brewDate)
        assertEquals(dbOwnBeer[OwnBeers.bottleAmount], TestData.someNewOwnBeerCommand.bottleAmount)
        assertEquals(dbOwnBeer[OwnBeers.bottleSize], TestData.someNewOwnBeerCommand.bottleSize)
        assertEquals(dbOwnBeer[OwnBeers.kegAmount], TestData.someNewOwnBeerCommand.kegAmount)
        assertEquals(dbOwnBeer[OwnBeers.kegSize], TestData.someNewOwnBeerCommand.kegSize)
        assertEquals(dbOwnBeer[OwnBeers.name], TestData.someNewOwnBeerCommand.name)
        assertEquals(dbOwnBeer[OwnBeers.style], TestData.someNewOwnBeerCommand.style)
    }

    @Test
    fun `Own beer can be fetched with id`() = testApplication {
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
        val ownBeerId = addOwnBeer(
            TestData.someNewOwnBeerCommand
        )
        val res = client.get("/api/ownBeer/$ownBeerId") {
            ContentType.Application.Json
        }
        assertEquals(HttpStatusCode.OK, res.status)
        val fetchedOwnBeer = res.body<OwnBeerDetailsDto>()
        assertEquals(fetchedOwnBeer.id, ownBeerId)
        assertEquals(fetchedOwnBeer.abv, TestData.someNewOwnBeerCommand.abv)
        assertEquals(fetchedOwnBeer.brewDate, TestData.someNewOwnBeerCommand.brewDate)
        assertEquals(fetchedOwnBeer.bottleAmount, TestData.someNewOwnBeerCommand.bottleAmount)
        assertEquals(fetchedOwnBeer.bottleSize, TestData.someNewOwnBeerCommand.bottleSize)
        assertEquals(fetchedOwnBeer.kegAmount, TestData.someNewOwnBeerCommand.kegAmount)
        assertEquals(fetchedOwnBeer.kegSize, TestData.someNewOwnBeerCommand.kegSize)
        assertEquals(fetchedOwnBeer.name, TestData.someNewOwnBeerCommand.name)
        assertEquals(fetchedOwnBeer.style, TestData.someNewOwnBeerCommand.style)
    }

    @Test
    fun `All Own beers can be fetched`() = testApplication {
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

        val ownBeer1Id = addOwnBeer(
            TestData.someNewOwnBeerCommand
        )

        val ownBeer2Id = addOwnBeer(
            TestData.someOtherNewOwnBeerCommand
        )

        val res = client.get("/api/ownBeer") {
            ContentType.Application.Json
        }
        assertEquals(HttpStatusCode.OK, res.status)
        val body = res.body<List<OwnBeerListItemDto>>()
        assertEquals(body.size, 2)
        assertEquals(body.map { it.id }, listOf(ownBeer1Id, ownBeer2Id))
        assertEquals(
            body.map {
                it.style
            },
            listOf(TestData.someNewOwnBeerCommand.style, TestData.someOtherNewOwnBeerCommand.style)
        )
        assertEquals(
            body.map { it.abv },
            listOf(TestData.someNewOwnBeerCommand.abv, TestData.someOtherNewOwnBeerCommand.abv)
        )
        assertEquals(
            body.map {
                it.name
            },
            listOf(TestData.someNewOwnBeerCommand.name, TestData.someOtherNewOwnBeerCommand.name)
        )
        assertEquals(
            body.map {
                it.brewDate
            },
            listOf(TestData.someNewOwnBeerCommand.brewDate, TestData.someOtherNewOwnBeerCommand.brewDate)
        )
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun initDatabase() {
            initDB()
        }
    }
}
