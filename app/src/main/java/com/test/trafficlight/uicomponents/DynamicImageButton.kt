package com.test.trafficlight.uicomponents

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageButton

import androidx.core.content.ContextCompat
import com.test.trafficlight.R

class DynamicImageButton @JvmOverloads

constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = R.attr.imageButtonStyle) :
    androidx.appcompat.widget.AppCompatImageButton(context, attrs, defStyleAttr) {

    private val red_Active = ContextCompat.getDrawable(context, R.drawable.red_circle_bg_dark)
    private val red_InActive = ContextCompat.getDrawable(context, R.drawable.red_circle_bg_light)

    private val orange_Active = ContextCompat.getDrawable(context, R.drawable.orange_circle_bg_dark)
    private val orange_InActive = ContextCompat.getDrawable(context, R.drawable.red_circle_bg_light)

    private val green_Active = ContextCompat.getDrawable(context, R.drawable.green_circle_bg_dark)
    private val green_InActive = ContextCompat.getDrawable(context, R.drawable.green_circle_bg_light)


    fun setRedActive(enabled: Boolean) {
        if (enabled) {
            background=red_Active
        } else {
            background=red_InActive
        }
    }

    fun setOrangeActive(enabled: Boolean) {
        if (enabled) {
            background=orange_Active
        } else {
            background=orange_InActive
        }
    }

    fun setGreenActive(enabled: Boolean) {
        if (enabled) {
            background=green_Active
        } else {
            background=green_InActive
        }
    }


}