package com.tech.mynoteapp

import android.app.Application
import com.tech.mynoteapp.Repository.NoteRepository
import com.tech.mynoteapp.Room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication:Application() {
    //standard operation
    val applicationScope= CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabase.getDatabase(this,applicationScope) }
    val repository by lazy{NoteRepository(database.getNoteDao())}
}