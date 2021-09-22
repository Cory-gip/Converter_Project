package com.example.project1_converter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project1_converter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { convert() }
    }

    /* This method is the conversion method. It checks to see if the value entered by the user is an
    * Int, and then inserts nothing if it is null. If it is an Int, then it will convert it.
    */
    fun convert() {
        val stringInTextField = binding.valueToConvert.text.toString()
        val valueToConvert = stringInTextField.toIntOrNull()
        if (valueToConvert == null) {
            binding.conversionResult.text = ""
            return
        }
        val selectedId = binding.conversionOptions.checkedRadioButtonId
        val convertedValue = when (selectedId) {
            R.id.fahrenheit_to_celsius -> ((valueToConvert - 32) * (5.toDouble() / 9)).toInt()
            R.id.celsius_to_fahrenheit -> ((valueToConvert * (9.toDouble() / 5)) + 32).toInt()
            else -> valueToConvert * 0.84
        }

        binding.conversionResult.text = getString(R.string.conversion_result, convertedValue.toString())
    }
}