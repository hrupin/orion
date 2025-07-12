package `in`.hrup.orion.data.repositories.db

import `in`.hrup.orion.data.repositories.db.tables.UserDAO
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        Database.connect(
            url = "jdbc:sqlite:data.db",
            driver = "org.sqlite.JDBC"
        )

        transaction {
            SchemaUtils.create(UserDAO)
        }
    }
}