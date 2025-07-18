package `in`.hrup.orion.presentation.ui.screens.site

import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.presentation.ui.components.renderTree
import kotlinx.html.InputType
import kotlinx.html.SECTION
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.textArea

fun SECTION.editScreen() {
    val project = FileUtil.getDirectoryContents("${FileUtil.getDirMain()}/site")
    div(classes = "columns edit-columns") {
        div(classes = "column") {
            renderTree(node = project)
        }
        div(classes = "column") {
            textArea(classes = "edit-textarea textarea") {
                id = "fileContentArea"
            }
        }
    }
    div{
        input {
            type = InputType.hidden
            id = "filePath"
        }
        button(classes = "button is-medium is-fullwidth") {
            id = "saveFileButton"
            +"SAVE"
        }

    }
}