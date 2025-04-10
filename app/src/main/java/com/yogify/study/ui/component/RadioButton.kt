package com.yogify.study.ui.component

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import com.yogify.study.R

class RadioButton(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatRadioButton(context, attrs) {
    init {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            this.setTextAppearance(context, R.style.RadioButtonStyle)
        }
    }
}