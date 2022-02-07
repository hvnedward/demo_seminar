package com.example.demo_di.di

import android.content.Context
import androidx.room.Room
import com.example.demo_di.Constants
import com.example.demo_di.repo.NoteRepo
import com.example.demo_di.storage.NoteDao
import com.example.demo_di.storage.NoteDataBase
import com.example.demo_di.ultis.ISingleCLickOnItem
import com.example.demo_di.ultis.ISingleClick
import com.example.demo_di.ultis.ISingleClickOnScreen
import com.example.demo_di.viewmodel.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun provideNoteDatabase(application: Context): NoteDataBase {
    return Room.databaseBuilder(
        application,
        NoteDataBase::class.java,
        Constants.DATABASE_NAME
    ).allowMainThreadQueries().build()
}

fun provideNoteDao(noteDataBase: NoteDataBase): NoteDao {
    return noteDataBase.getNoteDao()
}

val appModule = module {
    single {
        provideNoteDao(get())
    }
    single {
        provideNoteDatabase(androidApplication())
    }
}

//use factory will create a new instance everytime the definition is asked
val repoModule = module {
    single {
        NoteRepo(get())
    }
}

val viewmodelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

val interfaceModule = module {
//    It means that A InsingClick when asked to populate always is ISingleClick
//    single<ISingleClick<Any>> {
//        ISingleClickOnScreen()
//    }

//This is the same
//    single {
//        ISingleClickOnScreen()
//    }
//    single { ISingleClickOnScreen() } bind ISingleClick::class


    //nameming qualified
    factory<ISingleClick<Any>>(named("screen")) {
        ISingleClickOnScreen(androidContext())
    }
//    factory<ISingleClick<Any>>(named("item")) {
//      ISingleCLickOnItem(androidContext())
//
//    }
    single<ISingleClick<Any>> {
        ISingleCLickOnItem(androidContext())
    }
}