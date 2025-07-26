package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.presentation.ui.components.formCreatePost
import kotlinx.html.SECTION

fun SECTION.createPostScreen(post: PostImpl? = null) {
    formCreatePost(post = post)
}