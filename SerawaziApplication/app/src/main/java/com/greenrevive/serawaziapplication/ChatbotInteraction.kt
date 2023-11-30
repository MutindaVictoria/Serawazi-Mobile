//package com.greenrevive.serawaziapplication
//
//import androidx.appcompat.app.AlertDialog
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import com.greenrevive.serawaziapplication.databinding.ActivityChatbotInteractionBinding
//
//
//class ChatbotInteraction : AppCompatActivity() {
//    private lateinit var binding: ActivityChatbotInteractionBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityChatbotInteractionBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//
//
//    override fun onResume() {
//        super.onResume()
//        binding.imageView5.setOnClickListener {
//            val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
//            val alertDialog = AlertDialog.Builder(this).create()
//            alertDialog.setView(popupView)
//            val closeButton = popupView.findViewById<Button>(R.id.closePopupButton)
//            closeButton.setOnClickListener {
//                alertDialog.dismiss()
//                val intent = Intent(this, SignUpActivity::class.java)
//                startActivity(intent)
//            }
//            alertDialog.show()
//        }
//
//    }
//}
//
//
//
////SignUpActivity
//
package com.greenrevive.serawaziapplication

import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.greenrevive.serawaziapplication.databinding.ActivityChatbotInteractionBinding

class ChatbotInteraction : AppCompatActivity() {
    private lateinit var binding: ActivityChatbotInteractionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatbotInteractionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.imageView5.setOnClickListener {
            val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setView(popupView)
            val closeButton = popupView.findViewById<Button>(R.id.closePopupButton)
            closeButton.setOnClickListener {
                alertDialog.dismiss()
                
                // Start SignUpActivity
                val signUpIntent = Intent(this, SignUpActivity::class.java)
                startActivityForResult(signUpIntent, SIGN_UP_REQUEST_CODE)
            }
            alertDialog.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            SIGN_UP_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    // SignUpActivity finished successfully
                    // Start LoginActivity
                    val loginIntent = Intent(this, LogIn::class.java)
                    startActivityForResult(loginIntent, LOGIN_REQUEST_CODE)
                }
            }
            LOGIN_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    // LogIn activity finished successfully
                    // Start AnswerChat activity
                    val answerChatIntent = Intent(this, AnswerChat::class.java)
                    startActivity(answerChatIntent)
                    // Do not finish the ChatbotInteraction activity to keep the flow intact
                }
            }
        }
    }

    companion object {
        const val SIGN_UP_REQUEST_CODE = 1
        const val LOGIN_REQUEST_CODE = 2
    }
}
