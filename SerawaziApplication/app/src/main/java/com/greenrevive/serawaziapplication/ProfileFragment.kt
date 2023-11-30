package com.greenrevive.serawaziapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.greenrevive.serawaziapplication.databinding.FragmentProfileBinding
import com.greenrevive.serawaziapplication.ui.HomeFragment
import com.greenrevive.serawaziapplication.utils.Constants

class ProfileFragment : Fragment() {
    var binding: FragmentProfileBinding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_profile, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
//        binding?.tvappversion?. text ="APP VERSION : ${com.greenrevive.serawaziapplication.Buildconfig.VERSION_NAME}"

        binding?.icBack?.setOnClickListener{backToHome()}

    }
    fun backToHome(){

        requireContext().startActivity(Intent(requireContext() ,com.greenrevive.serawaziapplication.ui.SelectALevelActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding =null
    }



}