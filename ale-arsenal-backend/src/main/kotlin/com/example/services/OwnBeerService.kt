package com.example.services

import NewOwnBeerCommand
import NewOwnBeerDto
import com.example.dao.addOwnBeer
import com.example.errors.OwnBeerValidationError
import org.jetbrains.exposed.exceptions.ExposedSQLException

@Suppress("SwallowedException")
suspend fun addOwnBeerService(newOwnBeer: NewOwnBeerCommand): NewOwnBeerDto {
    try {
        val addedOwnBeer = addOwnBeer(newOwnBeer)
        return NewOwnBeerDto(addedOwnBeer)
    } catch (e: ExposedSQLException) {
        throw OwnBeerValidationError("Failed to add own beer: ${e.message}")
    }
}
