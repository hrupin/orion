package `in`.hrup.orion.presentation.queries

data class VideosQueryParams(
    val page: Int = 1,
    val month: Int?,
    val year: Int?,
    val tag: String?
)
