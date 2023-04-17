package com.halmg.robouniver

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var btn_login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        login = findViewById(R.id.email_login)
        password = findViewById(R.id.password_login)
        btn_login = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {
            if (login.getText().toString().isEmpty() || login.getText().toString().isEmpty()){
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(login.getText().toString(), password.getText().toString()).addOnCompleteListener { task ->
                    if (!task.isSuccessful) Toast.makeText(
                        applicationContext,
                        "доступ запрещён",
                        Toast.LENGTH_SHORT
                    ).show()
                    else {
                        Toast.makeText(applicationContext, "Добро пожаловать", Toast.LENGTH_SHORT)
                            .show()
                        updateUI()
                    }
                }
            }
        }
    }
        fun updateUI() {
            val user = auth.currentUser
            var intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("user", user!!.email)
            startActivity(intent)
        }
}