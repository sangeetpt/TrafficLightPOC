package com.test.trafficlight.uicomponents

import android.app.Application
import android.widget.ImageButton
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class TrafficLightViewModel(application: Application) : AndroidViewModel(application) {

    var imgBtnRed: ObservableField<ImageButton>? = null
    var imgBtnOrange: ObservableField<ImageButton>? = null
    var imgBtnGreen: ObservableField<ImageButton>? = null
}