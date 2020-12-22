package com.studio.jmpeg.avinfo

object JNIAvInfo {
    init {
        System.loadLibrary("avcodec-57")
        System.loadLibrary("avdevice-57")
        System.loadLibrary("avfilter-6")
        System.loadLibrary("avformat-57")
        System.loadLibrary("avutil-55")
        System.loadLibrary("postproc-54")
        System.loadLibrary("swresample-2")
        System.loadLibrary("swscale-4")
        System.loadLibrary("jmpeg")
    }

    external fun getUrlProtocolInfo(): String
    external fun getAvFormatInfo(): String
    external fun getAvCodecInfo(): String
    external fun getAvFilterInfo(): String
    external fun getConfigurationInfo(): String
}