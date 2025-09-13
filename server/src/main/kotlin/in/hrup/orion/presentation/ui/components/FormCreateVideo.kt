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
import kotlinx.html.FormEncType
import kotlinx.html.script
import kotlinx.html.source
import kotlinx.html.unsafe
import kotlinx.html.video

fun FlowContent.formCreateVideo(video: VideoImpl? = null) {

    form(classes = "box", action = "/admin/video/create", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        input(type = InputType.hidden, name = "id") {
            value = video?.id?.toString() ?: "0"
        }

        field("Title", "title", video?.title)
        field("SEO Title", "seoTitle", video?.seoTitle)
        field("SEO Description", "seoDescription", video?.seoDescription)
        field("SEO Keywords", "seoKeywords", video?.seoKeywords)

        fileField("Video", "description")

        if(video != null) {
            video{
                height = 100.toString()
                autoPlay = true
                controls = true
                source {
                    src = "/admin/video/${video.id}"
                    +"Your browser does not support the video tag."
                }
            }
        }

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

        textareaField("Description", "", "description", video?.description, rows = 7)

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

        script {
            unsafe {
                +"""document.addEventListener('DOMContentLoaded', () => {
                        const imageInput = document.querySelector("#file input[type=file]");
                        imageInput.onchange = () => {
                            if (imageInput.files.length > 0) {
                                const fileName = document.querySelector("#file .file-name");
                                fileName.textContent = imageInput.files[0].name;
                            }
                        };
                    });
                """
            }
        }

    }

}