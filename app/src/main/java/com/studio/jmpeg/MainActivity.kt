package com.studio.jmpeg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.studio.jmpeg.avinfo.JNIAvInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvAvInfo = findViewById<TextView>(R.id.tv_av_info)
        findViewById<Button>(R.id.btn_url_protocol_info).setOnClickListener {
            tvAvInfo.text = JNIAvInfo.getUrlProtocolInfo()
        }
        findViewById<Button>(R.id.btn_av_format_info).setOnClickListener {
            tvAvInfo.text = JNIAvInfo.getAvFormatInfo()
        }
        findViewById<Button>(R.id.btn_av_codec_info).setOnClickListener {
            tvAvInfo.text = JNIAvInfo.getAvCodecInfo()
        }
        findViewById<Button>(R.id.btn_av_filter_info).setOnClickListener {
            tvAvInfo.text = JNIAvInfo.getAvFilterInfo()
        }
        findViewById<Button>(R.id.btn_configuration_info).setOnClickListener {
            tvAvInfo.text = JNIAvInfo.getConfigurationInfo()
        }
    }
}