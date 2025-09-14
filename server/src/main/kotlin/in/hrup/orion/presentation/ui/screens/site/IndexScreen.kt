package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import `in`.hrup.orion.domain.dto.QuestionnaireDTO
import `in`.hrup.orion.domain.models.Questionnaire
import `in`.hrup.orion.domain.utils.StringUtil
import `in`.hrup.orion.presentation.ui.components.pagination
import kotlinx.html.SECTION
import kotlinx.html.a
import kotlinx.html.b
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.figure
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import kotlinx.html.ul


fun SECTION.indexScreen(questionnaires: QuestionnaireDTO, url: String) {
    div{
        h1(classes = "posts_header"){
            +"Заявкі"
        }
        table(classes = "table") {
            id = "posts"
            thead {
                tr {
                    th {
                        +"Id"
                    }
                    th {
                        +"ПІБ"
                    }
                    th {
                        +"Контакти"
                    }
                    th {
                        +"Коментар"
                    }
                    th {
                        +"Дії"
                    }
                }
            }
            tbody {

                questionnaires.  list.forEach {
                    tr {
                        th {
                            +it.id.toString()
                        }
                        td {
                            +"${it.name} ${it.lastName}"
                        }
                        td {
                            ul{
                                li{
                                    p{
                                        +"Phone: ${it.phone}"
                                    }
                                    p{
                                        +"Email: ${it.email}"
                                    }
                                    p{
                                        +"Рід військ: ${it.militaryBranch}"
                                    }
                                }
                            }
                        }
                        td {
                            +it.comment
                        }
                        td {
                            a(classes = "button postActions") {
                                href = if (url.contains("?")) {
                                    "$url&action=remove&id=${it.id}"
                                } else {
                                    "$url?action=remove&id=${it.id}"
                                }
                                +"Видалити"
                            }
                            if(it.status == 0){
                                a(classes = "button postActions") {
                                    href = if (url.contains("?")) {
                                        "$url&action=process&id=${it.id}"
                                    } else {
                                        "$url?action=process&id=${it.id}"
                                    }
                                    +"Обробити заявку"
                                }
                            }
                            else{
                                p(classes = "button postActions is-light") {
                                    +"Оброблено"
                                }
                            }
                        }
                    }
                }
            }
        }
        pagination(
            currentPage = questionnaires.currentPage,
            totalPages = questionnaires.totalPages
        )
    }
}