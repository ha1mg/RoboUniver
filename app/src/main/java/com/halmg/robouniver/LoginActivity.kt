package com.halmg.robouniver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.halmg.robouniver.model.api.ApiClient
import com.halmg.robouniver.model.api.SigninResponse
import com.halmg.robouniver.model.api.SessionManager
import com.halmg.robouniver.model.api.SignInRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: Button
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.email_login)
        password = findViewById(R.id.password_login)
        btnLogin = findViewById(R.id.btn_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)
        btnLogin.setOnClickListener {
            apiClient.getApiService(this).signin(
                SignInRequest(
                    login = login.text.toString(),
                    password = password.text.toString()
                )
            )
            .enqueue(object : Callback<SigninResponse> {
                override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
                    Toast.makeText(
                        applicationContext, "ошибка сервера", Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Retrofit", t.toString())
                }

                override fun onResponse(
                    call: Call<SigninResponse>,
                    response: Response<SigninResponse>
                ) {
                    val signinResponse = response.body()
                    if (signinResponse?.statusCode == 200) { //&& loginResponse.user != null
                        sessionManager.saveAuthToken(signinResponse.token)
                        sessionManager.saveTeacherName(signinResponse.name)
                        updateUI()
                    } else {
                        Toast.makeText(
                            applicationContext, "доступ запрещён", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }
    }

    private fun updateUI() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
