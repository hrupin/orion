package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.QuestionnaireImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import kotlin.Long

object QuestionnaireDAO: LongIdTable("questionnaire") {

    val name = varchar("name", 255)
    val lastName = varchar("lastName", 255)
    val birthday = long("birthday")
    val phone = varchar("phone", 255)
    val email = varchar("email", 255)
    val militaryBranch = varchar("militaryBranch", 255)
    val comment = text("comment")
    val status = integer("status")

    fun insert(model: QuestionnaireImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[QuestionnaireDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in QuestionnaireDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: QuestionnaireImpl): Boolean{
        return transaction {
            try{
                update({ QuestionnaireDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in QuestionnaireDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { QuestionnaireDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in QuestionnaireDAO.remove: ${e.message}")
                false
            }
        }
    }

    fun fetchAll(): List<QuestionnaireImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in QuestionnaireDAO.fetchByIds: ${e.message}")
                listOf()
            }
        }
    }

    fun setStatus(id: Long, st: Int): Boolean{
        return transaction {
            try{
                update({ QuestionnaireDAO.id.eq(id) }){
                    it[status] = st
                } > 0
            }
            catch (e: Exception){
                println("ERROR in QuestionnaireDAO.update: ${e.message}")
                false
            }
        }
    }

    fun fetchPaged(limit: Int, offset: Int): List<QuestionnaireImpl> {
        return transaction {
            try {
                val query = selectAll()
                query.orderBy(QuestionnaireDAO.id, SortOrder.DESC)
                query.limit(n = limit, offset = offset.toLong())
                query.map { QuestionnaireDAO.rowToModel(it) }
            } catch (e: Exception) {
                println("ERROR in QuestionnaireDAO.fetchPaged: ${e.message}")
                listOf()
            }
        }
    }


    fun fetchById(id: Long): QuestionnaireImpl? {
        return transaction {
            try{
                select { QuestionnaireDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in QuestionnaireDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    fun count(): Long{
        return transaction {
            try{
                selectAll().count()
            }catch (e: Exception){
                println("ERROR in PostDAO.count: ${e.message}")
                0
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: QuestionnaireImpl){
        it[name] = model.name
        it[lastName] = model.lastName
        it[birthday] = model.birthday
        it[phone] = model.phone
        it[email] = model.email
        it[militaryBranch] = model.militaryBranch
        it[comment] = model.comment
        it[status] = model.status
    }

    private fun rowToModel(row: ResultRow): QuestionnaireImpl {
        return QuestionnaireImpl(
            id = row[id].value,
            name = row[name],
            lastName = row[lastName],
            birthday = row[birthday],
            phone = row[phone],
            email = row[email],
            militaryBranch = row[militaryBranch],
            comment = row[comment],
            status = row[status]
        )
    }

}