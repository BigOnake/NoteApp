package com.example.noteapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.model.NoteModel

@Database(
    entities = [NoteModel::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDataBase? = null

        fun getDataBase(context: Context): NoteDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDataBase::class.java, "room_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}