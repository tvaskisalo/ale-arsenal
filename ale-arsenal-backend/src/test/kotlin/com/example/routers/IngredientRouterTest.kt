package com.example.routers

import com.example.dao.addIngredient
import com.example.dao.getIngredientById
import com.example.dto.IngredientDto
import com.example.dto.NewIngredientCommand
import com.example.dto.NewIngredientDto
import com.example.initDB
import com.example.models.Ingredients
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
import kotlin.test.assertContains

class IngredientRouterTest {
    @Test
    fun `Ingredient can be added`() = testApplication {
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
        resetDB()
        val res = client.post("/api/ingredient") {
            contentType(ContentType.Application.Json)
            setBody(
                NewIngredientCommand(
                    TestData.someIngredientName1,
                    TestData.someIngredientAmount1,
                    TestData.someIngredientType1,
                )
            )
        }
        assertEquals(HttpStatusCode.Created, res.status)
        val dbIngredient = getIngredientById(res.body<NewIngredientDto>().id)
        assertEquals(dbIngredient[Ingredients.ingredientType], TestData.someIngredientType1)
        assertEquals(dbIngredient[Ingredients.name], TestData.someIngredientName1)
        assertEquals(dbIngredient[Ingredients.amount], TestData.someIngredientAmount1)
    }

    @Test
    fun `All ingredients can be fetched`() = testApplication {
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
        resetDB()

        val ingredientId1 = addIngredient(
            NewIngredientCommand(
                TestData.someIngredientName1,
                TestData.someIngredientAmount1,
                TestData.someIngredientType1
            )
        )
        val ingredientId2 = addIngredient(
            NewIngredientCommand(
                TestData.someIngredientName2,
                TestData.someIngredientAmount2,
                TestData.someIngredientType2
            )
        )
        val res = client.get("/api/ingredient") {
            contentType(ContentType.Application.Json)
        }
        assertEquals(HttpStatusCode.OK, res.status)
        val body = res.body<List<IngredientDto>>()
        assertEquals(2, body.size)
        assertContains(
            body,
            IngredientDto(
                ingredientId1,
                TestData.someIngredientName1,
                TestData.someIngredientAmount1,
                TestData.someIngredientType1
            )
        )
        assertContains(
            body,
            IngredientDto(
                ingredientId2,
                TestData.someIngredientName2,
                TestData.someIngredientAmount2,
                TestData.someIngredientType2
            )
        )
    }

    @Test
    fun `Fetching returns status NOT FOUND when no ingredients exist`() = testApplication {
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
        resetDB()
        val res = client.get("/api/ingredient") {
            contentType(ContentType.Application.Json)
        }
        assertEquals(HttpStatusCode.NotFound, res.status)
    }
    companion object {
        @JvmStatic
        @BeforeAll
        fun initDatabase() {
            initDB()
        }
    }
}
