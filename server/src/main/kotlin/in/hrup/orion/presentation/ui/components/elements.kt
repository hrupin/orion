package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.FlowContent
import kotlinx.html.InputType
import kotlinx.html.a
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.i
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.label
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.option
import kotlinx.html.p
import kotlinx.html.select
import kotlinx.html.span
import kotlinx.html.textArea
import kotlinx.html.ul

fun FlowContent.field(labelText: String, name: String, value: String? = null, idField: String = "") {
    div("field is-horizontal") {
        div(classes = "field-label is-normal"){
            label("label mar0") { +labelText }
        }
        div(classes = "field-body") {
            div(classes = "field") {
                p("control") {
                    input(classes = "input", type = InputType.text, name = name) {
                        id = idField
                        value?.let { this.value = it }
                    }
                }
            }
        }
    }
}

fun FlowContent.textareaField(labelText: String, ids: String = "", name: String, value: String? = null, rows: Int? = 3) {
    div("field") {
        textArea(classes = "textarea"){
            id = ids
            attributes["name"] = name
            attributes["placeholder"] = labelText
            attributes["rows"] = rows.toString()
            +if(value != null) "$value%" else ""
        }
    }
}

fun FlowContent.staticField(labelText: String, value: String) {
    div("field") {
        label("label") { +labelText }
        div("control") {
            p("input is-static") {
                +value
            }
        }
    }
}

fun FlowContent.fileField(labelText: String, name: String) {
    div("field is-horizontal") {
        div(classes = "field-label is-normal"){
            label("label mar0") { +labelText }
        }
        div(classes = "field-body") {
            div(classes = "field") {
                div("file has-name") {
                    id = "file"
                    label("file-label") {
                        input(type = InputType.file, name = name) {
                            classes = setOf("file-input")
                        }
                        span("file-cta") {
                            span("file-icon") {
                                i("fas fa-upload") {}
                            }
                            span("file-label") {
                                +"Choose a file…"
                            }
                        }
                        span("file-name") {
                            +"Choose a file…"
                        }
                    }
                }
            }
        }
    }
}

fun FlowContent.selectField(labelText: String = "", options: Map<String, String> = mapOf()){

    div("field is-horizontal") {
        div(classes = "field-label is-normal"){
            label("label mar0") { +labelText }
        }
        div(classes = "field-body") {
            div(classes = "select") {
                select {
                    name = "choice"
                    options.forEach { (valueOption, label) ->
                        option{
                            value = valueOption
                            +label
                        }
                    }
                }
            }
        }
    }



}

fun FlowContent.pagination(
    currentPage: Int,
    totalPages: Int,
    baseUrl: (Int) -> String = { "?page=$it" }, // Функция для генерации URL
    visiblePageRange: Int = 2 // Сколько страниц показывать слева и справа от текущей
) {
    nav(classes = "pagination is-centered") {
        attributes["role"] = "navigation"
        attributes["aria-label"] = "pagination"

        // Previous button
        a(classes = "pagination-previous") {
            href = if (currentPage > 1) baseUrl(currentPage - 1) else "#"
            if (currentPage == 1) attributes["disabled"] = "true"
            +"Попередня"
        }

        // Next button
        a(classes = "pagination-next") {
            href = if (currentPage < totalPages) baseUrl(currentPage + 1) else "#"
            if (currentPage == totalPages) attributes["disabled"] = "true"
            +"Наступна"
        }

        ul(classes = "pagination-list") {
            // Первая страница
            if (currentPage > visiblePageRange + 1) {
                li {
                    a(classes = "pagination-link") {
                        attributes["aria-label"] = "Перейти на сторінку 1"
                        href = baseUrl(1)
                        +"1"
                    }
                }
                li {
                    span(classes = "pagination-ellipsis") { +"..." }
                }
            }

            // Основной диапазон
            val start = maxOf(1, currentPage - visiblePageRange)
            val end = minOf(totalPages, currentPage + visiblePageRange)

            for (page in start..end) {
                li {
                    a(classes = "pagination-link" + if (page == currentPage) " is-current" else "") {
                        attributes["aria-label"] = "Перейти на сторінку $page"
                        href = baseUrl(page)
                        +page.toString()
                    }
                }
            }

            // Последняя страница
            if (currentPage < totalPages - visiblePageRange) {
                li {
                    span(classes = "pagination-ellipsis") { +"..." }
                }
                li {
                    a(classes = "pagination-link") {
                        attributes["aria-label"] = "Перейти на сторінку $totalPages"
                        href = baseUrl(totalPages)
                        +totalPages.toString()
                    }
                }
            }
        }
    }
}

//
//fun FlowContent.pagination(){
//
//    nav(classes = "pagination is-centered"){
//        attributes["role"] = "navigation"
//        attributes["aria-label"] = "pagination"
//        //attributes[""] = ""
//        a(classes = "pagination-previous") {
//            href = "#"
//            +"Previous"
//        }
//        a(classes = "pagination-next") {
//            href = "#"
//            +"Next page"
//        }
//
//        ul(classes = "pagination-list") {
//            li{
//                a(classes = "pagination-link") {
//                    attributes["aria-label"] = "Goto page 1"
//                    href = "#"
//                    +"1"
//                }
//            }
//            li{
//                span(classes = "pagination-ellipsis") {
//                    +"..."
//                }
//            }
//            li{
//                a(classes = "pagination-link") {
//                    attributes["aria-label"] = "Goto page 30"
//                    href = "#"
//                    +"30"
//                }
//            }
//            li{
//                a(classes = "pagination-link is-current") {
//                    attributes["aria-label"] = "Goto page 31"
//                    href = "#"
//                    +"31"
//                }
//            }
//            li{
//                a(classes = "pagination-link") {
//                    attributes["aria-label"] = "Goto page 32"
//                    href = "#"
//                    +"32"
//                }
//            }
//            li{
//                span(classes = "pagination-ellipsis") {
//                    +"..."
//                }
//            }
//
//            li{
//                a(classes = "pagination-link") {
//                    attributes["aria-label"] = "Goto page 86"
//                    href = "#"
//                    +"86"
//                }
//            }
//        }
//    }
//}