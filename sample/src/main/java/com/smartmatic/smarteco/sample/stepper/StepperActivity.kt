package com.smartmatic.smarteco.sample.stepper

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartmatic.smarteco.sample.R
import com.smartmatic.smarteco.sample.databinding.ActivityStepperBinding
import com.smartmatic.smarteco.utils.setOnSingleClickListener
import com.smartmatic.smarteco.widget.stepper.StepperModel

class StepperActivity : AppCompatActivity() {
    private val stepperViewModelInActivity: StepperViewModel by viewModels()
    private lateinit var activityStepperBinding: ActivityStepperBinding
    var counterStepsClicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStepperBinding = DataBindingUtil.setContentView(this, R.layout.activity_stepper)
        getView()
    }

    private fun getView() {
        stepperViewModelInActivity.setStepperState(StepperState.CheckListSelected())
        activityStepperBinding.run {
            this.stepperViewModel = stepperViewModelInActivity
            this.lifecycleOwner = this@StepperActivity
        }

        activityStepperBinding.nextStep.setOnSingleClickListener {
            counterStepsClicks++
            if (counterStepsClicks > 5) counterStepsClicks = 5
            loadStepper()
        }

        activityStepperBinding.backStep.setOnSingleClickListener {
            counterStepsClicks--
            if (counterStepsClicks < 1) counterStepsClicks = 1
            loadStepper()
        }
    }

    private fun loadStepper() {
        when (counterStepsClicks) {
            1 -> stepperViewModelInActivity.setStepperState(StepperState.CheckListSelected())
            2 -> stepperViewModelInActivity.setStepperState(StepperState.CaptureFromImageSelected())
            3 -> stepperViewModelInActivity.setStepperState(StepperState.TypeInResultsSelected())
            4 -> stepperViewModelInActivity.setStepperState(StepperState.ReviewSelected())
            5 -> stepperViewModelInActivity.setStepperState(StepperState.SubmitSelected())
        }
    }
}

class StepperViewModel : ViewModel() {
    private val _stepperList: MutableLiveData<List<StepperModel>> = MutableLiveData()
    val stepperList: LiveData<List<StepperModel>> = _stepperList

    fun setStepperState(stepperState: StepperState) {
        _stepperList.value = when (stepperState) {
            is StepperState.CheckListSelected -> stepperState.stepperList
            is StepperState.CaptureFromImageSelected -> stepperState.stepperList
            is StepperState.TypeInResultsSelected -> stepperState.stepperList
            is StepperState.ReviewSelected -> stepperState.stepperList
            is StepperState.SubmitSelected -> stepperState.stepperList
        }
    }
}
