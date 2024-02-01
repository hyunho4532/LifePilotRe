package com.hyun.lifepilotre.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.databinding.ActivityRegisterBinding
import com.hyun.lifepilotre.ui.register.RegisterSecondActivity

class RegisterStatusViewModel : ViewModel() {

    val genderStatus = MutableLiveData<Boolean>()
    val heightStatus = MutableLiveData<String>()
    val weightStatus = MutableLiveData<String>()

    fun registerGenderStatus(status: Boolean) {
        genderStatus.value = status
    }

    fun registerHeightStatus(statusHeight: String) {
        heightStatus.value = statusHeight
    }

    fun registerWeightStatus(statusWeight: String) {
        weightStatus.value = statusWeight
    }

    fun registerValidateCheckData(context: Context, activityRegisterBinding: ActivityRegisterBinding) = when {
        activityRegisterBinding.tvSeekbarHeightResult.text.toString().isEmpty() ->
            Toast.makeText(context, "키를 선택해주세요.", Toast.LENGTH_SHORT).show()

        activityRegisterBinding.tvSeekbarWeightResult.text.toString().isEmpty() ->
            Toast.makeText(context, "몸무게를 선택해주세요", Toast.LENGTH_SHORT).show()

        else -> {
            val intent = Intent(context, RegisterSecondActivity::class.java)
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.hold)
        }
    }
}