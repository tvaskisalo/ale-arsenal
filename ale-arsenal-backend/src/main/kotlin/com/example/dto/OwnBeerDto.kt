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
