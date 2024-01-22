package com.example.routers

import NewOwnBeerCommand

object TestData {
    const val someIngredientAmount1 = 10.0
    const val someIngredientAmount2 = 20.0
    const val someIngredientName1 = "Barley malt"
    const val someIngredientName2 = "Citra"
    const val someIngredientType1 = "malt"
    const val someIngredientType2 = "hop"
    const val someOwnBeerAbv1 = 0.05
    const val someOwnBeerAbv2 = 0.15
    const val someOwnBeerBrewDate1 = "6.1.2024"
    const val someOwnBeerBrewDate2 = "6.2.2024"
    const val someOwnBeerBottleAmount1 = 10
    const val someOwnBeerBottleAmount2 = 20
    const val someOwnBeerBottleSize1 = 0.33
    const val someOwnBeerBottleSize2 = 0.5
    const val someOwnBeerKegAmount1 = 1
    const val someOwnBeerKegAmount2 = 2
    const val someOwnBeerKegSize1 = 10.5
    const val someOwnBeerKegSize2 = 20.5
    const val someOwnBeerName1 = "Own IPA"
    const val someOwnBeerName2 = "Own APA"
    const val someOwnBeerStyle1 = "IPA"
    const val someOwnBeerStyle2 = "APA"

    val someNewOwnBeerCommand = NewOwnBeerCommand(
        name = someOwnBeerName1,
        bottleSize = someOwnBeerBottleSize1,
        bottleAmount = someOwnBeerBottleAmount1,
        kegSize = someOwnBeerKegSize1,
        kegAmount = someOwnBeerKegAmount1,
        style = someOwnBeerStyle1,
        abv = someOwnBeerAbv1,
        brewDate = someOwnBeerBrewDate1,
    )

    val someOtherNewOwnBeerCommand = NewOwnBeerCommand(
        name = someOwnBeerName2,
        bottleSize = someOwnBeerBottleSize2,
        bottleAmount = someOwnBeerBottleAmount2,
        kegSize = someOwnBeerKegSize2,
        kegAmount = someOwnBeerKegAmount2,
        style = someOwnBeerStyle2,
        abv = someOwnBeerAbv2,
        brewDate = someOwnBeerBrewDate2,
    )
}
