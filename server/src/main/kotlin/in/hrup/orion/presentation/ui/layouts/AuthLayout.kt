package `in`.hrup.orion.presentation.ui.layouts

import kotlinx.html.HTML
import kotlinx.html.SECTION
import kotlinx.html.*

fun HTML.authLayout(content: SECTION.() -> Unit) {
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
        main {
            section(classes = "main") {
                content()
            }
        }
    }
}