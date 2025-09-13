package `in`.hrup.orion.presentation.ui.screens.site

import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import `in`.hrup.orion.data.modelsImpl.CategoryImpl


fun SECTION.indexCategoriesScreen(categories: List<CategoryImpl> = listOf(), url: String) {


    div{
        h1(classes = "posts_header"){
            +"Categories"
        }
        table(classes = "table") {
            id = "posts"
            thead {
                tr {
                    th {
                        +"Id"
                    }
                    th {
                        +"Назва"
                    }
                    th {
                        +"Аліас"
                    }
                    th {
                        +"Дії"
                    }
                }
            }
            tbody {

                categories.forEach {
                    tr {
                        th {
                            +it.id.toString()
                        }
                        td {
                            +it.name
                        }
                        td {
                            +it.alias
                        }
                        td {
                            a(classes = "button postActions") {
                                href = if (url.contains("?")) {
                                    "$url&action=remove&id=${it.id}"
                                } else {
                                    "$url?action=remove&id=${it.id}"
                                }
                                +"видалити"
                            }
                            a(classes = "button postActions") {
                                href = if (url.contains("?")) {
                                    "$url&action=edit&id=${it.id}"
                                } else {
                                    "$url?action=edit&id=${it.id}"
                                }
                                +"редагувати"
                            }
                        }
                    }
                }
            }
        }
    }

}