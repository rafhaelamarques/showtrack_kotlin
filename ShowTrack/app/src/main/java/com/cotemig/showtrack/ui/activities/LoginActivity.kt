package com.cotemig.showtrack.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cotemig.showtrack.R
import com.cotemig.showtrack.models.Episode
import com.cotemig.showtrack.models.User

class LoginActivity : AppCompatActivity() {
    private var user1: User = User(1, "Rafhaela Marques", "rafhaela.marques", "123")
    private var user2: User = User(1, "Tamides Brandão", "tamides.brandao", "456")
    private var user3: User = User(1, "Cristiane Alves", "cristiane.alves", "789")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginClick()
        }

        val btnForgot = findViewById<Button>(R.id.btnForgot)

        btnForgot.setOnClickListener {
            forgotClick()
        }

        val btnCadastro = findViewById<Button>(R.id.btnRegister)

        btnCadastro.setOnClickListener {
            cadastroClick()
        }
    }

    fun forgotClick() {

        val intent = Intent(this, ForgotActivity::class.java)
        startActivity(intent)

        finish()
    }

    fun cadastroClick(){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }

    fun loginClick() {
        val login = findViewById<EditText>(R.id.login)
        val password = findViewById<EditText>(R.id.password)

        if (login.text.toString() == user1.login &&
            password.text.toString() == user1.senha ||
            login.text.toString() == user2.login &&
            password.text.toString() == user2.senha ||
            login.text.toString() == user3.login &&
            password.text.toString() == user3.senha
        ) {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            finish()
        } else {
            Toast.makeText(
                this@LoginActivity,
                "Credenciais inválidas.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}