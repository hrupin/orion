package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.CategoryImpl
import `in`.hrup.orion.data.modelsImpl.PostImpl
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

object CategoryDAO: LongIdTable("category") {

    val name = this.varchar("name", 512)
    val alias = this.varchar("alias", 512).uniqueIndex()


    fun insert(model: CategoryImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[CategoryDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in CategoryDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: CategoryImpl): Boolean{
        return transaction {
            try{
                update({ CategoryDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in CategoryDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { CategoryDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in CategoryDAO.remove: ${e.message}")
                false
            }
        }

    }

    fun fetchAll(): List<CategoryImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in CategoryDAO.fetchAll: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): CategoryImpl? {
        return transaction {
            try{
                select { CategoryDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in CategoryDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: CategoryImpl){
        it[name] = model.name
        it[alias] = model.alias
    }

    private fun rowToModel(row: ResultRow): CategoryImpl {
        return CategoryImpl(
            id = row[id].value,
            name = row[name],
            alias = row[alias],
        )
    }

}