package com.hyun.lifepilotre.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.databinding.ActivityRegisterBinding
import com.hyun.lifepilotre.viewmodel.RegisterStatusViewModel

class RegisterFirstActivity : AppCompatActivity() {

    private lateinit var activityRegisterBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val registerStatusViewModel: RegisterStatusViewModel = ViewModelProvider(this)[RegisterStatusViewModel::class.java]

        activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        activityRegisterBinding.lifecycleOwner = this
        activityRegisterBinding.statusViewModel = registerStatusViewModel

        activityRegisterBinding.cvRegisterGenderChoiceMan.setOnClickListener {
            registerStatusViewModel.registerGenderStatus(true)
        }

        activityRegisterBinding.cvRegisterGenderChoiceWoman.setOnClickListener {
            registerStatusViewModel.registerGenderStatus(false)
        }

        activityRegisterBinding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                (progress.toString() + "cm").also { height ->
                    registerStatusViewModel.registerHeightStatus(height)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        activityRegisterBinding.weightSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                (progress.toString() + "kg").also { weight ->
                    registerStatusViewModel.registerWeightStatus(weight)
                }
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }
        })

        activityRegisterBinding.ivRegisterNext.setOnClickListener {
            registerStatusViewModel.registerValidateCheckData(context = this@RegisterFirstActivity, activityRegisterBinding)
        }
    }
}