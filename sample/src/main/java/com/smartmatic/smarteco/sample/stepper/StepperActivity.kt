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
import com.smartmatic.smarteco.widget.stepper.StepperModel
import com.smartmatic.smarteco.widget.stepper.TypeStep

class StepperActivity : AppCompatActivity() {
    private val stepperViewModelInActivity: StepperViewModel by viewModels()
    private lateinit var activityStepperBinding: ActivityStepperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityStepperBinding = DataBindingUtil.setContentView(this, R.layout.activity_stepper)
        getView()
    }

    private fun getView() {
        activityStepperBinding.run{
            this.stepperViewModel = stepperViewModelInActivity
        }
    }

}

class StepperViewModel : ViewModel(){
    private val _stepperList: MutableLiveData<List<StepperModel>> = MutableLiveData()
    val stepperList : LiveData<List<StepperModel>> = _stepperList
    init {
        setList()
    }

    private fun setList() {
        _stepperList.value = listOf(
            StepperModel(R.string.stepper_one, TypeStep.SELECTED),
            StepperModel(R.string.stepper_two, TypeStep.UNSELECTED),
            StepperModel(R.string.stepper_three, TypeStep.UNSELECTED)
        )
    }
}
