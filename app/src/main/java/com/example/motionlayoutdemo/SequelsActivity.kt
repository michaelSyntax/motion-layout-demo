package com.example.motionlayoutdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motionlayoutdemo.databinding.ActivitySequelsBinding

class SequelsActivity : AppCompatActivity() {
    private lateinit var vbinding: ActivitySequelsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbinding = ActivitySequelsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(vbinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ml_sequels)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vbinding.episode7.setOnClickListener { resetAndShowName(R.string.episode7) }
        vbinding.episode8.setOnClickListener { resetAndShowName(R.string.episode8) }
        vbinding.episode9.setOnClickListener { resetAndShowName(R.string.episode9) }
    }

    private fun resetAndShowName(@StringRes nameStringRes: Int) {
        vbinding.episodeName.text = getString(nameStringRes)
        vbinding.mlSequels.transitionToStart()
    }
}