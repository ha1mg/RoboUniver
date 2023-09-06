package com.halmg.robouniver.data.repository

import android.content.Context
import android.util.Log
import com.halmg.robouniver.domain.models.LogInParam
import com.halmg.robouniver.domain.models.LogInResponse
import com.halmg.robouniver.domain.repository.TeacherRepository
import com.halmg.robouniver.data.api.ApiClient
import com.halmg.robouniver.data.api.SignInRequest
import com.halmg.robouniver.data.api.SigninResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherRepositoryImpl(private val context: Context) : TeacherRepository {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    private lateinit var result: LogInResponse

    override fun getTeacher(loginParam: LogInParam):LogInResponse {
        apiClient = ApiClient()
        sessionManager = SessionManager(context)

        apiClient.getApiService(context).signin(
            SignInRequest(
                login = loginParam.login,
                password = loginParam.password
            )
        )
            .enqueue(object : Callback<SigninResponse> {
                override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
//                    Toast.makeText(
//                        applicationContext, "Проблема с подключением", Toast.LENGTH_SHORT
//                    ).show()
                    Log.d("Retrofit", t.toString())
                    result = LogInResponse(statusCode = "503")
                }
                override fun onResponse(
                    call: Call<SigninResponse>,
                    response: Response<SigninResponse>
                ) {
                    val signinResponse = response.body()
                    if (signinResponse?.statusCode == 200) { //&& loginResponse.user != null
                        sessionManager.saveAuthToken(signinResponse.token)
                        sessionManager.saveTeacherName(signinResponse.name)
                        result = LogInResponse(statusCode = "200")
                    } else {
//                        Toast.makeText(
//                            applicationContext, "Неправильный логин или пароль", Toast.LENGTH_SHORT
//                        ).show()
                        result = LogInResponse(statusCode = "403")
                    }
                }
            })
        return result
    }
}