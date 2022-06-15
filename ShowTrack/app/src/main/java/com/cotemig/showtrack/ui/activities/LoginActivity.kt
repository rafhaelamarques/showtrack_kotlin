package com.cotemig.showtrack.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.cotemig.showtrack.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginClick()
        }

        var btnForgot = findViewById<Button>(R.id.btnForgot)

        btnForgot.setOnClickListener {
            forgotClick()
        }

        var btnCadastro = findViewById<Button>(R.id.btnRegister)

        btnCadastro.setOnClickListener {
            cadastroClick()
        }
    }

    fun forgotClick() {

        var intent = Intent(this, ForgotActivity::class.java)
        startActivity(intent)

        finish()
    }

    fun loginClick() {
        var login = findViewById<EditText>(R.id.login)
        var password = findViewById<EditText>(R.id.password)

        if (login.text.toString() == "72001119@aluno.faculdadecotemig.br" &&
            password.text.toString() == "123" ||
            login.text.toString() == "tamidesbrandao@gmail.com" &&
            password.text.toString() == "123"
        ) {

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            finish()
        }
    }

    fun cadastroClick(){
        var intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}