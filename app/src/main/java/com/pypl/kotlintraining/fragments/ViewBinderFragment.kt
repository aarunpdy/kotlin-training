package com.pypl.kotlintraining.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pypl.kotlintraining.R
import com.pypl.kotlintraining.databinding.FragmentViewBinderBinding

/**
 * TODO: Write Javadoc for ViewBinderFragment.
 *
 * @author arunarumugam
 */
class ViewBinderFragment : Fragment() {
    lateinit var binding: FragmentViewBinderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewBinderBinding.inflate(inflater, container, false)
        binding.btnFragment.setOnClickListener {
            Toast.makeText(activity, "Toast from fragment", Toast.LENGTH_LONG).show()
        }
        return binding.root
    }
}
