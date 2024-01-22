package com.example.dao

import NewOwnBeerCommand
import com.example.models.OwnBeers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import kotlin.random.Random

suspend fun addOwnBeer(newOwnBeer: NewOwnBeerCommand): Int {
    val addedOwnBeer = suspendedTransactionAsync {
        OwnBeers.insert {
            it[sequelId] = Random.nextInt(0, Int.MAX_VALUE)
            it[name] = newOwnBeer.name
            it[bottleSize] = newOwnBeer.bottleSize
            it[kegSize] = newOwnBeer.kegSize
            it[bottleAmount] = newOwnBeer.bottleAmount
            it[kegAmount] = newOwnBeer.kegAmount
            it[abv] = newOwnBeer.abv
            it[style] = newOwnBeer.style
            it[brewDate] = newOwnBeer.brewDate
            it[description] = newOwnBeer.description
        }[OwnBeers.sequelId]
    }.await()
    return addedOwnBeer
}

suspend fun getOwnBeerById(id: Int): ResultRow {
    val ownBeer = suspendedTransactionAsync {
        OwnBeers.select(OwnBeers.sequelId eq id).single()
    }.await()
    return ownBeer
}

suspend fun getAllOwnBeers(): List<ResultRow> {
    val ownBeers = suspendedTransactionAsync {
        OwnBeers.selectAll().toList()
    }.await()
    return ownBeers
}
