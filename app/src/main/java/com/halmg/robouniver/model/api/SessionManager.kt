package com.halmg.robouniver.model.api



import android.content.Context
import android.content.SharedPreferences
import com.halmg.robouniver.R


class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context
        .getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val TEACHER_TOKEN = "user_token"
        const val TEACHER_NAME = "teacher_name"
        const val TEACHER_ID = "teacher_id"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(TEACHER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(TEACHER_TOKEN, null)
    }

    fun saveTeacherName(name: String) {
        val editor = prefs.edit()
        editor.putString(TEACHER_NAME, name)
        editor.apply()
    }

    fun fetchTeacherName(): String? {
        return prefs.getString(TEACHER_NAME, null)
    }
}
