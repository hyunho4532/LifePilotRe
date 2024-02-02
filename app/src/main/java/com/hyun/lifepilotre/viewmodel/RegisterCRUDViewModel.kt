package com.hyun.lifepilotre.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.hyun.lifepilotre.data.model.User
import com.hyun.lifepilotre.database.LifePilotDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterCRUDViewModel : ViewModel() {

    @OptIn(DelicateCoroutinesApi::class)
    fun insertUser(context: Context, firebaseUser: FirebaseUser, userEmail: String, success: (String) -> Unit) {
        val userDao = LifePilotDatabase.getInstance(context).userDao()

        val user = User(uid = firebaseUser.uid, email = userEmail)

        GlobalScope.launch {
            userDao.insertUser(user)
            success("회원가입이 정상적으로 등록되었습니다.")
        }
    }

    fun selectUser() {

    }
}