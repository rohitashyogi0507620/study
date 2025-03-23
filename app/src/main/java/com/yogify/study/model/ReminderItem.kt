package com.yogify.study.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yogify.study.data.db.DataBaseConstant.REMINDER_TABLE
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = REMINDER_TABLE)
@Keep
data class ReminderItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var imageUriPath: String,
    var imageWebUriPath: String,
    var name: String,
    var gender: Int,
    var date: Long,
    var mobileNumber: String,
    var wish: String,
    var colorLight: String,
    var colorDark: String,
    var type: Int,
    var isNotify: Boolean,
    var notifyType: Int,
    var isTextMessage: Boolean,
    var isWhatsappMessage: Boolean
) : Parcelable
