package com.hyun.lifepilotre.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyun.lifepilot.data.model.Exercise
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.adapter.ExerciseAdapter
import com.hyun.lifepilotre.databinding.ActivityRegisterSecondBinding
import java.util.*

class RegisterSecondActivity : AppCompatActivity() {

    private lateinit var activityRegisterSecondBinding: ActivityRegisterSecondBinding

    private val exerciseList: ArrayList<Exercise> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterSecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_second)

        activityRegisterSecondBinding.btnFavoriteExercise.setOnClickListener {
            exerciseList.add(Exercise(activityRegisterSecondBinding.etFavoriteExercise.text.toString()))

            activityRegisterSecondBinding.rvFavoriteExercise.adapter = ExerciseAdapter(exerciseList)
            activityRegisterSecondBinding.rvFavoriteExercise.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }


        // 뒤로 가기 콜백 함수
        this.onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(this@RegisterSecondActivity, RegisterFirstActivity::class.java)
                startActivity(intent)

                overridePendingTransition(R.anim.slide_in_left, R.anim.hold)

                finish()
            }
        })
    }
}