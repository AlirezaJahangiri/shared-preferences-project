package com.alireza.sharedpreferencesex.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alireza.sharedpreferencesex.R
import com.alireza.sharedpreferencesex.databinding.FragmentSignInBinding

class FragmentSignIn() : Fragment() {
    lateinit var binding: FragmentSignInBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //shared preferences =>
        sharedPreferences = requireActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE)


        binding.btnSubmit.setOnClickListener() {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {

                sharedPreferences.edit().putString("name", name).apply()
                sharedPreferences.edit().putString("email", email).apply()

                if (binding.radMale.isChecked) {
                    //male
                    sharedPreferences.edit().putBoolean("isMale" , true).apply()

                } else {
                    //female
                    sharedPreferences.edit().putBoolean("isMale" , false).apply()

                }


                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_main_container, FragmentShowData())
                transaction.commit()
                sharedPreferences.edit().putBoolean("isFirstRun", true).apply()

                Toast.makeText(
                    requireContext(),
                    "همه اطلاعات شما در سامانه ثبت گردید!!!",
                    Toast.LENGTH_SHORT
                ).show()


            } else {
                Toast.makeText(
                    requireContext(),
                    "لطفا همه مقادیر را وارد کنید!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



        if (restorePrefDataFirstRun()) {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container, FragmentShowData())
            transaction.commit()
        }


    }

    fun restorePrefDataFirstRun(): Boolean {
        val output = sharedPreferences.getBoolean("isFirstRun", false)
        return output
    }
}