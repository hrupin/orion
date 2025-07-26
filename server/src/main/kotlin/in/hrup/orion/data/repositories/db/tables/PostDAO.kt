package `in`.hrup.orion.data.repositories.db.tables

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.deleteWhere
import `in`.hrup.orion.data.modelsImpl.PostImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.ZoneOffset

object PostDAO: LongIdTable("posts") {

    val title = this.varchar("title", 256)
    val slug = this.varchar("slug", 256).uniqueIndex()
    val content = this.text("content")
    val description = this.varchar("description", 512)
    val tags = this.varchar("tags", 512)
    val seoTitle = this.varchar("seoTitle", 512)
    val seoDescription = this.varchar("seoDescription", 512)
    val seoKeywords = this.varchar("seoKeywords", 512)
    val seoCanonicalUrl = this.varchar("seoCanonicalUrl", 512)
    val published = this.bool("published")
    val publishedAt = this.long("publishedAt")
    val createdAt = this.long("createdAt")
    val updatedAt = this.long("updatedAt")

    fun insert(model: PostImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model, isCreating = true)
                }[PostDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in PostDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: PostImpl): Boolean{
        return transaction {
            try{
                update({ PostDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in PostDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { PostDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in PostDAO.remove: ${e.message}")
                false
            }
        }

    }

    fun fetchAll(): List<PostImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in PostDAO.fetchAll: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchPaged(limit: Int, offset: Int, month: Int? = null, year: Int? = null, tag: String? = null): List<PostImpl> {
        return transaction {
            try {
                val query = PostDAO.selectAll()
                if (month != null && year != null) {
                    val start = LocalDate.of(year, month, 1)
                    val end = start.plusMonths(1)
                    val startEpoch = start.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
                    val endEpoch = end.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
                    query.andWhere {
                        PostDAO.publishedAt.between(startEpoch, endEpoch)
                    }
                }
                if (!tag.isNullOrBlank()) {
                    val pattern = "%${tag.trim()}%"
                    query.andWhere {
                        PostDAO.tags like pattern
                    }
                }
                query.orderBy(PostDAO.publishedAt, SortOrder.DESC)
                query.limit(n = limit, offset = offset.toLong())
                query.map { rowToModel(it) }
            } catch (e: Exception) {
                println("ERROR in PostDAO.fetchPaged: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): PostImpl? {
        return transaction {
            try{
                select { PostDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in PostDAO.fetchById: ${e.message}")
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

    private fun modelToRow(it: UpdateBuilder<Any>, model: PostImpl, isCreating: Boolean = false){
        it[title] = model.title
        it[slug] = model.slug
        it[content] = model.content
        it[description] = model.description
        it[seoTitle] = model.seoTitle
        it[seoDescription] = model.seoDescription
        it[tags] = model.tags
        it[seoKeywords] = model.seoKeywords
        it[seoCanonicalUrl] = model.seoCanonicalUrl
        it[published] = model.published
        val timestamp = System.currentTimeMillis()
        if(model.publishedAt < 1000 && model.published){
            it[publishedAt] = model.publishedAt
        }
        if(isCreating){
            it[createdAt] = timestamp
        }
        it[updatedAt] = timestamp
    }

    private fun rowToModel(row: ResultRow): PostImpl {
        return PostImpl(
            id = row[id].value,
            title = row[title],
            slug = row[slug],
            content = row[content],
            description = row[description],
            tags = row[tags],
            seoTitle = row[seoTitle],
            seoDescription = row[seoDescription],
            seoKeywords = row[seoKeywords],
            seoCanonicalUrl = row[seoCanonicalUrl],
            published = row[published],
            publishedAt = row[publishedAt],
            createdAt = row[updatedAt],
            updatedAt = row[createdAt]
        )
    }

}