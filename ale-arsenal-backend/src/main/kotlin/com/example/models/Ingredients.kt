package com.example.models

import org.jetbrains.exposed.dao.id.IntIdTable

object Ingredients : IntIdTable() {
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", 50)
    val amount = double("amount")
    val ingredientType = varchar("ingredient_type", 50)
}