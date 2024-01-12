package com.example.dao

import com.example.dto.NewIngredientCommand
import com.example.models.Ingredients
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import kotlin.random.Random


suspend fun addIngredient(newIngredient: NewIngredientCommand): Int {
    val addedIngredient = suspendedTransactionAsync {
        Ingredients.insert {
            it[sequelId] = Random.nextInt(0, Int.MAX_VALUE)
            it[name] = newIngredient.name
            it[amount] = newIngredient.amount
            it[ingredientType] = newIngredient.ingredientType
        }[Ingredients.sequelId]
    }.await()
    return addedIngredient
}

suspend fun getIngredientById(id: Int): ResultRow {
    val ingredient = suspendedTransactionAsync {
        Ingredients.select(Ingredients.sequelId eq id).single()
    }.await()
    return ingredient
}

suspend fun getAllIngredients(): List<ResultRow> {
    val ingredients = suspendedTransactionAsync {
        Ingredients.selectAll().toList()
    }.await()
    return ingredients
}
