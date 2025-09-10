package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import kotlinx.html.SECTION
import `in`.hrup.orion.presentation.ui.components.formCreateVideo

fun SECTION.createVideoScreen(video: VideoImpl? = null) {
    formCreateVideo(video = video)
}