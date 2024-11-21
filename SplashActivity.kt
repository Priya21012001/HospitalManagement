package rvs.priya.carryonapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.VideoView

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            val videoHolder : VideoView = findViewById(R.id.splash_id)
            val video = Uri.parse("android.resource://"+ packageName + "/" + R.raw.carryon)
            videoHolder.setVideoURI(video)
            videoHolder.setOnCompletionListener { jump() }
            videoHolder.start()

        } catch (ex: Exception) {
            jump()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean
    {
        jump()
        return true
    }

    private fun jump()
    {
        if (isFinishing)
            return
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },SPLASH_TIME_OUT)

    }
}