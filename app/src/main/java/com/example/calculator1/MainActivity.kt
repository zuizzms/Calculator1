package com.example.calculator1

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var textInputEditText1: TextInputEditText
    private lateinit var textInputEditText2: TextInputEditText
    private lateinit var spinner: Spinner
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        textInputEditText1 = findViewById(R.id.textInputEditText)
        textInputEditText2 = findViewById(R.id.textInputEditText2)
        spinner = findViewById(R.id.spinner)
        calculateButton = findViewById(R.id.calculate_button)
        resultTextView = findViewById(R.id.result)

        // Populate spinner with operator choices
        val operatorChoices = listOf("+", "-", "*", "/", "%")
        val operatorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operatorChoices)
        operatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = operatorAdapter

        // Set click listener for the calculate button
        calculateButton.setOnClickListener {
            // Get input values
            val input1 = textInputEditText1.text.toString().toDoubleOrNull() ?: 0.0
            val input2 = textInputEditText2.text.toString().toDoubleOrNull() ?: 0.0
            val selectedOperator = spinner.selectedItem.toString()

            // Perform calculation based on the selected operator
            val result = when (selectedOperator) {
                "+" -> input1 + input2
                "-" -> input1 - input2
                "*" -> input1 * input2
                "/" -> if (input2 != 0.0) input1 / input2 else "Divide by zero not allowed"
                "%" -> if (input2 != 0.0) input1 % input2 else "Mod by zero not allowed"
                else -> "Enter valid input"
            }

            // Display the result
            resultTextView.text = "$result"
        }
    }
}
