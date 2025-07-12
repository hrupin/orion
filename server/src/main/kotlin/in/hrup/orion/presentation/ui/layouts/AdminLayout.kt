package `in`.hrup.orion.presentation.ui.layouts

import kotlinx.html.HTML
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.hr
import kotlinx.html.img
import kotlinx.html.span
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.nav
import kotlinx.html.script
import kotlinx.html.section
import kotlinx.html.title

fun HTML.adminLayout(content: SECTION.() -> Unit) {
    head {
        title("Login")
        meta(charset = "UTF-8")
        link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bulma@1.0.4/css/bulma.min.css")
        link(rel = "stylesheet", href = "/static/css/style.css")
        link(rel = "stylesheet", href = "/static/css/admin.css")
        script {
            src = "https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"
            attributes["defer"] = ""
        }
    }
    body {
        nav("navbar") {
            attributes["aria-label"] = "main navigation"

            div("navbar-brand") {
                a(classes = "navbar-item", href = "https://bulma.io") {
                    img { src = "/static/img/logo_full.svg" }
                }

                a(classes = "navbar-burger") {
                    attributes["role"] = "button"
                    attributes["aria-label"] = "menu"
                    attributes["aria-expanded"] = "false"
                    attributes["data-target"] = "navbarBasicExample"

                    repeat(4) {
                        span {
                            attributes["aria-hidden"] = "true"
                        }
                    }
                }
            }

            div("navbar-menu") {
                div("navbar-start") {
                    a(classes = "navbar-item") {
                        href = "view"
                        +"Home"
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

        main {
            section {
                content()
            }
        }
    }
}