package com.greenrevive.serawaziapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.greenrevive.serawaziapplication.databinding.ActivityHomepageBinding

class homepage : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    private var billsButtonClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
//
//    private fun setupButtonClickListeners() {
//        binding.btnBills.setOnClickListener {
//            val playButton = findViewById<Button>(R.id.btnplay)
//            playButton.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
//            playButton.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor))
//            playButton.setTextColor(ContextCompat.getColor(this, R.color.whiteColor))
//            binding.btnBills.elevation = resources.getDimension(R.dimen.increased_shadow_radius)
//
//            billsButtonClicked = true
//        }
//
//        binding.btnplay.setOnClickListener {
//            if (billsButtonClicked) {
//                val intent = Intent(this, SelectALevelActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }


    override fun onResume() {
        super.onResume()
        setupBottomNav()

    }

    fun setupBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome, HomeFragment())
                        .commit()

                    true
                }
                R.id.settings -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome, SettingsFragment())
                        .commit()

                    true
                }
                R.id.profile-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,ProfileFragment())
                        .commit()

                    true
                }

                R.id.level-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,LevelSelectionFragment())
                        .commit()

                    true
                }

                else ->false
            }
        }
    }
}