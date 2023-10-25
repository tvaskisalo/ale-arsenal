package com.example.models

import org.jetbrains.exposed.dao.id.IntIdTable

const val STR_DEFAULT_LEN = 50
object Ingredients : IntIdTable() {
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", STR_DEFAULT_LEN)
    val amount = double("amount")
    val ingredientType = varchar("ingredient_type", STR_DEFAULT_LEN)
}
