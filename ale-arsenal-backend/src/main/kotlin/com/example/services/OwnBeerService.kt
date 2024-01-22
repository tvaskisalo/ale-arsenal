package com.example.services

import NewOwnBeerCommand
import NewOwnBeerDto
import OwnBeerDetailsDto
import OwnBeerListItemDto
import com.example.dao.addOwnBeer
import com.example.dao.getAllOwnBeers
import com.example.dao.getOwnBeerById
import com.example.errors.OwnBeerValidationError
import com.example.models.OwnBeers
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

suspend fun getAllOwnBeersService(): List<OwnBeerListItemDto> {
    val ownBeers = getAllOwnBeers()
    return ownBeers.map {
        OwnBeerListItemDto(
            id = it[OwnBeers.sequelId],
            abv = it[OwnBeers.abv],
            name = it[OwnBeers.name],
            style = it[OwnBeers.style],
            brewDate = it[OwnBeers.brewDate],
        )
    }
}

suspend fun getOwnBeerByIdService(id: Int): OwnBeerDetailsDto {
    val ownBeer = getOwnBeerById(id)
    return OwnBeerDetailsDto(
        id = ownBeer[OwnBeers.sequelId],
        name = ownBeer[OwnBeers.name],
        bottleSize = ownBeer[OwnBeers.bottleSize],
        kegSize = ownBeer[OwnBeers.kegSize],
        bottleAmount = ownBeer[OwnBeers.bottleAmount],
        kegAmount = ownBeer[OwnBeers.kegAmount],
        abv = ownBeer[OwnBeers.abv],
        style = ownBeer[OwnBeers.style],
        brewDate = ownBeer[OwnBeers.brewDate],
        description = ownBeer[OwnBeers.description],
    )
}
