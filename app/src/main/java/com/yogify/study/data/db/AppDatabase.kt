package com.yogify.study.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yogify.study.model.ReminderItem

@Database(version = 1, entities = [ReminderItem::class], exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDAO
}