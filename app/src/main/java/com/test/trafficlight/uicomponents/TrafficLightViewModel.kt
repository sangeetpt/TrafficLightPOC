package com.test.trafficlight.uicomponents

import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.test.trafficlight.BR

class TrafficLightViewModel : ViewModel() {

    var imgBtnRed: ObservableField<ImageButton>? = null
    var imgBtnOrange: ObservableField<ImageButton>? = null
    var imgBtnGreen: ObservableField<ImageButton>? = null

    init {
        imgBtnRed = ObservableField()
        imgBtnOrange = ObservableField()
        imgBtnGreen = ObservableField()
    }

}