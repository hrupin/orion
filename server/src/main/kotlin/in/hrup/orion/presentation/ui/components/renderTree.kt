package `in`.hrup.orion.presentation.ui.components

import `in`.hrup.orion.domain.utils.FileNode
import kotlinx.html.BODY
import kotlinx.html.DIV
import kotlinx.html.ul

fun DIV.renderTree(node: FileNode) {
    ul(classes = "tree") {
        renderNode(node)
    }
}