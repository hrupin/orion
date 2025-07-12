package `in`.hrup.orion.presentation.ui.components

import `in`.hrup.orion.domain.utils.FileNode
import kotlinx.html.BODY
import kotlinx.html.ul

fun BODY.renderTree(node: FileNode) {
    ul {
        renderNode(node)
    }
}