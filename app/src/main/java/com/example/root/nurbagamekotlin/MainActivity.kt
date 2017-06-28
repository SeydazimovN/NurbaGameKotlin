package com.example.root.nurbagamekotlin

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.*
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment()
        var mTextField = findViewById(R.id.countDownTime) as TextView
        var cnt = 0
        var progressBar = findViewById(R.id.determinateBar) as ProgressBar

        fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

        object : CountDownTimer(8000, 10) {

            override fun onTick(millisUntilFinished: Long) {

                var timeLeft = millisUntilFinished.toDouble() / 1000
                mTextField.text = "seconds remaining: ${timeLeft.format(2)}"
                var timeInPercent = millisUntilFinished * 100 / 10000
                progressBar.progress = timeInPercent.toInt()
            }

            override fun onFinish() {
                mTextField.text = "done!"
                changeFragment()
                if (cnt < 5) {
                    cnt++
                    changeImageButton(cnt)
                    this.start()
                }   else {
                    changeImageButton(cnt + 1)
                    go2fragment(3)
                }
            }
        }.start()
    }

    fun changeImageButton(pos : Int) {
        var imageButton = when(pos) {
            1 -> findViewById(R.id.imageButton1)
            2 -> findViewById(R.id.imageButton2)
            3 -> findViewById(R.id.imageButton3)
            4 -> findViewById(R.id.imageButton4)
            5 -> findViewById(R.id.imageButton5)
            else -> findViewById(R.id.imageButton6)
        } as ImageButton

        imageButton.setImageResource(R.drawable.ok)
    }

    fun changeFragment() {
        var chosen = randomInt(2) + 1;
        go2fragment(chosen)
    }

    fun onClickRandomButton(view: View) {
        var chosen = randomInt(2) + 1;
        go2fragment(chosen)
    }
    private fun  go2fragment(chosen: Int) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        println(chosen)

        val instance = when(chosen) {
            1 -> PrimeORComposite.newInstance()
            2 -> SmallestUnique.newInstance()
            else -> {
                Finished.newInstance()
            }
        }

        ft.replace(R.id.frameLayout, instance)
        ft.commit()
    }

    fun randomInt(range : Int) : Int {
        var random = Random()
        return random.nextInt(range)
    }
}