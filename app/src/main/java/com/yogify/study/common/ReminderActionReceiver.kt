package com.yogify.birthdayreminder.common

import android.content.Context
import android.content.Intent
import com.yogify.study.ui.common.BaseBroadcastReceiver
import com.yogify.study.ui.common.ReminderAlarmManager
import com.yogify.study.ui.common.ReminderNotificationManager
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

    }
}