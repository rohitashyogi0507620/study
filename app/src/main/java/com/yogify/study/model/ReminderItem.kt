package com.yogify.study.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yogify.study.data.db.DataBaseConstant.REMINDER_TABLE

@Entity(tableName = REMINDER_TABLE)
data class ReminderItem(@PrimaryKey var id :Int, var name:String)
