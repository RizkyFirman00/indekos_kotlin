package com.example.indekos.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MyAppRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MyAppRoomDatabase::class.java,
            "myapp_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: MyAppRoomDatabase) = database.userDao()

    @Provides
    @Singleton
    fun provideIndekosDao(database: MyAppRoomDatabase) = database.indekosDao()
}
