package com.example.models

import org.jetbrains.exposed.dao.id.IntIdTable

object Ingredients : IntIdTable() {
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", STR_DEFAULT_LEN)
    val amount = double("amount")
    val ingredientType = varchar("ingredient_type", STR_DEFAULT_LEN)
}
