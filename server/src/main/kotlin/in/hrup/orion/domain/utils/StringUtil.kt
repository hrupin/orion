package `in`.hrup.orion.domain.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID

object StringUtil {

    val translitMap = mapOf(
        "а" to "a", "б" to "b", "в" to "v", "г" to "g", "д" to "d", "е" to "e", "ё" to "e", "ж" to "zh",
        "з" to "z", "и" to "i", "й" to "y", "к" to "k", "л" to "l", "м" to "m", "н" to "n", "о" to "o",
        "п" to "p", "р" to "r", "с" to "s", "т" to "t", "у" to "u", "ф" to "f", "х" to "kh", "ц" to "ts",
        "ч" to "ch", "ш" to "sh", "щ" to "shch", "ъ" to "", "ы" to "y", "ь" to "", "э" to "e", "ю" to "yu", "я" to "ya",
        "є" to "ie", "і" to "i", "ї" to "i", "ґ" to "g", " " to "-", "_" to "-", "'" to "", "\"" to ""
    )

    fun toSlug(str: String): String {
        val transliterated = str.lowercase()
            .replace(Regex("[а-яёіїєґ]", RegexOption.IGNORE_CASE)) {
                translitMap[it.value.lowercase()] ?: ""
            }

        return transliterated
            .replace(Regex("[^a-z0-9]+"), "-")
            .replace(Regex("-+"), "-")
            .trim('-')
    }

    fun getUUID(): String {
        return UUID.randomUUID().toString()
    }

    fun formatTimestampToUkrainianDate(timestampMillis: Long): String {
        if(timestampMillis < 1) return " - "
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm", Locale.forLanguageTag("uk"))
        val date = Instant.ofEpochMilli(timestampMillis)
            .atZone(ZoneId.of("Europe/Kyiv"))
            .format(formatter)

        return date
    }

}