package com.example.appcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val operation = intent.getStringExtra("operation") ?: "Adunare"

        val editNumber1 = findViewById<EditText>(R.id.editNumber1)
        val editNumber2 = findViewById<EditText>(R.id.editNumber2)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {
            val num1 = editNumber1.text.toString().toIntOrNull() ?: 0
            val num2 = editNumber2.text.toString().toIntOrNull() ?: 0
            val result = when (operation) {
                "Adunare" -> num1 + num2
                "Scădere" -> num1 - num2
                "Înmulțire" -> num1 * num2
                "Împărțire" -> if (num2 != 0) num1 / num2 else "Eroare: Împărțire la 0"
                else -> "Operație necunoscută"
            }
            txtResult.text = "$num1 $operation $num2 = $result"
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}