package com.redoz.mayusminus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var editTxt: EditText
    lateinit var btn: MaterialButton
    lateinit var txtV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxt = findViewById(R.id.editTxt)
        btn = findViewById(R.id.btnSum)
        txtV = findViewById(R.id.txtVResult)

        btn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (editTxt.text.toString() == "") {
            Toast.makeText(this,"Hay campos vacios", Toast.LENGTH_LONG).show()
            return
        }

        val text = editTxt.text.toString()

        val textCase = when {
            text.contains(text.uppercase(Locale.getDefault())) -> "mayusculas"
            text.contains(text.lowercase(Locale.getDefault())) -> "minusculas"
            else -> "mayusculas y minusculas"
        }

        txtV.text = "Contiene $textCase"

        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        // on below line hiding our keyboard.
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}