package com.example.dao

import NewOwnBeerCommand
import com.example.models.OwnBeers
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import kotlin.random.Random

suspend fun addOwnBeer(newOwnBeer: NewOwnBeerCommand): Int {
    val addedOwnBeer = suspendedTransactionAsync {
        OwnBeers.insertAndGetId {
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
        }
    }.await()
    return addedOwnBeer.value
}
