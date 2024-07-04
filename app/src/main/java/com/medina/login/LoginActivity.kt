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

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val accederButton: Button = findViewById(R.id.accederButton)
        accederButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            val usuarioRegistrado = RegistrarseActivity.getUsuarioRegistrado()

            if (usuarioRegistrado != null && usuarioRegistrado.email == email && usuarioRegistrado.password == password) {
                val intent = Intent(this, BienvenidaActivity::class.java).apply {
                    putExtra("USER_DATA", usuarioRegistrado)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciales Inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}