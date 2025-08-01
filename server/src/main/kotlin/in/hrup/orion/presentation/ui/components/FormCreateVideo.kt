package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.input
import kotlinx.html.button
import kotlinx.html.InputType
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.FlowContent
import `in`.hrup.orion.data.modelsImpl.VideoImpl

fun FlowContent.formCreateVideo(video: VideoImpl? = null) {

    form(classes = "box", action = "/posts/save", method = FormMethod.post) {

        input(type = InputType.hidden, name = "id") {
            value = video?.id?.toString() ?: "0"
        }

        field("Title", "title", video?.title)
        field("Tags", "tags", video?.tags)
        field("SEO Title", "seoTitle", video?.seoTitle)
        field("SEO Description", "seoDescription", video?.seoDescription)
        field("SEO Keywords", "seoKeywords", video?.seoKeywords)

        fileField("Video", "description")

//        field("Slug", "slug", post?.slug)
//        field("SEO Canonical URL", "seoCanonicalUrl", post?.seoCanonicalUrl)
//        div("field") {
//            label("checkbox") {
//                input(type = InputType.checkBox, name = "published") {
//                    if (post?.published == true) checked = true
//                }
//                +" Published"
//            }
//        }

        textareaField("Description", "description", video?.description, rows = 7)

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

    }

}