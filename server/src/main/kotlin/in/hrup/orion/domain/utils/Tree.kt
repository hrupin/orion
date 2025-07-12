package `in`.hrup.orion.domain.utils

import java.io.File

data class FileNode(
    val name: String,
    val isDirectory: Boolean,
    val children: List<FileNode> = emptyList()
)

object Tree {

    fun build(file: File): Map<String, Any> {
        val children = file.listFiles()?.map { build(it) } ?: emptyList()
        return mapOf(
            "text" to file.name,
            "children" to children,
            "icon" to if (file.isDirectory) "tree-folder" else "tree-file"
        )
    }


}