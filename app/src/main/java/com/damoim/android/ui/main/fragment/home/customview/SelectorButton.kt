package com.damoim.android.ui.main.fragment.home.customview


import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.damoim.android.R


class SelectorButton : LinearLayout {
    var layoutBackground: LinearLayout? = null
    var text1: TextView? = null
    var text2: TextView? = null
    var isChecked: Boolean? = null

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
        getAttrs(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs) {
        initView()
        getAttrs(attrs, defStyle)
    }

    private fun initView() {
        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
        val layoutInflater = context.getSystemService(inflaterService) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.button_date, this, false)
        addView(view)
        layoutBackground = findViewById(R.id.button_date_container)
        text1 = findViewById(R.id.button_date_txt_day_of_the_week)
        text2 = findViewById(R.id.button_date_txt_day)
    }

    private fun getAttrs(attrs: AttributeSet?) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.SelectorButton)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet?, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs,
            R.styleable.SelectorButton,
            defStyle,
            0)
        setTypeArray(typedArray)
    }

    @SuppressLint("ResourceAsColor")
    private fun setTypeArray(typedArray: TypedArray) {
        val backgroundResourceId =
            typedArray.getResourceId(R.styleable.SelectorButton_layoutBackground,
                R.drawable.bg_layout_gray06_purple04)
        layoutBackground!!.setBackgroundResource(backgroundResourceId)

        val textColor =
            typedArray.getColor(R.styleable.SelectorButton_textColor, R.color.white)
        text1!!.setTextColor(textColor)
        text2!!.setTextColor(textColor)

        val text1Value = typedArray.getString(R.styleable.SelectorButton_text1)
        text1!!.text = text1Value

        val text2Value = typedArray.getString(R.styleable.SelectorButton_text2)
        text2!!.text = text2Value

        isChecked = typedArray.getBoolean(R.styleable.SelectorButton_isChecked, false)

        typedArray.recycle()
    }

    fun setBackground(backgroundResourceId: Int) {
        layoutBackground!!.setBackgroundResource(backgroundResourceId)
        invalidate()
        requestLayout()
    }

    fun setTextColor(color: Int) {
        text1!!.setTextColor(ContextCompat.getColor(context, color))
        text2!!.setTextColor(ContextCompat.getColor(context, color))
        invalidate()
        requestLayout()
    }


    fun setText1(text_string: String?) {
        text1!!.text = text_string
        invalidate()
        requestLayout()
    }

    fun setText1(textResourceId: Int) {
        text1!!.setText(textResourceId)
        invalidate()
        requestLayout()
    }

    fun setText2(text_string: String?) {
        text2!!.text = text_string
        invalidate()
        requestLayout()
    }

    fun setText2(textResourceId: Int) {
        text2!!.setText(textResourceId)
        invalidate()
        requestLayout()
    }

    fun setChecked(checked: Boolean) {
        if (checked) {
            setTextColor(R.color.white)
            setBackground(R.drawable.bg_btn_purple01)
        } else {
            setTextColor(R.color.gray03)
            setBackground(R.drawable.bg_layout_gray06_purple04)
        }
        isChecked = checked
        invalidate()
        requestLayout()
    }
}