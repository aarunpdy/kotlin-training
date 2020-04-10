package com.pypl.kotlintraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pypl.kotlintraining.databinding.ActivityViewBinderBinding

/**
 * @author arunarumugam
 *
 * @see <a href="https://developer.android.com/topic/libraries/view-binding#kotlin">Data binging</a>
 */
class ViewBindingActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewBinderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            binding.textView.text = "Button clicked"
        }
    }
}
