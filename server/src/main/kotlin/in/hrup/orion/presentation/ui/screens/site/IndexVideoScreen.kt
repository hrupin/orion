package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.domain.dto.PostsDTO
import `in`.hrup.orion.domain.dto.VideosDTO
import `in`.hrup.orion.domain.utils.StringUtil
import `in`.hrup.orion.presentation.ui.components.pagination
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.b
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import kotlinx.html.ul

fun SECTION.indexVideoScreen(videos: VideosDTO, url: String) {

    div{
        h1(classes = "posts_header"){
            +"Posts"
        }
        table(classes = "table") {
            id = "posts"
            thead {
                tr {
                    th {
                        +"Id"
                    }
                    th {
                        +"Заголовок"
                    }
                    th {
                        +"Опис"
                    }
                    th {
                        +"Статуси"
                    }
                    th {
                        +"Дії"
                    }
                }
            }
            tbody {

                videos.videos.forEach {
                    tr {
                        th {
                            +it.id.toString()
                        }
                        td {
                            +it.title
                        }
                        td {
                            +it.description
                        }
                        td {
                            ul {
                                li {
                                    b {
                                        +"Опубліковано: "
                                    }
                                    +StringUtil.formatTimestampToUkrainianDate(timestampMillis = it.publishedAt)
                                }
                                li {
                                    b {
                                        +"Останнє оновлення: "
                                    }
                                    +StringUtil.formatTimestampToUkrainianDate(timestampMillis = it.updatedAt)
                                }
                                li {
                                    b {
                                        +"Дата написання: "
                                    }
                                    +StringUtil.formatTimestampToUkrainianDate(timestampMillis = it.createdAt)
                                }
                            }
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
                            if(it.published){
                                a(classes = "button postActions") {
                                    href = if (url.contains("?")) {
                                        "$url&action=unpublish&id=${it.id}"
                                    } else {
                                        "$url?action=unpublish&id=${it.id}"
                                    }
                                    +"Зняти з публікації"
                                }
                            }
                            else{
                                a(classes = "button postActions") {href = if (url.contains("?")) {
                                    "$url&action=publish&id=${it.id}"
                                } else {
                                    "$url?action=publish&id=${it.id}"
                                }
                                    +"Опублікувати"
                                }
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
        pagination(
            currentPage = videos.currentPage,
            totalPages = videos.totalPages
        )
    }
}