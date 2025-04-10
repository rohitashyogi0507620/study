package com.yogify.study.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yogify.study.data.db.AppDatabase
import com.yogify.study.data.db.DataBaseConstant.REMINDER_DATABASE
import com.yogify.study.data.db.DataDAO
import com.yogify.study.data.repository.MainRepository
import com.yogify.study.ui.common.ReminderAlarmManager
import com.yogify.study.ui.common.ReminderNotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.annotation.Nullable
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideChannelDao(appDatabase: AppDatabase): DataDAO {
        return appDatabase.dataDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext, AppDatabase::class.java, REMINDER_DATABASE
        ).setJournalMode(RoomDatabase.JournalMode.TRUNCATE).allowMainThreadQueries().build()
    }


    @Provides
    fun provideRemindMeAlarmManager(
        @ApplicationContext context: Context, mainRepository: MainRepository
    ): ReminderAlarmManager = ReminderAlarmManager(context, mainRepository)

    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): ReminderNotificationManager = ReminderNotificationManager(context)

}