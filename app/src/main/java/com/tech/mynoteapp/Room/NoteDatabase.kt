package com.tech.mynoteapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tech.mynoteapp.Model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Note::class],version= 1)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun getNoteDao():NoteDAO

    //single object must be created form databse class

    //singelton

    companion object{

        //volatile annotation provide
        // usablity of database object to every thread of project
        @Volatile
        private var INSTANCE:NoteDatabase?=null

        fun getDatabase(context:Context,scope:CoroutineScope) : NoteDatabase{
            return INSTANCE?: synchronized(this)
            {
                val instance= Room.databaseBuilder(context.applicationContext,
                NoteDatabase::class.java,"note_database")
                    .addCallback(NoteDatabaseCallback(scope))
                    .build()

                INSTANCE=instance

                instance
            }
        }


    }

    private class NoteDatabaseCallback(private val scope:CoroutineScope):RoomDatabase.Callback()
    {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE.let{ database->

                scope.launch {
                    val dao= database!!.getNoteDao()
                    dao.insert(Note("Title 1" , "description 1"))
                    dao.insert(Note("Title 2" , "description 2"))
                    dao.insert(Note("Title 3" , "description 3"))

                }
            }
        }
    }

}