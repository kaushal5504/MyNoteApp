package com.tech.mynoteapp.View

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tech.mynoteapp.R
import com.tech.mynoteapp.R.id.noteTitle


class NoteAddActivity : AppCompatActivity() {

    lateinit var title: EditText
    lateinit var description : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave :Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_note_add)
        supportActionBar?.title = "Add Note"

        title=findViewById(noteTitle)
        description= findViewById(R.id.noteDescription)
        buttonCancel = findViewById(R.id.button_cancel)
        buttonSave = findViewById(R.id.button_save)

        buttonCancel.setOnClickListener {
            Toast.makeText(this,"Nothing Saved",Toast.LENGTH_SHORT).show()
            finish()

        }

        buttonSave.setOnClickListener {

            saveNote()

        }

    }

    fun saveNote()
    {
        val noteTitle :String = title.text.toString()
        val noteDescription : String = description.text.toString()


        val intent = Intent()
        intent.putExtra("title",noteTitle)
        intent.putExtra("description",noteDescription)
        setResult(RESULT_OK,intent)
        finish()
    }
}