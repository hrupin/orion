package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.UserImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object UserDAO: LongIdTable("users") {

    val username = varchar("username", 64)
    val password = varchar("password", 64)
    val token = varchar("token", 128)

    fun insert(model: UserImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[UserDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in UserDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: UserImpl): Boolean{
        return transaction {
            try{
                update({ UserDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in UserDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { UserDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in UserDAO.remove: ${e.message}")
                false
            }
        }

    }

    fun fetchAll(): List<UserImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in UserDAO.fetchAll: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): UserImpl? {
        return transaction {
            try{
                select { UserDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in UserDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    fun fetchByUsername(username: String): UserImpl? {
        return transaction {
            try{
                select { UserDAO.username eq username }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in UserDAO.fetchByUsername: ${e.message}")
                null
            }
        }
    }

    fun checkByUserNameAndPassword(username: String, password: String): Boolean {
        return transaction {
            try{
                val query = select { (UserDAO.username eq username) and (UserDAO.password eq password) }
                var b = query.prepareSQL(QueryBuilder(false))
                val r = query.singleOrNull()
                r != null
            }catch (e: Exception){
                println("ERROR in UserDAO.checkByUserNameAndPassword: ${e.message}")
                false
            }
        }
    }

    fun count(): Long{
        return transaction {
            try{
                selectAll().count()
            }catch (e: Exception){
                println("ERROR in UserDAO.count: ${e.message}")
                0
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: UserImpl){
        it[username] = model.username
        it[password] = model.password
        it[token] = model.token
    }

    private fun rowToModel(row: ResultRow): UserImpl {
        return UserImpl(
            id = row[id].value,
            username = row[username],
            password = row[password],
            token = row[token]
        )
    }

}