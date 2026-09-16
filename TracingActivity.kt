package com.example.tracingalphabet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class TracingActivity : AppCompatActivity() {

    private var currentIndex = 0
    private val letters = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
        "u", "v", "w", "x", "y", "z")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val colorLetter = findViewById<ImageView>(R.id.colorLetter)
        val eraseView = findViewById<EraseView>(R.id.eraseView)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val backButton = findViewById<Button>(R.id.backButton)

        loadLetter(letters[currentIndex], colorLetter, eraseView)

        nextButton.setOnClickListener {
            if (currentIndex < letters.size - 1) {
                currentIndex++
                loadLetter(letters[currentIndex], colorLetter, eraseView)
            }
        }

        backButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                loadLetter(letters[currentIndex], colorLetter, eraseView)
            }
        }
    }

    private fun loadLetter(letter: String, colorView: ImageView, eraseView: EraseView) {
        val colorRes = when(letter) {
            "a" -> R.drawable.a_c
            "b" -> R.drawable.b_c
            "c" -> R.drawable.c_c
            "d" -> R.drawable.d_c
            "e" -> R.drawable.e_c
            "f" -> R.drawable.f_c
            "g" -> R.drawable.g_c
            "h" -> R.drawable.h_c
            "i" -> R.drawable.i_c
            "j" -> R.drawable.j_c
            "k" -> R.drawable.k_c
            "l" -> R.drawable.l_c
            "m" -> R.drawable.m_c
            "n" -> R.drawable.n_c
            "o" -> R.drawable.o_c
            "p" -> R.drawable.p_c
            "q" -> R.drawable.q_c
            "r" -> R.drawable.r_c
            "s" -> R.drawable.s_c
            "t" -> R.drawable.t_c
            "u" -> R.drawable.u_c
            "v" -> R.drawable.v_c
            "w" -> R.drawable.w_c
            "x" -> R.drawable.x_c
            "y" -> R.drawable.y_c
            "z" -> R.drawable.z_c
            else -> R.drawable.a
        }

        val whiteRes = when(letter) {
            "a" -> R.drawable.a
            "b" -> R.drawable.b
            "c" -> R.drawable.c
            "d" -> R.drawable.d
            "e" -> R.drawable.e
            "f" -> R.drawable.f
            "g" -> R.drawable.g
            "h" -> R.drawable.h
            "i" -> R.drawable.i
            "j" -> R.drawable.j
            "k" -> R.drawable.k
            "l" -> R.drawable.l
            "m" -> R.drawable.m
            "n" -> R.drawable.n
            "o" -> R.drawable.o
            "p" -> R.drawable.p
            "q" -> R.drawable.q
            "r" -> R.drawable.r
            "s" -> R.drawable.s
            "t" -> R.drawable.t
            "u" -> R.drawable.u
            "v" -> R.drawable.v
            "w" -> R.drawable.w
            "x" -> R.drawable.x
            "y" -> R.drawable.y
            "z" -> R.drawable.z
            else -> R.drawable.a
        }

        colorView.setImageResource(colorRes)
        eraseView.setLetter(whiteRes)
    }
}
