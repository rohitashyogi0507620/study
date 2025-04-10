package com.yogify.study.data.db

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.yogify.study.model.ReminderItem
import kotlinx.coroutines.flow.Flow


@Dao
interface DataDAO {


    @RawQuery
    fun checkpoint(supportSQLiteQuery: SupportSQLiteQuery): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminderItem: ReminderItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReminder(entities: List<ReminderItem>): List<Long>

    @Delete
    suspend fun deleteReminder(reminderItem: ReminderItem)

    @Update
    suspend fun updateReminder(reminderItem: ReminderItem): Int

//    @Query("UPDATE REMINDER_TABLE SET imageWebUriPath = :imageWebUrl  WHERE id = :id")
//    fun updateImageWrbUrl(id: String, imageWebUrl: String)String

    //    @Query("UPDATE REMINDER_TABLE SET imageWebUriPath = :imageWebUrl  WHERE rowid = :id")
//    fun updateImageWrbUrl(id: String, imageWebUrl: String)
//
    @Query("select * from REMINDER_TABLE ")
    fun getReminder():Flow<List<ReminderItem>>
//
    @Query("select * from REMINDER_TABLE")
    fun getReminderList(): List<ReminderItem>


//    @Query("SELECT * FROM REMINDER_TABLE ORDER BY id DESC LIMIT :limit OFFSET :offset")
//    suspend fun getReminder(limit: Int, offset: Int): Flow<List<ReminderItem>>

//    @Query("select * from MotorRecentSearch WHERE productCode = :productCode order by quotationNumber desc")
//    fun getRecentSearch(productCode: String): Flow<List<ReminderItem>>

}