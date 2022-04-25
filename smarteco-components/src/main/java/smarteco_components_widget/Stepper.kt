package smarteco_components_widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.smartmatic.smarteco.databinding.StepperViewBinding
import com.xwray.groupie.GroupieAdapter
import smarteco_components_widget.stepper.StepCheckedItemView
import smarteco_components_widget.stepper.StepSelectedItemView
import smarteco_components_widget.stepper.StepUnSelectedItemView
import smarteco_components_widget.stepper.StepperModel
import smarteco_components_widget.stepper.TypeStep

private const val DEFAULT_ATTR = 0

class Stepper @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = DEFAULT_ATTR
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding =
        StepperViewBinding.inflate(LayoutInflater.from(context), this, true)
    private val adapter by lazy { GroupieAdapter() }

    init {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvSteps.apply {
            setHasFixedSize(true)
            adapter = this@Stepper.adapter
        }
    }

    private fun loadSteps(stepsList: List<StepperModel>) {

        val items = stepsList.map { step ->
            when (step.typeStep) {
                TypeStep.SELECTED -> {
                    StepSelectedItemView(step, stepsList.size)
                }
                TypeStep.UNSELECTED -> {
                    StepUnSelectedItemView(step, stepsList.size)
                }
                TypeStep.CHECKED -> {
                    StepCheckedItemView(step, stepsList.size)
                }
            }
        }
        adapter.updateAsync(items)
    }

    companion object {
        @BindingAdapter("stepper_list")
        @JvmStatic
        fun loadSteps(view: Stepper, stepsList: List<StepperModel>?) = view.run {
            stepsList?.let { view.loadSteps(it) }
        }
    }
}
