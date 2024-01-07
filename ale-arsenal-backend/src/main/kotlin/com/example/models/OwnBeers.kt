package com.example.models

import org.jetbrains.exposed.dao.id.IntIdTable

object OwnBeers : IntIdTable() {
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", STR_DEFAULT_LEN)
    val bottleSize = double("bottle_size").nullable()
    val kegSize = double("keg_size").nullable()
    val bottleAmount = integer("bottle_amount")
    val kegAmount = integer("keg_amount")
    val abv = double("abv").nullable()
    val style = varchar("style", STR_DEFAULT_LEN)
    val brewDate = varchar("brew_date", STR_DEFAULT_LEN)
    val description = varchar("description", DESCRIPTION_LEN)
}
