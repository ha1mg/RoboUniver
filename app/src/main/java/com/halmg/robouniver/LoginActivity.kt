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
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var btn_login: Button
    private lateinit var sessionManager: SessionManager
    private lateinit var authClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        auth = Firebase.auth
//        login = findViewById(R.id.email_login)
//        password = findViewById(R.id.password_login)
//        btn_login = findViewById(R.id.btn_login)
//        btn_login.setOnClickListener {
//            if (login.getText().toString().isEmpty() || login.getText().toString().isEmpty()){
//                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
//            } else {
//                auth.signInWithEmailAndPassword(login.getText().toString(), password.getText().toString()).addOnCompleteListener { task ->
//                    if (!task.isSuccessful) Toast.makeText(
//                        applicationContext,
//                        "доступ запрещён",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    else {
//                        //Toast.makeText(applicationContext, "Добро пожаловать", Toast.LENGTH_SHORT)
//                            //.show()
//                        updateUI()
//                    }
//                }
//            }
//        }

        login = findViewById(R.id.email_login)
        password = findViewById(R.id.password_login)
        btn_login = findViewById(R.id.btn_login)

        authClient = ApiClient()
        sessionManager = SessionManager(this)
        btn_login.setOnClickListener {
            authClient.getAuthController().signin(
                SignInRequest(
                    login = login.text.toString(),
                    password = password.text.toString()
                )
            )
            .enqueue(object : Callback<SigninResponse> {
                override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
                    Toast.makeText(
                        applicationContext, "ошибка", Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Retrofit", t.toString())
                }

                override fun onResponse(
                    call: Call<SigninResponse>,
                    response: Response<SigninResponse>
                ) {
                    val signinResponse = response.body()
                    Log.d("Retrofit", signinResponse?.statusCode.toString())
                    if (signinResponse?.statusCode == 200 && signinResponse?.name != null) { //&& loginResponse.user != null
                        sessionManager.saveAuthToken(signinResponse.token)
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
        //val user = auth.currentUser
        val intent = Intent(this, MainActivity::class.java)
        //intent.putExtra("user", user!!.email)
        startActivity(intent)
    }
}
