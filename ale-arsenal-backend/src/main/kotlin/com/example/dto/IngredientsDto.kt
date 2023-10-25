package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDto(
    val id: Int,
    val name: String,
    val amount: Double,
    val ingredientType: String
)

@Serializable
data class NewIngredientCommand(
    val name: String,
    val amount: Double,
    val ingredientType: String
)
