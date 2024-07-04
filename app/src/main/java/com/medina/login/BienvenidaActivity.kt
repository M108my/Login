package com.medina.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BienvenidaActivity : AppCompatActivity() {
    private lateinit var usuario: Usuario
    private val MENU_ACTIVITY_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        usuario = intent.getSerializableExtra("USER_DATA") as Usuario

        val mensajeBienvenida = findViewById<TextView>(R.id.mensajeBienvenida)
        mensajeBienvenida.text = "Bienvenid@, ${usuario.username}!"

        val menuButton: Button = findViewById(R.id.menuButton)
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java).apply {
                putExtra("USER_DATA", usuario)
            }
            startActivityForResult(intent, MENU_ACTIVITY_REQUEST_CODE)
        }

        val cerrarSesionButton: Button = findViewById(R.id.cerrarSesionButton)
        cerrarSesionButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == MENU_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val updatedUser = data?.getSerializableExtra("UPDATED_USER") as Usuario?
            if (updatedUser != null) {
                usuario = updatedUser
                val mensajeBienvenida = findViewById<TextView>(R.id.mensajeBienvenida)
                mensajeBienvenida.text = "Bienvenid@, ${usuario.username}!"
            }
        }
    }
}