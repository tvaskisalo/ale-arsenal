package com.example.services

import com.example.dao.addIngredient
import com.example.dao.getAllIngredients
import com.example.dto.IngredientDto
import com.example.dto.NewIngredientCommand
import com.example.dto.NewIngredientDto
import com.example.errors.IngredientValidationError
import com.example.models.Ingredients
import org.jetbrains.exposed.exceptions.ExposedSQLException

@Suppress("SwallowedException")
suspend fun addIngredientService(newIngredient: NewIngredientCommand): NewIngredientDto {
    try {
        val addedIngredientId = addIngredient(newIngredient)
        return NewIngredientDto(addedIngredientId)
    } catch (e: ExposedSQLException) {
        throw IngredientValidationError("Failed to add ingredient: ${e.message}")
    }
}

suspend fun getAllIngredientsService(): List<IngredientDto> {
    val rawIngredients = getAllIngredients()
    return rawIngredients.map {
        IngredientDto(
            it[Ingredients.sequelId],
            it[Ingredients.name],
            it[Ingredients.amount],
            it[Ingredients.ingredientType]
        )
    }
}
