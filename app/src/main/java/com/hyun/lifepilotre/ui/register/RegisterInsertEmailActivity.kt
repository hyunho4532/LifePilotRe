package com.hyun.lifepilotre.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.databinding.ActivityRegisterInsertEmailBinding

class RegisterInsertEmailActivity : AppCompatActivity() {

    private lateinit var activityRegisterInsertEmailBinding: ActivityRegisterInsertEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterInsertEmailBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_insert_email)

        activityRegisterInsertEmailBinding.ivRegisterNext.setOnClickListener {

        }
    }
}