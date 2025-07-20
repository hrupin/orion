package `in`.hrup.orion.presentation.routes

import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.get
import io.ktor.server.sessions.set
import io.ktor.server.routing.routing
import io.ktor.server.html.respondHtml
import io.ktor.server.sessions.sessions
import io.ktor.server.application.Application
import io.ktor.server.response.respondRedirect
import io.ktor.server.request.receiveParameters
import `in`.hrup.orion.domain.usecases.auth.LoginUseCase
import `in`.hrup.orion.presentation.ui.layouts.authLayout
import `in`.hrup.orion.presentation.ui.screens.authScreen
import `in`.hrup.orion.domain.usecases.auth.GetUserSessionByUsernameUseCase
import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.domain.utils.Tree
import `in`.hrup.orion.presentation.ui.components.NotificationType
import `in`.hrup.orion.presentation.ui.components.formCreatePost
import `in`.hrup.orion.presentation.ui.components.notificationBlock
import `in`.hrup.orion.presentation.ui.layouts.adminLayout
import `in`.hrup.orion.presentation.ui.screens.site.createPostScreen
import `in`.hrup.orion.presentation.ui.screens.site.createVideoScreen
import `in`.hrup.orion.presentation.ui.screens.site.editScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexPostScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexVideoScreen
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.http.content.streamProvider
import io.ktor.server.http.content.file
import io.ktor.server.request.receive
import io.ktor.server.request.receiveMultipart
import io.ktor.server.response.respondFile
import io.ktor.server.response.respondText
import io.ktor.util.cio.writeChannel
import io.ktor.utils.io.copyTo
import java.io.File
import java.io.FileOutputStream
import io.ktor.utils.io.copyTo
import io.ktor.utils.io.jvm.javaio.copyTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

fun Application.adminRoutes() {

    routing {

        get("auth/login"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        get("auth"){
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        post("/auth") {
            var isSuccess = false
            val params = call.receiveParameters()
            val login = params["email"] ?: ""
            val password = params["password"] ?: ""
            isSuccess = LoginUseCase.execute(login = login, password = password)
            if (isSuccess) {
                val user = GetUserSessionByUsernameUseCase.execute(username = login)
                if(user != null) {
                    call.sessions.set(user)
                }
                call.respondRedirect("/dashboard")
            } else {
                call.respondHtml {
                    authLayout {
                        authScreen(isError = "Помилка авторизації!")
                    }
                }
            }
        }

        get("dashboard"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                adminLayout {
                    indexScreen()
                }
            }
        }

        get("site"){
            call.respondHtml {
                adminLayout {
                    indexScreen()
                }
            }
        }

        post("site"){
            val uploadTempZipPath = File.createTempFile("vue-import-", ".zip")
            val vueExtractDir = File("${FileUtil.getDirMain()}/site")
            val multipart = call.receiveMultipart()
            var zipFileReceived = false
            multipart.forEachPart { part ->
                if (part is PartData.FileItem && part.originalFileName?.endsWith(".zip") == true) {
                    val channel = part.provider()
                    uploadTempZipPath.outputStream().use { output ->
                        channel.copyTo(output)
                    }
                    zipFileReceived = true
                }
                part.dispose()
            }
            if (!zipFileReceived) {
                call.respondHtml {
                    adminLayout(
                        typeNotifications = NotificationType.DANGER,
                        messageNotification = "ZIP-файл не отримано"
                    ) {
                        indexScreen()
                    }
                }
                return@post
            }
            if (vueExtractDir.exists()) vueExtractDir.deleteRecursively()
            vueExtractDir.mkdirs()
            try {
                FileUtil.unzip(uploadTempZipPath.toPath(), vueExtractDir.toPath())
            }
            catch (e: Exception){
                call.respondHtml {
                    adminLayout(
                        typeNotifications = NotificationType.DANGER,
                        messageNotification = e.message.toString()
                    ) {
                        indexScreen()
                    }
                }
                return@post
            }
            call.respondHtml {
                adminLayout(
                    typeNotifications = NotificationType.SUCCESS,
                    messageNotification = "Проєкт Vue успішно імпортовано"
                ) {
                    indexScreen()
                }
            }
        }

        get("/site/download") {
            val vueDir = File("${FileUtil.getDirMain()}/site")
            if (!vueDir.exists()) {
                call.respondHtml {
                    adminLayout(
                        typeNotifications = NotificationType.DANGER,
                        messageNotification = "Vue проект не найден"
                    ) {
                        indexScreen()
                    }
                }
            }
            val zipFile = File.createTempFile("vue-export-", ".zip")
            FileUtil.zipDir(vueDir.toPath(), zipFile.toPath())
            call.respondFile(zipFile)
        }

        get("site/tree"){
            val rootDir = File("/путь/к/директории")
            val tree = Tree.build(file = rootDir)
            call.respondHtml {
                adminLayout {
                    authScreen()
                }
            }
        }

        get("site/edit"){
            val rootDir = File("/путь/к/директории")
            val tree = Tree.build(file = rootDir)
            call.respondHtml {
                adminLayout {
                    editScreen()
                }
            }
        }

        get("/site/file") {
            val path = call.request.queryParameters["path"]
            if (path == null) {
                call.respondText("Missing path parameter", status = HttpStatusCode.BadRequest)
                return@get
            }
            val baseDir = File(FileUtil.getDirMain()).canonicalFile
            val requestedFile = File(baseDir, path).canonicalFile
            if (!requestedFile.startsWith(baseDir)) {
                call.respondText("Access denied", status = HttpStatusCode.Forbidden)
                return@get
            }
            if (!requestedFile.exists() || !requestedFile.isFile) {
                call.respondText("File not found", status = HttpStatusCode.NotFound)
                return@get
            }
            call.respondFile(requestedFile)
        }

        post("/site/save") {
            val data = call.receive<Map<String, String>>()
            val path = data["path"]
            val content = data["content"]
            if (path == null || content == null) {
                call.respondText("Missing path or content", status = HttpStatusCode.BadRequest)
                return@post
            }
            val baseDir = File(FileUtil.getDirMain()).canonicalFile
            val targetFile = File(baseDir, path).canonicalFile
            if (!targetFile.startsWith(baseDir)) {
                call.respondText("Access denied", status = HttpStatusCode.Forbidden)
                return@post
            }
            try {
                targetFile.writeText(content)
                call.respondText("Файл успешно сохранён")
            } catch (e: Exception) {
                call.respondText("Ошибка при сохранении: ${e.message}", status = HttpStatusCode.InternalServerError)
            }
        }

        get("site/build"){
            FileUtil.runShell(listOf("C:\\Program Files\\nodejs\\npm.cmd", "install"), File("${FileUtil.getDirMain()}/site"))
            FileUtil.runShell(listOf("C:\\Program Files\\nodejs\\npm.cmd", "run", "build"), File("${FileUtil.getDirMain()}/site"))

            call.respondHtml {
                adminLayout {
                    editScreen()
                }
            }
        }

        get("posts/index"){
            call.respondHtml {
                adminLayout {
                    indexPostScreen()
                }
            }
        }

        get("posts/create"){
            call.respondHtml {
                adminLayout {
                    createPostScreen()
                }
            }
        }

        get("videos/index"){
            call.respondHtml {
                adminLayout {
                    indexVideoScreen()
                }
            }
        }

        get("videos/create"){
            call.respondHtml {
                adminLayout {
                    createVideoScreen()
                }
            }
        }

    }

}