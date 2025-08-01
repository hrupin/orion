package `in`.hrup.orion.data.repositories.db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import `in`.hrup.orion.data.modelsImpl.UserImpl
import `in`.hrup.orion.data.repositories.db.tables.PostDAO
import `in`.hrup.orion.data.repositories.db.tables.UserDAO
import `in`.hrup.orion.domain.utils.FileUtil
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.exists
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init() {
        val dbPath = "${FileUtil.getDirMain()}/data.db"
        Database.connect(
            url = "jdbc:sqlite:$dbPath",
            driver = "org.sqlite.JDBC"
        )
        transaction {
            if (!UserDAO.exists()) {
                SchemaUtils.create(UserDAO)
                val data = FileUtil.readDataJsonFile()
                val gson = Gson()
                val usersType = object : TypeToken<List<UserImpl>>(){}.type
                val users: List<UserImpl> = gson.fromJson(data, usersType)
                users.forEach {
                    UserDAO.insert(
                        UserImpl(
                            id = it.id,
                            username = it.username,
                            password = it.password,
                            token = it.token
                        )
                    )
                }
            }
            SchemaUtils.create(PostDAO)
        }
    }

}