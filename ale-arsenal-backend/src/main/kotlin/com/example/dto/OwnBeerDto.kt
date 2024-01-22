import kotlinx.serialization.Serializable

@Serializable
data class NewOwnBeerCommand(
    val name: String,
    val bottleSize: Double?,
    val kegSize: Double?,
    val bottleAmount: Int = 0,
    val kegAmount: Int = 0,
    val abv: Double?,
    val style: String,
    val brewDate: String,
    val description: String = ""
)

@Serializable
data class NewOwnBeerDto(val id: Int)

@Serializable
data class OwnBeerListItemDto(
    val id: Int,
    val name: String,
    val abv: Double?,
    val style: String,
    val brewDate: String,
)

@Serializable
data class OwnBeerDetailsDto(
    val id: Int,
    val name: String,
    val bottleSize: Double?,
    val kegSize: Double?,
    val bottleAmount: Int,
    val kegAmount: Int,
    val abv: Double?,
    val style: String,
    val brewDate: String,
    val description: String,
)
