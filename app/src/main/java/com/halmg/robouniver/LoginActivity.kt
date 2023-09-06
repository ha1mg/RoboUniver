package com.halmg.robouniver

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.halmg.robouniver.domain.usecase.LogInUseCase
import com.halmg.robouniver.data.repository.TeacherRepositoryImpl
import com.halmg.robouniver.domain.models.LogInParam
import com.halmg.robouniver.domain.models.LogInResponse


class LoginActivity : AppCompatActivity() {

    private val teacherRepository = TeacherRepositoryImpl(this)
    private val logInUseCase = LogInUseCase(teacherRepository = teacherRepository)
    private lateinit var logInResponse: LogInResponse

    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.email_login)
        password = findViewById(R.id.password_login)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            logInResponse = logInUseCase.execute(param = LogInParam(login = login.text.toString(), password = password.text.toString()))
            if (logInResponse !=  LogInResponse(statusCode = "200")) {
                Toast.makeText(
                    applicationContext, logInResponse.description, Toast.LENGTH_SHORT
                ).show()
            } else {
                updateUI()
            }
        }
    }

    private fun updateUI() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
