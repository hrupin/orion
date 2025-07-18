package `in`.hrup.orion.presentation.ui.components

import `in`.hrup.orion.domain.utils.FileNode
import `in`.hrup.orion.domain.utils.FileUtil
import kotlinx.html.UL
import kotlinx.html.classes
import kotlinx.html.li
import kotlinx.html.span
import kotlinx.html.ul

fun UL.renderNode(node: FileNode) {
    li {
        if (node.isDirectory) {
            classes = setOf("folder")
            span {
                attributes["style"] = "cursor: pointer; user-select: none;"
                +node.name
            }
            if (node.children.isNotEmpty()) {
                ul {
                    node.children.forEach {
                        renderNode(it)
                    }
                }
            }
        } else {
            span {
                if(FileUtil.isEditableFile(node.path)) attributes["data-path"] =  node.path
                attributes["style"] = "cursor: pointer; user-select: none;"
                classes = setOf("file")
                +node.name
            }
        }
    }
}