package com.maksix.notestones.data.db.converters

import androidx.room.TypeConverter
import org.threeten.bp.OffsetDateTime

class OffsetDateTimeConverter {
    @TypeConverter
    fun fromString(dateTime: String?): OffsetDateTime? {
        return dateTime?.let { OffsetDateTime.parse(it) }
    }

    @TypeConverter
    fun fromDateTime(dateTime: OffsetDateTime?): String? {
        return dateTime?.toString()
    }
}