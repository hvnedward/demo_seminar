package com.example.demo_di.di

import android.content.Context
import androidx.room.Room
import com.example.demo_di.Constants
import com.example.demo_di.storage.NoteDao
import com.example.demo_di.storage.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NoteDatabaseModule {
    @Provides
    fun provideDao(noteDataBase: NoteDataBase): NoteDao {
        return noteDataBase.getNoteDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NoteDataBase {
        return Room.databaseBuilder(
            appContext,
            NoteDataBase::class.java,
            "logging.db"
        ).build()
    }
}