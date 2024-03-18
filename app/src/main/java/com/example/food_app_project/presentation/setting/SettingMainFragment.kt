package com.example.food_app_project.presentation.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.food_app_project.R
import com.example.food_app_project.databinding.FragmentSettingMainBinding

class SettingMainFragment : Fragment() {
    private lateinit var binding: FragmentSettingMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}