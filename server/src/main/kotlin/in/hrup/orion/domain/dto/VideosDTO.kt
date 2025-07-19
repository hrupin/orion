package `in`.hrup.orion.domain.dto

import `in`.hrup.orion.domain.models.Video
import kotlinx.serialization.Serializable

@Serializable
data class VideosDTO(
    val videos: List<Video>,
    val count: Long
)
