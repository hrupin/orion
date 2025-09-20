package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.CustomDataImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object CustomDataDAO: LongIdTable("data") {

    val name = this.varchar("name", 512)
    val value = this.text("value")

    fun insert(model: CustomDataImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[CustomDataDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in CustomDataDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: CustomDataImpl): Boolean{
        return transaction {
            try{
                update({ CustomDataDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in CustomDataDAO.update: ${e.message}")
                false
            }
        }
    }

    fun updateByName(model: CustomDataImpl): Boolean{
        return transaction {
            try{
                update({ CustomDataDAO.name.eq(model.name) }){
                    it[value] = model.value
                } > 0
            }
            catch (e: Exception){
                println("ERROR in CustomDataDAO.updateByName: ${e.message}")
                false
            }
        }
    }

    fun fetchByIds(ids: List<Long>): List<CustomDataImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in CustomDataDAO.fetchByIds: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchAll(): List<CustomDataImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in CustomDataDAO.fetchByIds: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): CustomDataImpl? {
        return transaction {
            try{
                select { CustomDataDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in CustomDataDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: CustomDataImpl){
        it[name] = model.name
        it[value] = model.value
    }

    private fun rowToModel(row: ResultRow): CustomDataImpl {
        return CustomDataImpl(
            id = row[id].value,
            name = row[name],
            value = row[value]
        )
    }

}