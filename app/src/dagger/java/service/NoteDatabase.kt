package service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demo_di.Constants
import com.example.demo_di.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun userDao():NoteDao
    companion object{
        var noteDataBase:NoteDatabase? = null
        fun initDatabase(context: Context): NoteDatabase? {
            if(noteDataBase==null){
                noteDataBase = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, Constants.DATABASE_NAME).build()
            }
            return noteDataBase
        }
    }
}