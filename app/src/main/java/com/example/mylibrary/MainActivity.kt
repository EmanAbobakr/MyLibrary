package com.example.mylibrary

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        lateinit var btn_validate: Button
        lateinit var edt_email: EditText
        lateinit var edt_password: EditText
        lateinit var edt_creditcard: EditText
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            btn_validate = findViewById(R.id.btn_validate)
            edt_email = findViewById(R.id.edt_email)
            edt_password = findViewById(R.id.edt_password)
            edt_creditcard = findViewById(R.id.edt_creditcard)
            setUpUiWidgets()
        }

        private fun setUpUiWidgets() {
            btn_validate.setOnClickListener {
                validateEmailField(edt_email)
                validatePasswordField(edt_password)
                validateCreditCardField(edt_creditcard)
            }
        }

        private fun validateCreditCardField(editText: EditText) {
            val str = editText.text.toString()
            // TODO: Validate credit card number field, not implemented
        }

        private fun validatePasswordField(editText: EditText) {
            val str = editText.text.toString()
            // TODO: Validate password field, not implemented
        }

        private fun validateEmailField(editText: EditText) {
            val str = editText.text.toString()
            // TODO: Validate email field, not implemented
        }
    }
}