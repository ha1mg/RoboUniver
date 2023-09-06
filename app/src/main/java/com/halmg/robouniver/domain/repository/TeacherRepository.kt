package com.halmg.robouniver.domain.repository

import com.halmg.robouniver.domain.models.LogInParam
import com.halmg.robouniver.domain.models.LogInResponse

interface TeacherRepository() {

    fun getTeacher(loginParam: LogInParam): LogInResponse
}