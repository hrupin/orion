package `in`.hrup.orion.presentation.ui.components

import kotlinx.html.FlowContent
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.onClick

object NotificationType{
    val PRIMARY = "is-primary"
    val LINK = "is-link"
    val INFO = "is-info"
    val SUCCESS = "is-success"
    val WARNING = "is-warning"
    val DANGER = "is-danger"
}

fun FlowContent.notificationBlock(type: String, message: String) {
    div("notification is-light $type") {
        attributes["style"] = "position: fixed; top: 20px; left: 50%; transform: translateX(-50%); z-index: 1000;"
        button(classes = "delete") {
            onClick = "this.parentElement.style.display='none'"
        }
        +message
    }
}