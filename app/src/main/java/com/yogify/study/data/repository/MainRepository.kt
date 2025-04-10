package com.yogify.study.data.repository

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.yogify.study.data.db.AppDatabase
import com.yogify.study.data.db.DataBaseConstant.REMINDER_DATABASE
import com.yogify.study.data.db.DataDAO
import com.yogify.study.model.ReminderItem
import com.yogify.study.util.utils.Companion.databasePath
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import java.io.File
import java.io.IOException
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject


class MainRepository @Inject constructor(
    @ApplicationContext var context: Context,
    private val dataDAO: DataDAO, private val appDatabase: AppDatabase
) {

    fun getdao(): DataDAO {
        return dataDAO
    }

    fun getDatabase(): AppDatabase {
        return appDatabase
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertReminder(reminderItem: ReminderItem): Long {
        return dataDAO.insertReminder(reminderItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertReminder(reminderItem: List<ReminderItem>): List<Long> {
        return dataDAO.insertReminder(reminderItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateReminder(reminderItem: ReminderItem): Int {
        return dataDAO.updateReminder(reminderItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteReminder(reminderItem: ReminderItem) {
        dataDAO.deleteReminder(reminderItem)
    }


    fun getReminder(): Flow<List<ReminderItem>> {
        return dataDAO.getReminder()
    }

    fun getReminderList(): List<ReminderItem> {
        return dataDAO.getReminderList()
    }

    fun nextReminder(): ReminderItem? {

        var nextreminderItem: ReminderItem? = null

        val currentTimeMillis = Calendar.getInstance(Locale.US).timeInMillis
        var listdata = mutableListOf<ReminderItem>()
        getReminderList().forEachIndexed { index, it ->
            var calendar = Calendar.getInstance(Locale.US)
          //  calendar.timeInMillis = it.date

            val nextTrigger = Calendar.getInstance().apply {
                timeInMillis = currentTimeMillis
                set(Calendar.MONTH, calendar.get(Calendar.MONTH))
                set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH))
                set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY))
                set(Calendar.MINUTE, calendar.get(Calendar.MINUTE))
                set(Calendar.SECOND, 0)
            }.timeInMillis
            Log.d("TIMENEXT", nextTrigger.toString())
            Log.d("TIMECURRENT", currentTimeMillis.toString())


            if (nextTrigger > currentTimeMillis) {
                listdata.add(it)
            }
        }
      //  nextreminderItem = listdata.minWithOrNull(Comparator.comparingLong { it.date })
        Log.d("LATESTITEM", nextreminderItem.toString())
        return nextreminderItem

    }


    private fun checkpoint() {
        var db = appDatabase.openHelper.writableDatabase
        val cursor = db.query("PRAGMA wal_checkpoint(TRUNCATE)", arrayOf())
        cursor.moveToFirst()
    }


}