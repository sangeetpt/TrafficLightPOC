package com.test.trafficlight.uicomponents

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.test.trafficlight.R
import kotlinx.android.synthetic.main.activity_traffic_light.*


class TrafficLightActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_light)

        stop()
    }

    private fun stop(){
        redLight.setBackgroundResource(R.drawable.red_circle_bg_dark)

        Handler(Looper.getMainLooper()).postDelayed({
            redLight.setBackgroundResource(R.drawable.red_circle_bg_light)
            waitt()
        }, 4000) // 4 seconds
    }

    private fun waitt(){
        orangeLight.setBackgroundResource(R.drawable.orange_circle_bg_dark)
        Handler(Looper.getMainLooper()).postDelayed({
            orangeLight.setBackgroundResource(R.drawable.orange_circle_bg_light)
            go()
        }, 1000) //1 second

    }

    private fun go(){
        greenLight.setBackgroundResource(R.drawable.green_circle_bg_dark)

        Handler(Looper.getMainLooper()).postDelayed({
            greenLight.setBackgroundResource(R.drawable.green_circle_bg_light)
            stop()
        }, 4000) // 4 seconds
    }
}