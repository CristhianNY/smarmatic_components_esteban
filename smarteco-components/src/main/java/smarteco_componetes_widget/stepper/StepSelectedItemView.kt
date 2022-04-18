package smarteco_componetes_widget.stepper

import android.view.View
import com.smartmatic.smarteco.R
import com.smartmatic.smarteco.databinding.StepSelectedItemViewBinding
import com.xwray.groupie.databinding.BindableItem

class StepSelectedItemView(private val step: StepperModel, private val listSize: Int) :
    BindableItem<StepSelectedItemViewBinding>() {
    override fun bind(viewBinding: StepSelectedItemViewBinding, position: Int) {

        viewBinding.tvStepName.run {
            text = context.getString(step.title)
        }
        viewBinding.tvStepNumber.text = (position.plus(1)).toString()
        viewBinding.lineDivider.visibility =
            if (listSize == position.plus(1)) View.INVISIBLE else View.VISIBLE
    }

    override fun getLayout() = R.layout.step_selected_item_view
}
