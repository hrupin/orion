package `in`.hrup.orion.presentation.ui.layouts

import `in`.hrup.orion.presentation.ui.components.notificationBlock
import kotlinx.html.FormEncType
import kotlinx.html.FormMethod
import kotlinx.html.HTML
import kotlinx.html.InputType
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.head
import kotlinx.html.hr
import kotlinx.html.i
import kotlinx.html.id
import kotlinx.html.img
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.span
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.nav
import kotlinx.html.script
import kotlinx.html.section
import kotlinx.html.title

fun HTML.adminLayout(typeNotifications: String = "", messageNotification: String = "", content: SECTION.() -> Unit) {
    head {
        title("Login")
        meta(charset = "UTF-8")
        link(rel = "stylesheet", href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css")
        link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css")
        link(rel = "stylesheet", href = "/static/css/style.css")
        link(rel = "stylesheet", href = "/static/css/admin.css")
        script {
            src = "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"
            attributes["defer"] = ""
        }
        script {
            src = "/static/js/admin.js"
            attributes["defer"] = ""
        }
    }
    body {
        nav("navbar") {
            attributes["aria-label"] = "main navigation"

            div("navbar-brand") {
                a(classes = "navbar-item", href = "/dashboard") {
                    img { src = "/static/img/logo_full.svg" }
                }

                a(classes = "navbar-burger") {
                    attributes["role"] = "button"
                    attributes["aria-label"] = "menu"
                    attributes["aria-expanded"] = "false"
                    attributes["data-target"] = "navbarAdmin"

                    repeat(4) {
                        span {
                            attributes["aria-hidden"] = "true"
                        }
                    }
                }
            }

            div(classes = "navbar-menu") {
                id = "navbarAdmin"
                div("navbar-start") {

                    a(classes = "navbar-item") {
                        href = "/admin/dashboard"
                        +"Home"
                    }

                    div(classes = "navbar-item has-dropdown is-hoverable") {
                        a(classes = "navbar-link"){
                            href = "/admin/posts/index"
                            +"Новини"
                        }
                        div(classes = "navbar-dropdown") {
                            a(classes = "navbar-item"){
                                href = "/admin/posts/create"
                                +" + Додати"
                            }
                            a(classes = "navbar-item js-modal-trigger"){
                                href = "/admin/posts/index"
                                +"Cписок"
                            }
                            hr(classes = "navbar-divider"){}
                            a(classes = "navbar-item"){
                                href = "/admin/category/create"
                                +" + Додати категорію"
                            }
                            a(classes = "navbar-item js-modal-trigger"){
                                href = "/admin/posts/index"
                                +"Категорії"
                            }
                        }
                    }

                    div(classes = "navbar-item has-dropdown is-hoverable") {
                        a(classes = "navbar-link"){
                            href = "/admin/video/index"
                            +"Відео"
                        }
                        div(classes = "navbar-dropdown") {
                            a(classes = "navbar-item"){
                                href = "/admin/video/create"
                                +" + Додати"
                            }
                            a(classes = "navbar-item js-modal-trigger"){
                                href = "/admin/video/index"
                                +"Cписок"
                            }
                        }
                    }

                    div(classes = "navbar-item has-dropdown is-hoverable") {
                        a(classes = "navbar-link"){
                            +"Сайт"
                        }
                        div(classes = "navbar-dropdown") {
                            a(classes = "navbar-item"){
                                href = "/admin/site/download"
                                +"Експорт"
                            }
                            a(classes = "navbar-item js-modal-trigger"){
                                attributes["data-target"] = "modalSiteImport"
                                +"Імпорт"
                            }
                            a(classes = "navbar-item"){
                                href = "/admin/site/edit"
                                +"Редагувати"
                            }
                            a(classes = "navbar-item"){
                                href = "/admin/site/build"
                                +"Скомпілювати"
                            }
                        }
                    }
                }

                div("navbar-end") {
                    div("navbar-item") {
                        div("buttons") {
                            a(classes = "button is-light") {
                                +"Logout"
                            }
                        }
                    }
                }
            }
        }
        if(typeNotifications.isNotEmpty()){
            notificationBlock(type = typeNotifications, message = messageNotification)
        }

        main {
            section(classes = "section") {
                content()
                modalLayout(
                    idModal = "modalSiteImport",
                    idForm = "uploadForm"
                ){
                    form(
                        action = "/admin/site",
                        encType = FormEncType.multipartFormData,
                        method = FormMethod.post
                    ) {
                        id = "uploadForm"
                        div(classes = "file has-name is-boxed") {
                            id = "uploadDump"
                            label(classes = "file-label") {
                                input(type = InputType.file, classes = "file-input", name = "DUMP") {}
                                span(classes = "file-cta") {
                                    span(classes = "file-icon") {
                                        i(classes = "fas fa-upload"){}
                                    }
                                    span(classes = "file-label") {
                                        +"Виберіть файл…"
                                    }
                                }
                                span(classes = "file-name") { +"Виберіть файл…" }
                            }
                        }

                    }
                }
            }
        }

    }
}
