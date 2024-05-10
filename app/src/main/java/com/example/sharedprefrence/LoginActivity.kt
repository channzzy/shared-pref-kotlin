package com.example.sharedprefrence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sessionManager = SessionManager(this)

        val btnLogn = findViewById<Button>(R.id.btn_login)
        if(sessionManager.isLogin()){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            btnLogn.setOnClickListener {
                val name = findViewById<TextView>(R.id.name).text.toString()
                val password = findViewById<TextView>(R.id.password).text.toString()

                if(name.isEmpty()){
                    Toast.makeText(this, "Nama harus diisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(password.isEmpty()){
                    Toast.makeText(this, "Password harus diisi", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                sessionManager.sessionLogin(name,password)

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}