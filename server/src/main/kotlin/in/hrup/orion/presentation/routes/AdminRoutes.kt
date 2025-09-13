package `in`.hrup.orion.presentation.routes

import `in`.hrup.orion.Config
import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.modelsImpl.PostImpl
import `in`.hrup.orion.data.modelsImpl.VideoImpl
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
import `in`.hrup.orion.domain.usecases.category.AddOrUpdateCategoryUseCase
import `in`.hrup.orion.domain.usecases.category.CreateCategoryUseCase
import `in`.hrup.orion.domain.usecases.category.GetCategoriesUseCase
import `in`.hrup.orion.domain.usecases.category.GetCategoryByIdUseCase
import `in`.hrup.orion.domain.usecases.category.RemoveCategoryByIdUseCase
import `in`.hrup.orion.domain.usecases.posts.AddOrUpdatePostUseCase
import `in`.hrup.orion.domain.usecases.posts.CreatePostUseCase
import `in`.hrup.orion.domain.usecases.posts.FetchPagedPostsUseCase
import `in`.hrup.orion.domain.usecases.posts.GetPostByIdUseCase
import `in`.hrup.orion.domain.usecases.posts.PublishUnpublishPostUseCase
import `in`.hrup.orion.domain.usecases.posts.RemovePostByIdUseCase
import `in`.hrup.orion.domain.usecases.videos.AddOrUpdateVideoUseCase
import `in`.hrup.orion.domain.usecases.videos.CreateVideoUseCase
import `in`.hrup.orion.domain.usecases.videos.FetchPagedVideosUseCase
import `in`.hrup.orion.domain.usecases.videos.GetVideoByIdUseCase
import `in`.hrup.orion.domain.usecases.videos.PublishUnpublishVideoUseCase
import `in`.hrup.orion.domain.usecases.videos.RemoveVideoByIdUseCase
import `in`.hrup.orion.domain.utils.FileUtil
import `in`.hrup.orion.domain.utils.Tree
import `in`.hrup.orion.presentation.controllers.CategoriesController
import `in`.hrup.orion.presentation.controllers.PostsController
import `in`.hrup.orion.presentation.controllers.VideosController
import `in`.hrup.orion.presentation.ui.components.NotificationType
import `in`.hrup.orion.presentation.ui.layouts.adminLayout
import `in`.hrup.orion.presentation.ui.screens.site.createCategoryScreen
import `in`.hrup.orion.presentation.ui.screens.site.createPostScreen
import `in`.hrup.orion.presentation.ui.screens.site.createVideoScreen
import `in`.hrup.orion.presentation.ui.screens.site.editScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexCategoriesScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexPostScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexScreen
import `in`.hrup.orion.presentation.ui.screens.site.indexVideoScreen
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.forEachPart
import io.ktor.server.request.path
//import io.ktor.server.request.path
import io.ktor.server.request.receive
import io.ktor.server.request.receiveMultipart
import io.ktor.server.request.uri
import io.ktor.server.response.respond
import io.ktor.server.response.respondFile
import io.ktor.server.response.respondText
import java.io.File
import io.ktor.utils.io.jvm.javaio.copyTo
import java.lang.Exception

fun Application.adminRoutes() {

    routing {

        get("/admin/auth/login"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        get("/admin"){
            call.respondHtml {
                authLayout {
                    authScreen()
                }
            }
        }

        post("/admin/auth") {
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
                call.respondRedirect("/admin/dashboard")
            } else {
                call.respondHtml {
                    authLayout {
                        authScreen(isError = "Помилка авторизації!")
                    }
                }
            }
        }

        get("/admin/dashboard"){
            println("SESSION => ${call.sessions.get<UserSession>()}")
            call.respondHtml {
                adminLayout {
                    indexScreen()
                }
            }
        }

        post("/admin/site"){
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

        get("/admin/site/download") {
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

        get("/admin/site/tree"){
            val rootDir = File("/путь/к/директории")
            val tree = Tree.build(file = rootDir)
            call.respondHtml {
                adminLayout {
                    authScreen()
                }
            }
        }

        get("/admin/site/edit"){
            val rootDir = File("/путь/к/директории")
            val tree = Tree.build(file = rootDir)
            call.respondHtml {
                adminLayout {
                    editScreen()
                }
            }
        }

        get("/admin/site/file") {
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

        post("/admin/site/save") {
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

        get("/admin/site/build"){
            //FileUtil.runShell(listOf("C:\\Program Files\\nodejs\\npm.cmd", "install"), File("${FileUtil.getDirMain()}/site"))
            //FileUtil.runShell(listOf("C:\\Program Files\\nodejs\\npm.cmd", "run", "build"), File("${FileUtil.getDirMain()}/site"))

            FileUtil.runShell(listOf("npm", "install"), File("${FileUtil.getDirMain()}/site"))
            FileUtil.runShell(listOf("npm", "run", "build"), File("${FileUtil.getDirMain()}/site"))

            call.respondHtml {
                adminLayout {
                    editScreen()
                }
            }
        }

        get("/admin/posts/index"){
            var pathOnly = call.request.path()
            val currentUrl = call.request.uri
            val action = call.request.queryParameters["action"].toString()
            val page = call.request.queryParameters["page"]?.toIntOrNull() ?: 1
            if(page != null){
                pathOnly = "${pathOnly}?page=${page}"
            }
            println("URL -> ${currentUrl} = ${action}")
            if(action != null){
                val id = call.request.queryParameters["id"]?.toLongOrNull()
                if (id != null) {
                    when (action) {
                        "remove" -> {
                            RemovePostByIdUseCase.execute(id = id)
                            call.respondRedirect(pathOnly)
                        }
                        "unpublish" -> {
                            PublishUnpublishPostUseCase.execute(id = id, published = false)
                            call.respondRedirect(pathOnly)
                        }
                        "publish" -> {
                            PublishUnpublishPostUseCase.execute(id = id, published = true)
                            call.respondRedirect(pathOnly)
                        }
                        "edit" -> {
                            call.respondRedirect("/admin/posts/create?id=${id}")
                        }
                        else -> {

                        }
                    }

                }
            }

            val offset = (page - 1) * Config.LIMIT

            val posts = FetchPagedPostsUseCase.execute(
                limit = Config.LIMIT,
                offset = offset,
                month = null,
                year = null,
                tag = null
            )
            call.respondHtml {
                adminLayout {
                    indexPostScreen(posts = posts, url = currentUrl)
                }
            }
        }

        get("/admin/posts/create"){
            val id = call.request.queryParameters["id"]?.toLongOrNull()
            var post: PostImpl? = null
            if (id != null) {
                post = GetPostByIdUseCase.execute(id = id)
            }
            call.respondHtml {
                adminLayout {
                    createPostScreen(post = post)
                }
            }
        }

        post("/admin/posts/create") {
            val controller = PostsController()
            val post = controller.create(call = call)

            if(AddOrUpdatePostUseCase.execute(model = post)){
                call.respondRedirect("/admin/posts/index")
            }
            else{
                call.respondHtml {
                    adminLayout {
                        createPostScreen(post = post)
                    }
                }
            }

        }

        get("/admin/category/index"){
            var pathOnly = call.request.path()
            val currentUrl = call.request.uri
            val action = call.request.queryParameters["action"].toString()
            if(action != null){
                val id = call.request.queryParameters["id"]?.toLongOrNull()
                if (id != null) {
                    when (action) {
                        "remove" -> {
                            RemoveCategoryByIdUseCase.execute(id = id)
//                            RemovePostByIdUseCase.execute(id = id)
                            call.respondRedirect(pathOnly)
                        }
                        "edit" -> {
                            call.respondRedirect("/admin/category/create?id=${id}")
                        }
                        else -> {

                        }
                    }

                }
            }

            val categories = GetCategoriesUseCase.execute()
            call.respondHtml {
                adminLayout {
                    indexCategoriesScreen(categories = categories, url = currentUrl)
                }
            }
        }

        get("/admin/category/create"){
            val id = call.request.queryParameters["id"]?.toLongOrNull()
            var category: CategoryImpl? = null
            if (id != null) {
                category = GetCategoryByIdUseCase.execute(id = id)
            }
            call.respondHtml {
                adminLayout {
                    createCategoryScreen(category = category)
                }
            }
        }

        post("/admin/category/action") {
            val controller = CategoriesController()
            val category = controller.create(call = call)
            if(AddOrUpdateCategoryUseCase.execute(model = category)){
                call.respondRedirect("/admin/category/index")
            }
            else{
                call.respondHtml {
                    adminLayout {
                        createCategoryScreen(category = category)
                    }
                }
            }

        }

        get("/admin/video/index"){
            var pathOnly = call.request.path()
            val currentUrl = call.request.uri
            val action = call.request.queryParameters["action"].toString()
            val page = call.request.queryParameters["page"]?.toIntOrNull() ?: 1

            if(page != null){
                pathOnly = "${pathOnly}?page=${page}"
            }

            println("URL -> ${currentUrl} = ${action}")

            if(action != null){
                val id = call.request.queryParameters["id"]?.toLongOrNull()
                if (id != null) {

                    when (action) {
                        "remove" -> {
                            RemoveVideoByIdUseCase.execute(id = id)
                            call.respondRedirect(pathOnly)
                        }
                        "unpublish" -> {
                            PublishUnpublishVideoUseCase.execute(id = id, published = false)
                            call.respondRedirect(pathOnly)
                        }
                        "publish" -> {
                            PublishUnpublishVideoUseCase.execute(id = id, published = true)
                            call.respondRedirect(pathOnly)
                        }
                        "edit" -> {
                            call.respondRedirect("/admin/video/create?id=${id}")
                        }
                        else -> {

                        }
                    }

                }
            }

            val offset = (page - 1) * Config.LIMIT

            val videos = FetchPagedVideosUseCase.execute(
                limit = Config.LIMIT,
                offset = offset,
                month = null,
                year = null,
                tag = null
            )
            call.respondHtml {
                adminLayout {
                    indexVideoScreen(
                        videos = videos,
                        url = currentUrl
                    )
                }
            }
        }

        get("/admin/video/create"){
            val id = call.request.queryParameters["id"]?.toLongOrNull()
            var video: VideoImpl? = null
            if (id != null) {
                video = GetVideoByIdUseCase.execute(id = id)
            }
            call.respondHtml {
                adminLayout {
                    createVideoScreen(video = video)
                }
            }
        }


        post("/admin/video/create") {
            val controller = VideosController()
            val video = controller.create(call = call)
            if(AddOrUpdateVideoUseCase.execute(model = video)){
                call.respondRedirect("/admin/video/index")
            }
            else{
                call.respondHtml {
                    adminLayout {
                        createVideoScreen(video = video)
                    }
                }
            }

//
//            val multipart = call.receiveMultipart()
//
//            multipart.forEachPart { part ->
//                Uploader.file(
//                    part = part,
//                    dir = "videos",
//                    allowedExt = listOf("mp4", "webm")
//                )
//            }
        }

        get("/admin/image/{id}") {
            val id = call.parameters["id"]
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Missing image ID.")
                return@get
            }

            val post = GetPostByIdUseCase.execute(id = id.toLong())
            if(post == null){
                call.respond(HttpStatusCode.BadRequest, "Missing image.")
                return@get
            }
            val imageDir = File("${FileUtil.getDirMain()}/posts/${post?.image}")
            if (!imageDir.exists()) {
                call.respond(HttpStatusCode.NotFound, "Image directory not found.")
                return@get
            }

            val fileName = post.image
            val imageFile = File("${FileUtil.getDirMain()}/posts", fileName)

            if (!imageFile.exists() || !imageFile.isFile) {
                call.respond(HttpStatusCode.NotFound, "Image file not found on disk.")
                return@get
            }

            call.respondFile(imageFile)
        }

        get("/admin/video/{id}") {
            val id = call.parameters["id"]
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Missing image ID.")
                return@get
            }

            val video = GetVideoByIdUseCase.execute(id = id.toLong())
            if(video == null){
                call.respond(HttpStatusCode.BadRequest, "Missing image.")
                return@get
            }
            val videoDir = File("${FileUtil.getDirMain()}/video")
            if (!videoDir.exists()) {
                call.respond(HttpStatusCode.NotFound, "Video directory not found.")
                return@get
            }

            val fileName = video.video
            val videoFile = File("${FileUtil.getDirMain()}/video", fileName)

            if (!videoFile.exists() || !videoFile.isFile) {
                call.respond(HttpStatusCode.NotFound, "Video file not found on disk.")
                return@get
            }

            call.respondFile(videoFile)
        }


    }

}