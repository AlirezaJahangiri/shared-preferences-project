package com.alireza.sharedpreferencesex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.alireza.sharedpreferencesex.Fragment.FragmentSignIn
import com.alireza.sharedpreferencesex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var transaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Load fragment into MainActivity =>
        transAction(R.id.frame_main_container, FragmentSignIn())


    }

    fun transAction(container: Int, fragment: Fragment) {
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(container, fragment)
        transaction.commit()

    }
}