package com.smartmatic.smarteco.sample.stepper

import com.smartmatic.smarteco.sample.R
import com.smartmatic.smarteco.widget.stepper.StepperModel
import com.smartmatic.smarteco.widget.stepper.TypeStep

sealed class StepperState {
    data class CheckListSelected(
        val stepperList: List<StepperModel> = listOf(
            StepperModel(R.string.checklist, TypeStep.SELECTED),
            StepperModel(R.string.capture_from_image, TypeStep.UNSELECTED),
            StepperModel(R.string.type_in_results, TypeStep.UNSELECTED),
            StepperModel(R.string.review, TypeStep.UNSELECTED),
            StepperModel(R.string.submit, TypeStep.UNSELECTED)
        )
    ) : StepperState()

    data class CaptureFromImageSelected(
        val stepperList: List<StepperModel> = listOf(
            StepperModel(R.string.checklist, TypeStep.CHECKED),
            StepperModel(R.string.capture_from_image, TypeStep.SELECTED),
            StepperModel(R.string.type_in_results, TypeStep.UNSELECTED),
            StepperModel(R.string.review, TypeStep.UNSELECTED),
            StepperModel(R.string.submit, TypeStep.UNSELECTED)
        )
    ) : StepperState()

    data class TypeInResultsSelected(
        val stepperList: List<StepperModel> = listOf(
            StepperModel(R.string.checklist, TypeStep.CHECKED),
            StepperModel(R.string.capture_from_image, TypeStep.CHECKED),
            StepperModel(R.string.type_in_results, TypeStep.SELECTED),
            StepperModel(R.string.review, TypeStep.UNSELECTED),
            StepperModel(R.string.submit, TypeStep.UNSELECTED)
        )
    ) : StepperState()

    data class ReviewSelected(
        val stepperList: List<StepperModel> = listOf(
            StepperModel(R.string.checklist, TypeStep.CHECKED),
            StepperModel(R.string.capture_from_image, TypeStep.CHECKED),
            StepperModel(R.string.type_in_results, TypeStep.CHECKED),
            StepperModel(R.string.review, TypeStep.SELECTED),
            StepperModel(R.string.submit, TypeStep.UNSELECTED)
        )
    ) : StepperState()

    data class SubmitSelected(
        val stepperList: List<StepperModel> = listOf(
            StepperModel(R.string.checklist, TypeStep.CHECKED),
            StepperModel(R.string.capture_from_image, TypeStep.CHECKED),
            StepperModel(R.string.type_in_results, TypeStep.CHECKED),
            StepperModel(R.string.review, TypeStep.CHECKED),
            StepperModel(R.string.submit, TypeStep.SELECTED)
        )
    ) : StepperState()
}