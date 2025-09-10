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
import kotlinx.html.br
import kotlinx.html.hidden
import kotlinx.html.id
import kotlinx.html.img
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.textArea
import kotlinx.html.unsafe

fun FlowContent.formCreatePost(post: PostImpl? = null) {

    form(classes = "box", action = "/posts/create", method = FormMethod.post, encType = FormEncType.multipartFormData) {

        link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.snow.css")

        input(type = InputType.hidden, name = "id") {
            value = post?.id?.toString() ?: "0"
        }

        field("Title", "title", post?.title)
        field("Tags", "tags", post?.tags)
        field("SEO Title", "seoTitle", post?.seoTitle)
        field("SEO Description", "seoDescription", post?.seoDescription)
        field("SEO Keywords", "seoKeywords", post?.seoKeywords)
        selectField(
            labelText = "Category",
            options = mapOf(
                "apple" to "Яблоко",
                "banana" to "Банан",
                "orange" to "Апельсин"
            )
        )
        field("Category", "category", post?.category)

        fileField("Image", "description")

        if(post?.image != null && post.image.isNotEmpty() == true) {
            img(classes = "img_preview"){
                src = "https://99evro.ru/wp-content/uploads/2025/03/spiaggia-bellissima-puglia-beach-photos.webp"
            }
        }

        textareaField("Description", "", "description", post?.description, rows = 7)


        textArea(classes = "textarea"){
            id = "textarea_content"
            attributes["name"] = "content"
        }

        //textareaField("Content", "editor", "content", post?.content, rows = 15)

        div{
            id = "editor"
        }
        script {
            src = "https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.js"
            attributes["defer"] = ""
        }

        script {
            unsafe {
                +"""document.addEventListener('DOMContentLoaded', () => {
                        const toolbarOptions = [
                          ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                          ['blockquote', 'code-block'],
                          ['link', 'formula'],
                        
                          [{ 'header': 1 }, { 'header': 2 }],               // custom button values
                          [{ 'list': 'ordered'}, { 'list': 'bullet' }, { 'list': 'check' }],
                          [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
                          [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
                          [{ 'direction': 'rtl' }],                         // text direction
                        
                          [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
                          [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
                        
                          [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
                          [{ 'font': [] }],
                          [{ 'align': [] }],
                        
                          ['clean']                                         // remove formatting button
                        ];
                        const quill = new Quill('#editor', {
                            theme: 'snow',
                            modules: {
                                toolbar: toolbarOptions
                            }
                        });
                        quill.root.innerHTML = '${post?.content}'
                        const textarea_content = document.getElementById('textarea_content');
                        quill.on('text-change', () => {
                            textarea_content.value = quill.root.innerHTML;
                        });
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

        br{}

        div("field") {
            div("control") {
                button(classes = "button is-primary", type = ButtonType.submit) {
                    +"Save"
                }
            }
        }

    }

}