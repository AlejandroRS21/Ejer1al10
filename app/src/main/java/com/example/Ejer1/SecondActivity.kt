package com.example.Ejer1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer1.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutSeconActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rvFrutas)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = FrutasAdapter(frutas)
    }

    private val frutas = listOf(
        "Manzana", "Banana", "Cereza", "Dátil", "Elderberry",
        "Fresa", "Uva", "Kiwi", "Limón", "Mango"
    )


}