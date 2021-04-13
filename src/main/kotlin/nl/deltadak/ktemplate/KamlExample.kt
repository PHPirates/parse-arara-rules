package nl.deltadak.ktemplate

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val leader: String,
    val members: List<String>
)

fun main() {

    val input = Team("Amy", listOf("Bob", "Cindy", "Dan"))

    val result = Yaml.default.encodeToString(Team.serializer(), input)

    println(result)
}
