package com.example.decisionmaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.Random
import com.google.android.material.appbar.MaterialToolbar



class MainActivity : AppCompatActivity() {
    private lateinit var decisionValue: EditText
    private lateinit var valuesLabel: TextView
    private lateinit var resultLabel: TextView
    private val entrees = mutableListOf<String>() // seznam jako vlastnost aktivity

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decisionValue = findViewById(R.id.decisionValue)
        valuesLabel = findViewById(R.id.valuesLabel)
        resultLabel = findViewById(R.id.resultLabel)

        val buttonAdd: ImageButton = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener { addValue() }

        val clearButton: Button = findViewById(R.id.clearButton)
        clearButton.setOnClickListener { clearValue() }

        val chooseButton: Button = findViewById(R.id.chooseButton)
        chooseButton.setOnClickListener { chooseValue() }
    }

    @SuppressLint("SetTextI18n")
    private fun chooseValue() { // pokud je seznam prázdný, vypíše se zpráva. Jinak se náhodně vybere hodnota ze seznamu
        if (entrees.isEmpty()) {
            resultLabel.text = "Seznam je prázdný!"
        } else {
            val random = Random()
            val randomIndex = random.nextInt(entrees.size)
            resultLabel.text = entrees[randomIndex]
        }
    }

    private fun clearValue() { // funkce vymaže vše ze seznamu
        entrees.clear()
        valuesLabel.text = ""
        resultLabel.text = ""
    }

    private fun addValue() {
        val input_value = decisionValue.text.toString()
        if (input_value.isEmpty()) {
            Toast.makeText(this, "Zadej hodnotu!", Toast.LENGTH_SHORT).show() // pokud je vstup prázdný, vypíše se zpráva
            return
        } else {
            entrees.add(input_value) // přidání nové hodnoty k existujícímu seznamu
            valuesLabel.text = entrees.joinToString("\n") // vypsání seznamu
            decisionValue.setText("") // vymazat obsah decisionValue
        }
    }
    }