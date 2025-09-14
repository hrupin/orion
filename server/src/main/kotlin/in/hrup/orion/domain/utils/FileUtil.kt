package `in`.hrup.orion.domain.utils

import java.io.File
import java.nio.file.*
import java.util.zip.*
import java.io.InputStream
import java.io.InputStreamReader

object FileUtil {

    fun directoryExists(directoryPath: String): Boolean {
        val directory = File(directoryPath)
        return directory.exists() && directory.isDirectory
    }

    fun fileExists(filePath: String): Boolean {
        val file = File(filePath)
        return file.exists() && file.isFile
    }

    fun getDirMain(): String{
        val mainPath: String = File(System.getProperty("user.dir")).absolutePath.toString()
        val dir = File("$mainPath/.orion")
        dir.mkdirs()
        println(mainPath)
        return dir.absolutePath
    }

    fun readDataJsonFile(): String {
        val inputStream: InputStream? = javaClass.getResourceAsStream("/data/user.json")
        if (inputStream != null) {
            val reader = InputStreamReader(inputStream)
            return reader.readText()
        } else {
            throw RuntimeException("File not found: user.json")
        }
    }

    fun readDataJsonFileDefaultSettings(): String {
        val inputStream: InputStream? = javaClass.getResourceAsStream("/data/settings.json")
        if (inputStream != null) {
            val reader = InputStreamReader(inputStream)
            return reader.readText()
        } else {
            throw RuntimeException("File not found: settings.json")
        }
    }

    fun zipDir(sourceDirPath: Path, zipFilePath: Path) {
        ZipOutputStream(Files.newOutputStream(zipFilePath)).use { zs ->
            Files.walk(sourceDirPath).filter { Files.isRegularFile(it) }.forEach { path ->
                val zipEntry = ZipEntry(sourceDirPath.relativize(path).toString().replace("\\", "/"))
                zs.putNextEntry(zipEntry)
                Files.copy(path, zs)
                zs.closeEntry()
            }
        }
    }

    fun unzip(zipFilePath: Path, targetDir: Path) {
        val rootDirs = mutableSetOf<String>()
        val entries = mutableListOf<ZipEntry>()
        ZipInputStream(Files.newInputStream(zipFilePath)).use { zis ->
            var entry = zis.nextEntry
            while (entry != null) {
                if (!entry.name.startsWith("__MACOSX") && entry.name.contains("/")) {
                    val root = entry.name.substringBefore("/")
                    rootDirs.add(root)
                }
                entries.add(entry)
                entry = zis.nextEntry
            }
        }
        val hasSingleRoot = rootDirs.size == 1
        ZipInputStream(Files.newInputStream(zipFilePath)).use { zis ->
            var entry = zis.nextEntry
            while (entry != null) {
                val originalName = entry.name
                if (originalName.startsWith("__") || originalName.contains("/.") || originalName.endsWith("/")) {
                    entry = zis.nextEntry
                    continue
                }
                val relativeName = if (hasSingleRoot) {
                    originalName.split("/").drop(1).joinToString("/")
                } else {
                    originalName
                }
                val outPath = targetDir.resolve(relativeName).normalize()
                if (!outPath.startsWith(targetDir)) {
                    throw SecurityException("Небезпечний шлях у ZIP: $relativeName")
                }
                Files.createDirectories(outPath.parent)
                Files.copy(zis, outPath, StandardCopyOption.REPLACE_EXISTING)
                zis.closeEntry()
                entry = zis.nextEntry
            }
        }
    }

    fun getDirectoryContents(path: String): FileNode {
        val file = File(path)
        if (!file.exists()) throw IllegalArgumentException("Path does not exist: $path")

        return if (file.isDirectory) {

            val children = file.listFiles()?.map {
                if (it.isDirectory) {
                    val subChildren = it.listFiles()?.map { sub ->
                        getDirectoryContents(sub.absolutePath)
                    } ?: emptyList()
                    FileNode(name = it.name, isDirectory = true, children = subChildren, path = it.path.replace(FileUtil.getDirMain(), ""))
                } else {
                    FileNode(name = it.name, isDirectory = false, path = it.path.replace(FileUtil.getDirMain(), ""))
                }
            } ?: emptyList()



            FileNode(name = file.name, isDirectory = true, children = children, path = file.path.replace(FileUtil.getDirMain(), ""))
        } else {
            FileNode(name = file.name, isDirectory = false, path = file.path.replace(FileUtil.getDirMain(), ""))
        }
    }

    val editableExtensions = setOf(
        "txt", "md", "json", "xml", "html", "js", "ts",
        "css", "scss", "sass", "less",
        "vue", "kt", "java", "csv"
    )

    fun isEditableFile(name: String): Boolean {
        val ext = name.substringAfterLast('.', "").lowercase()
        return ext in editableExtensions
    }

    suspend fun runShell(command: List<String>, directory: File): Boolean{
        val run = ProcessBuilder(command)
            .directory(directory)
            .redirectInput(ProcessBuilder.Redirect.INHERIT)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
        run.waitFor()
        return true
    }

}