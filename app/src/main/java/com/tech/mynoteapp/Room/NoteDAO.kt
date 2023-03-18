package com.tech.mynoteapp.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tech.mynoteapp.Model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDAO {


    @Insert
    suspend fun insert(note:Note)

    @Update
    suspend fun update(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNotes()

    @Query("select * from note_table order by id asc")
    fun getAllNotes() : Flow<List<Note>>


}