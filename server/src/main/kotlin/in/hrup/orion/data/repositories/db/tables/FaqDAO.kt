package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.FaqImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object FaqDAO: LongIdTable("faq") {

    val question = this.text("question")
    val answer = this.text("answer")
    val sort = this.integer("sort")

    fun insert(model: FaqImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[FaqDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in FaqDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: FaqImpl): Boolean{
        return transaction {
            try{
                update({ FaqDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in FaqDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { FaqDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in FaqDAO.remove: ${e.message}")
                false
            }
        }
    }

    fun fetchAll(): List<FaqImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in FaqDAO.fetchByIds: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): FaqImpl? {
        return transaction {
            try{
                select { FaqDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in FaqDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: FaqImpl){
        it[question] = model.question
        it[answer] = model.answer
        it[sort] = model.sort
    }

    private fun rowToModel(row: ResultRow): FaqImpl {
        return FaqImpl(
            id = row[id].value,
            question = row[question],
            answer = row[answer],
            sort = row[sort]
        )
    }
}