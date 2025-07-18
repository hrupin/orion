package `in`.hrup.orion.domain.utils

import java.security.MessageDigest

object MD5Util {

    fun getFromString(str: String): String{
        val bytes = MessageDigest
            .getInstance("MD5")
            .digest(str.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

}