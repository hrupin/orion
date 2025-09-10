package `in`.hrup.orion.presentation.models

import io.ktor.http.content.PartData
import kotlinx.coroutines.runBlocking
import io.ktor.utils.io.cancel
import java.io.File
import io.ktor.utils.io.jvm.javaio.copyTo
import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.domain.utils.StringUtil

object Uploader {
    // "jpg", "jpeg", "png"
    fun file(part: PartData, dir: String, allowedExt: List<String>): String{
        var res = ""
        if (part is PartData.FileItem) {
            val fileName = part.originalFileName ?: "unnamed"
            val ext = File(fileName).extension.lowercase()
            if (ext in allowedExt) {
                val uploadDir = File("${FileUtil.getDirMain()}/$dir")
                if (!uploadDir.exists()) uploadDir.mkdirs()
                val fName = "${StringUtil.getUUID()}.$ext"
                val file = File(uploadDir, fName)
                val inputStream = part.provider()
                file.outputStream().use { output ->
                    runBlocking {
                        inputStream.copyTo(output)
                        inputStream.cancel()
                    }
                }
                res =  fName
            }
        }
        part.dispose()
        return res
    }

}