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

    private val teacherRepository = TeacherRepositoryImpl(context = applicationContext)
    private val logInUseCase = LogInUseCase(teacherRepository = teacherRepository)

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
            when (logInUseCase.execute(param = LogInParam(login = login.text.toString(), password = password.text.toString()))) {
                LogInResponse(statusCode = "EMPTY_LOGIN") -> Toast.makeText(
                    applicationContext, "Введите логин", Toast.LENGTH_SHORT
                ).show()
                LogInResponse(statusCode = "EMPTY_PASS") -> Toast.makeText(
                    applicationContext, "Введите пароль", Toast.LENGTH_SHORT
                ).show()
                LogInResponse(statusCode = "503") -> Toast.makeText(
                    applicationContext, "Проблема с подключением", Toast.LENGTH_SHORT
                ).show()
                LogInResponse(statusCode = "403") -> Toast.makeText(
                    applicationContext, "Неправильный логин или пароль", Toast.LENGTH_SHORT
                ).show()
                LogInResponse(statusCode = "200") -> updateUI()
            }
            if (logInUseCase.execute(param = LogInParam(login = login.text.toString(), password = password.text.toString()) !=  LogInResponse(statusCode = "200", description = "OK")) {

                }
        }
    }

    private fun updateUI() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
