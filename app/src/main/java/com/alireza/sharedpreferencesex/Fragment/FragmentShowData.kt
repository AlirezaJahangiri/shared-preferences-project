package com.alireza.sharedpreferencesex.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alireza.sharedpreferencesex.databinding.FragmentShowDataBinding
import com.alireza.sharedpreferencesex.databinding.FragmentSignInBinding

class FragmentShowData() : Fragment() {
    lateinit var binding: FragmentShowDataBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE)

        binding.txtShowName.text = "My name is : " + sharedPreferences.getString("name", "")
        binding.txtShowEmail.text = "My Email is : " + sharedPreferences.getString("email", "")

        val isMale = sharedPreferences.getBoolean("isMale", true)

        if (isMale) {
            //male
            binding.txtShowGender.text = "Male"
        } else {
            //female
            binding.txtShowGender.text = "Female"
        }

    }
}