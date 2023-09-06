package com.halmg.robouniver.domain.usecase

import com.halmg.robouniver.domain.models.LogInParam
import com.halmg.robouniver.domain.models.LogInResponse
import com.halmg.robouniver.domain.repository.TeacherRepository


class LogInUseCase(private val teacherRepository: TeacherRepository) {

    fun execute(param: LogInParam): LogInResponse{
        return if (param.login.isEmpty()) {
            LogInResponse(statusCode = "EMPTY_LOGIN", description = "Введите логин")
        } else if (param.password.isEmpty()) {
            LogInResponse(statusCode = "EMPTY_PASS", description = "Введите пароль")
        } else if (teacherRepository.getTeacher(loginParam = param) == LogInResponse(statusCode = "503")) {
            LogInResponse(statusCode = "503", description = "Проблема с подключением")
        } else if (teacherRepository.getTeacher(loginParam = param) == LogInResponse(statusCode = "403")){
            LogInResponse(statusCode = "403", description = "Неправильный логин или пароль")
        } else {
            LogInResponse(statusCode = "200", description = "OK")
        }
    }
}