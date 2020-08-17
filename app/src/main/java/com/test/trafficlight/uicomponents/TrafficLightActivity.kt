package com.test.trafficlight.uicomponents

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.trafficlight.BR
import com.test.trafficlight.R
import kotlinx.android.synthetic.main.activity_traffic_light.*
import com.test.trafficlight.databinding.ActivityTrafficLightBinding


class TrafficLightActivity : AppCompatActivity() {

    var trafficLightViewModel = TrafficLightViewModel()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var  binding = DataBindingUtil.setContentView<ActivityTrafficLightBinding>(this, R.layout.activity_traffic_light)
        binding.trafficLightViewModel = TrafficLightViewModel()

        trafficLightViewModel = ViewModelProvider(this@TrafficLightActivity).get(
            TrafficLightViewModel::class.java
        )

        stop()
    }

    fun stop(){

        Handler(Looper.getMainLooper()).postDelayed({
            redLight.setRedActive(false)
            orangeLight.setOrangeActive(true)
            waitt()
        }, 4000) // 4 seconds
    }

    private fun waitt(){
        Handler(Looper.getMainLooper()).postDelayed({
            orangeLight.setOrangeActive(false)
            greenLight.setGreenActive(true)
            go()
        }, 1000) // 1 seconds
    }

    private fun go(){
        Handler(Looper.getMainLooper()).postDelayed({
            greenLight.setGreenActive(false)
            redLight.setRedActive(true)
            stop()
        }, 4000) //4 seconds
    }


}