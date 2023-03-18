package com.tech.mynoteapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

//it will create table in database-
// it is a room annotation process
@Entity(tableName = "note_table")
class Note(val title:String, val description:String){

    @PrimaryKey(autoGenerate = true)
    var id=0


}