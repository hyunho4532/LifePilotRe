package com.hyun.lifepilotre.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.databinding.ActivityRegisterInsertEmailBinding
import com.hyun.lifepilotre.viewmodel.RegisterCRUDViewModel

class RegisterInsertEmailActivity : AppCompatActivity() {

    private lateinit var activityRegisterInsertEmailBinding: ActivityRegisterInsertEmailBinding
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterInsertEmailBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_insert_email)

        val registerCRUDViewModel: RegisterCRUDViewModel = ViewModelProvider(this)[RegisterCRUDViewModel::class.java]

        activityRegisterInsertEmailBinding.ivRegisterNext.setOnClickListener {
            auth.createUserWithEmailAndPassword(activityRegisterInsertEmailBinding.etRegisterEmail.text.toString(), activityRegisterInsertEmailBinding.etRegisterPassword.text.toString())
                .addOnSuccessListener { authResult ->
                    val firebaseUser = authResult.user
                    val userEmail = firebaseUser?.email

                    userEmail?.let { email ->
                        registerCRUDViewModel.insertUser(this, firebaseUser, email) { success ->
                            runOnUiThread {
                                Toast.makeText(this, success, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                .addOnFailureListener {

                }
        }
    }
}