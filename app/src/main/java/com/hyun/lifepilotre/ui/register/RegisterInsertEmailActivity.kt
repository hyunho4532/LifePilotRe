package com.hyun.lifepilotre.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.databinding.ActivityRegisterInsertEmailBinding

class RegisterInsertEmailActivity : AppCompatActivity() {

    private lateinit var activityRegisterInsertEmailBinding: ActivityRegisterInsertEmailBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterInsertEmailBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_insert_email)

        activityRegisterInsertEmailBinding.ivRegisterNext.setOnClickListener {
            auth.createUserWithEmailAndPassword(activityRegisterInsertEmailBinding.etRegisterEmail.text.toString(), activityRegisterInsertEmailBinding.etRegisterPassword.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this, "이메일이 정상적으로 등록되었습니다.", Toast.LENGTH_SHORT).show()
                }

                .addOnFailureListener {

                }
        }
    }
}