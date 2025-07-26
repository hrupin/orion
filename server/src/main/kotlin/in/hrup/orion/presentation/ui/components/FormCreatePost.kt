package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.input
import kotlinx.html.button
import kotlinx.html.InputType
import kotlinx.html.ButtonType
import kotlinx.html.FormMethod
import kotlinx.html.FlowContent
import `in`.hrup.orion.data.modelsImpl.PostImpl
import kotlinx.html.FormEncType

fun FlowContent.formCreatePost(post: PostImpl? = null) {

    form(classes = "box", action = "/posts/create", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        input(type = InputType.hidden, name = "id") {
            value = post?.id?.toString() ?: "0"
        }

        field("Title", "title", post?.title)
        field("Tags", "tags", post?.tags)
        field("SEO Title", "seoTitle", post?.seoTitle)
        field("SEO Description", "seoDescription", post?.seoDescription)
        field("SEO Keywords", "seoKeywords", post?.seoKeywords)


        fileField("Image", "description")

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

        textareaField("Description", "description", post?.description, rows = 7)
        textareaField("Content", "content", post?.content, rows = 15)

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

    }

}