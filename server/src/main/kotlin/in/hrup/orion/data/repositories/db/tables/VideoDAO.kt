package `in`.hrup.orion.data.repositories.db.tables

import `in`.hrup.orion.data.modelsImpl.VideoImpl
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.LocalDate
import java.time.ZoneOffset

object VideoDAO: LongIdTable("videos") {

    val title = this.varchar("title", 256)
    val slug = this.varchar("slug", 256).uniqueIndex()
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


    fun insert(model: VideoImpl): Long{
        return transaction {
            try{
                insert {
                    modelToRow(it = it, model = model)
                }[VideoDAO.id].value
            }
            catch (e: Exception){
                println("ERROR in VideoDAO.insert: ${e.message}")
                0
            }
        }
    }

    fun update(model: VideoImpl): Boolean{
        return transaction {
            try{
                update({ VideoDAO.id.eq(model.id) }){
                    modelToRow(it = it, model = model)
                } > 0
            }
            catch (e: Exception){
                println("ERROR in VideoDAO.update: ${e.message}")
                false
            }
        }
    }

    fun remove(id: Long): Boolean{
        return transaction{
            try{
                deleteWhere { VideoDAO.id eq id } > 0
            }
            catch (e: Exception){
                println("ERROR in VideoDAO.remove: ${e.message}")
                false
            }
        }

    }

    fun fetchAll(): List<VideoImpl>{
        return transaction {
            try{
                selectAll()
                    .map{
                        rowToModel(row = it)
                    }
            }catch (e: Exception){
                println("ERROR in VideoDAO.fetchAll: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchPaged(limit: Int, offset: Int, month: Int? = null, year: Int? = null, tag: String? = null): List<VideoImpl> {
        return transaction {
            try {
                val query = VideoDAO.selectAll()
                if (month != null && year != null) {
                    val start = LocalDate.of(year, month, 1)
                    val end = start.plusMonths(1)
                    val startEpoch = start.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
                    val endEpoch = end.atStartOfDay().toEpochSecond(ZoneOffset.UTC)
                    query.andWhere {
                        VideoDAO.publishedAt.between(startEpoch, endEpoch)
                    }
                }
                if (!tag.isNullOrBlank()) {
                    val pattern = "%${tag.trim()}%"
                    query.andWhere {
                        VideoDAO.tags like pattern
                    }
                }
                query.orderBy(VideoDAO.publishedAt, SortOrder.DESC)
                query.limit(n = limit, offset = offset.toLong())
                query.map { VideoDAO.rowToModel(it) }
            } catch (e: Exception) {
                println("ERROR in VideoDAO.fetchPaged: ${e.message}")
                listOf()
            }
        }
    }

    fun fetchById(id: Long): VideoImpl? {
        return transaction {
            try{
                select { VideoDAO.id eq id }
                    .singleOrNull()
                    ?.let{ rowToModel(row = it) }
            }catch (e: Exception){
                println("ERROR in VideoDAO.fetchById: ${e.message}")
                null
            }
        }
    }

    fun count(): Long{
        return transaction {
            try{
                selectAll().count()
            }catch (e: Exception){
                println("ERROR in VideoDAO.count: ${e.message}")
                0
            }
        }
    }

    private fun modelToRow(it: UpdateBuilder<Any>, model: VideoImpl){
        it[title] = model.title
        it[slug] = model.slug
        it[description] = model.description
        it[tags] = model.tags
        it[seoTitle] = model.seoTitle
        it[seoDescription] = model.seoDescription
        it[seoKeywords] = model.seoKeywords
        it[seoCanonicalUrl] = model.seoCanonicalUrl
        it[published] = model.published
        it[publishedAt] = model.publishedAt
        it[createdAt] = model.createdAt
        it[updatedAt] = model.updatedAt
    }

    private fun rowToModel(row: ResultRow): VideoImpl {
        return VideoImpl(
            id = row[id].value,
            title = row[title],
            slug = row[slug],
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
