package com.tech.mynoteapp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tech.mynoteapp.R

class UpdateActivity : AppCompatActivity() {

    lateinit var title: EditText
    lateinit var description : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button

    var currentId:Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Update Note"

        title=findViewById(R.id.noteTitleUpdate)
        description= findViewById(R.id.noteDescriptionUpdate)
        buttonCancel = findViewById(R.id.button_cancel_update)
        buttonSave = findViewById(R.id.button_save_update)

        getAndSetData()

        buttonCancel.setOnClickListener {
            Toast.makeText(this,"Nothing Updated", Toast.LENGTH_SHORT).show()
            finish()

        }

        buttonSave.setOnClickListener {

            updateNote()

        }


    }

    fun updateNote()
    {
        val updatedTitle = title.text.toString()
        val updatedDescription = description.text.toString()

        val intent = Intent()
        intent.putExtra("updatedTitle",updatedTitle)
        intent.putExtra("updatedDescription",updatedDescription)
        if(currentId !=-1)
        {
            intent.putExtra("noteId",currentId)
            setResult(RESULT_OK,intent)
            finish()
        }


    }

    fun getAndSetData()
    {
        //get
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDescription = intent.getStringExtra("currentDescription")
        currentId = intent.getIntExtra("currentId",-1)

        //set
        title.setText(currentTitle)
        description.setText(currentDescription)

    }
}