package com.medina.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MenuActivity : AppCompatActivity() {
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        usuario = intent.getSerializableExtra("USER_DATA") as Usuario

        val nombreEditText = findViewById<EditText>(R.id.nombreEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)

        nombreEditText.setText(usuario.username)
        emailEditText.setText(usuario.email)

        val updateNameButton: Button = findViewById(R.id.actualizarNombreButton)
        updateNameButton.setOnClickListener {
            val newName = nombreEditText.text.toString()
            usuario.username = newName
            Toast.makeText(this, "Nombre actualizado por $newName", Toast.LENGTH_SHORT).show()
        }

        val updateEmailButton: Button = findViewById(R.id.actualizarEmailButton)
        updateEmailButton.setOnClickListener {
            val newEmail = emailEditText.text.toString()
            usuario.email = newEmail
            Toast.makeText(this, "Email actualizado por $newEmail", Toast.LENGTH_SHORT).show()
        }

        val backButton: Button = findViewById(R.id.regresarButton)
        backButton.setOnClickListener {
            // Preparar el intent para devolver los cambios a la actividad anterior
            val returnIntent = Intent()
            returnIntent.putExtra("UPDATED_USER", usuario)
            setResult(RESULT_OK, returnIntent)
            finish() // Finalizar esta actividad y volver a la anterior
        }
    }

    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("UPDATED_USER", usuario)
        setResult(RESULT_OK, returnIntent)
        super.onBackPressed()
    }
}

