package com.yogify.study.ui.common

import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReminderReceiver : BaseBroadcastReceiver() {

    @Inject
    lateinit var reminderNotificationManager: ReminderNotificationManager
    @Inject
    lateinit var remindMeAlarmManager: ReminderAlarmManager

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == null) return
        if (intent.action == ReminderNotificationManager.ACTION_NOTIFY) {
          //  reminderNotificationManager.notifyReminder(stringToReminderDataObject(intent.getStringExtra(REMINDERITEM)!!)!!)
            remindMeAlarmManager.nextReminder()
        }
    }
}