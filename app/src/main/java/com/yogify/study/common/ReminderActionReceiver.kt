package com.yogify.birthdayreminder.common

import android.content.Context
import android.content.Intent
import com.yogify.birthdayreminder.common.ReminderNotificationManager.Companion.ACTION_SMS
import com.yogify.birthdayreminder.common.ReminderNotificationManager.Companion.ACTION_WHATSAPP
import com.yogify.birthdayreminder.common.ReminderNotificationManager.Companion.NOTIFICATION_ID
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReminderActionReceiver : BaseBroadcastReceiver() {

    @Inject
    lateinit var reminderNotificationManager: ReminderNotificationManager

    @Inject
    lateinit var remindMeAlarmManager: ReminderAlarmManager
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == null) return
        var reminderItem = stringToReminderDataObject(intent.getStringExtra(REMINDERITEM)!!)!!
        var notificationId = intent.getIntExtra(NOTIFICATION_ID, -1)

        if (intent.action.equals(ACTION_SMS)) {
            sendTextSMS(reminderItem.mobileNumber, reminderItem.wish)
        } else if (intent.action.equals(ACTION_WHATSAPP)) {
            openWhatsApp(context, reminderItem.mobileNumber, reminderItem.wish)
        }
        reminderNotificationManager.cancelNotification(notificationId)

    }
}