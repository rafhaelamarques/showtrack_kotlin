package com.cotemig.showtrack.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.cotemig.showtrack.R

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        var btnBackButton = findViewById<ImageButton>(R.id.btnBackButton)

        btnBackButton.setOnClickListener{
            backButtonClick()
        }

        var btnSolicitar = findViewById<Button>(R.id.btnSolicitarSenha)

        btnSolicitar.setOnClickListener {
            solicitarSenhaClick()
        }
    }

    fun backButtonClick() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun solicitarSenhaClick(){
        finish()
    }
}