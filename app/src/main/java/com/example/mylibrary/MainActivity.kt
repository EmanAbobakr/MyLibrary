package com.example.mylibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.validatetor.ValidateTor

class MainActivity : ComponentActivity() {

    lateinit var btn_validate : Button
    lateinit var edt_email : EditText
    lateinit var edt_password : EditText
    lateinit var edt_creditcard : EditText

    private lateinit var validateTor: ValidateTor
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

        // Initialize validatetor instance
        validateTor = ValidateTor()

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
        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (!validateTor.validateCreditCard(str)) {
            editText.error = "Invalid Credit Card number!"
        } else {
            Toast.makeText(this, "Valid Credit Card Number!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validatePasswordField(editText: EditText) {
        val str = editText.text.toString()
        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (validateTor.isAtleastLength(str, 8)
            && validateTor.hasAtleastOneDigit(str)
            && validateTor.hasAtleastOneUppercaseCharacter(str)
            && validateTor.hasAtleastOneSpecialCharacter(str)) {
            Toast.makeText(this, "Valid Password!", Toast.LENGTH_SHORT).show()
        } else {
            editText.error = "Password needs to be a minimum length of 8 characters and should have at least 1 digit, 1 upppercase letter and 1 special character "
        }

    }

    private fun validateEmailField(editText: EditText) {
        val str = editText.text.toString()
        if (validateTor.isEmpty(str)) {
            editText.error = "Field is empty!"
        }

        if (!validateTor.isEmail(str)) {
            editText.error = "Invalid Email"
        } else {
            Toast.makeText(this, "Valid Email!", Toast.LENGTH_SHORT).show()
        }

    }
}