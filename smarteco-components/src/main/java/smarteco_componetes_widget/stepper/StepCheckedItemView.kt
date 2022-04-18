package smarteco_componetes_widget.stepper

import android.view.View
import com.smartmatic.smarteco.R
import com.smartmatic.smarteco.databinding.StepCheckedItemViewBinding
import com.xwray.groupie.databinding.BindableItem

class StepCheckedItemView(private val step: StepperModel, private val listSize: Int) :
    BindableItem<StepCheckedItemViewBinding>() {
    override fun bind(viewBinding: StepCheckedItemViewBinding, position: Int) {
        viewBinding.tvStepName.run {
            text = context.getString(step.title)
        }
        viewBinding.lineDivider.visibility =
            if (listSize == position.plus(1)) View.INVISIBLE else View.VISIBLE
    }

    override fun getLayout() = R.layout.step_checked_item_view
}
