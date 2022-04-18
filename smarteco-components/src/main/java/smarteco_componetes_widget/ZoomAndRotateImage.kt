package smarteco_componetes_widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import com.smartmatic.smarteco.R
import com.smartmatic.smarteco.databinding.ZoomAndRotateImageViewBinding

class ZoomAndRotateImage : ConstraintLayout {
    private var onZoomClick: ((creditCardData: Bitmap) -> Unit)? = null
    private var onMinusClick: ((creditCardData: Bitmap) -> Unit)? = null
    private var onRotateImage: ((creditCardData: Bitmap) -> Unit)? = null
    private var deGrades = 0f
    private var xCoOrdinate = 0f
    private var yCoOrdinate = 0f

    private var showRotateIcon = false
    private val binding =
        ZoomAndRotateImageViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        initView()
        moveImage()
    }

    private fun initView() {
        binding.btnPus.setOnClickListener {
            onZoomClick()
        }

        binding.btnMinus.setOnClickListener {
            onMinusClick()
        }

        binding.btnRotate.setOnClickListener {
            rotateBitmap()
        }
    }

    constructor(context: Context) : super(context) {
        initialize(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize(attrs)
    }

    private fun initialize(attrs: AttributeSet?) {
        loadAttrs(attrs)
        if (showRotateIcon) binding.btnRotate.visibility = View.VISIBLE else binding.btnRotate.visibility = View.GONE
    }

    private fun loadAttrs(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ZoomAndRotateImage,
            0, 0
        ).apply {
            showRotateIcon = getBoolean(R.styleable.ZoomAndRotateImage_show_rotate_icon, false)
            recycle()
        }
    }

    private fun setImage(image: Bitmap) {
        binding.ivPicture.setImageBitmap(image)
    }

    private fun setZoomListener(zoomListener: (bitMap: Bitmap) -> Unit) {
        onZoomClick = zoomListener
    }

    private fun seOnRotateListener(rotateListener: (bitMap: Bitmap) -> Unit) {
        onRotateImage = rotateListener
    }

    private fun seOnMinusClickListener(onMinusClickListener: (bitMap: Bitmap) -> Unit) {
        onMinusClick = onMinusClickListener
    }

    private fun onZoomClick() {
        val x: Float = binding.ivPicture.scaleX
        val y: Float = binding.ivPicture.scaleY
        binding.ivPicture.scaleX = x + 0.5f
        binding.ivPicture.scaleY = y + 0.5f
        onZoomClick?.invoke(binding.ivPicture.drawable.toBitmap())
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun moveImage() {

        binding.ivPicture.setOnTouchListener(
            OnTouchListener { view, event ->
                when (event.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        xCoOrdinate = view.x - event.rawX
                        yCoOrdinate = view.y - event.rawY
                    }
                    MotionEvent.ACTION_MOVE -> view.animate().x(event.rawX + xCoOrdinate)
                        .y(event.rawY + yCoOrdinate).setDuration(0).start()
                    else -> return@OnTouchListener false
                }
                true
            }
        )
    }

    private fun onMinusClick() {
        val x: Float = binding.ivPicture.scaleX
        val y: Float = binding.ivPicture.scaleY
        if (x > 0.5f) {
            binding.ivPicture.scaleX = x - 0.5f
            binding.ivPicture.scaleY = y - 0.5f
            onMinusClick?.invoke(binding.ivPicture.drawable.toBitmap())
        }
    }

    private fun rotateBitmap() {
        if (deGrades == -180f) {
            deGrades = 0f
        } else {
            deGrades += -90f
        }

        val matrix = Matrix()
        matrix.postRotate(-90f)
        val imageRotate = Bitmap.createBitmap(
            binding.ivPicture.drawable.toBitmap(),
            0,
            0,
            binding.ivPicture.drawable.toBitmap().width,
            binding.ivPicture.drawable.toBitmap().height,
            matrix,
            true
        )
        binding.ivPicture.setImageBitmap(imageRotate)

        onRotateImage?.invoke(imageRotate)
    }

    companion object {
        @BindingAdapter("bitmap_image")
        @JvmStatic
        fun setImage(view: ZoomAndRotateImage, image: Bitmap) {
            view.setImage(image)
        }

        @BindingAdapter("zoom_click")
        @JvmStatic
        fun onZoomClick(view: ZoomAndRotateImage, zoomListener: ((bitMap: Bitmap) -> Unit)) {
            view.setZoomListener(zoomListener)
        }

        @BindingAdapter("on_minus_click")
        @JvmStatic
        fun onMinusClick(view: ZoomAndRotateImage, zoomListener: ((bitMap: Bitmap) -> Unit)) {
            view.seOnMinusClickListener(zoomListener)
        }

        @BindingAdapter("on_rotate_image_click")
        @JvmStatic
        fun onRotateImage(view: ZoomAndRotateImage, rotateImage: ((bitMap: Bitmap) -> Unit)) {
            view.seOnRotateListener(rotateImage)
        }
    }
}
