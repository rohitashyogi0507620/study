package com.yogify.birthdayreminder.ui.notification

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.yogify.birthdayreminder.common.ReminderAlarmManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    var reminderAlarmManager: ReminderAlarmManager
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        reminderAlarmManager.nextReminder()
        return Result.success()
    }
}
