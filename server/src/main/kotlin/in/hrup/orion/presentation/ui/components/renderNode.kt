package `in`.hrup.orion.presentation.ui.components

import `in`.hrup.orion.domain.utils.FileNode
import kotlinx.html.UL
import kotlinx.html.li
import kotlinx.html.ul

fun UL.renderNode(node: FileNode) {
    li {
        +node.name
        if (node.isDirectory && node.children.isNotEmpty()) {
            ul {
                node.children.forEach {
                    renderNode(it)
                }
            }
        }
    }
}