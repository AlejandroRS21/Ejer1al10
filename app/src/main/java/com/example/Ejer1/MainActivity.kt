// Paquete de la aplicación
package com.example.Ejer1

// Importaciones necesarias para el funcionamiento de la aplicación
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ejer1.R


// Clase principal que extiende AppCompatActivity
class MainActivity : AppCompatActivity() {
    private val PREFS_NAME= "Mis nombres"
    private val KEY_NAME= "nombre"

    // Método onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        // Ejercicio 1: Modificar el "Hola Mundo"
        val tvTitle: TextView = findViewById(R.id.tvTitle)

        // Ejercicio 2: Interacción con botones
        val btnCambiarTexto: Button = findViewById(R.id.btnCambiarTexto)

        // Ejercicio 3: Usar Toasts
        val btnMostrarToast: Button = findViewById(R.id.btnMostrarToast)

        // Ejercicio 5: Cambiar el color de fondo
        val btnRojo: Button = findViewById(R.id.btnRojo)
        val btnAzul: Button = findViewById(R.id.btnAzul)
        val btnVerde: Button = findViewById(R.id.btnVerde)
        val mainLayout: LinearLayout = findViewById(R.id.main)

        // Ejercicio 4: Navegación entre pantallas
        val btnIrSegundaPantalla: Button = findViewById(R.id.btnSecondActivity)

        // Ejercicio 6: Captura de datos con EditText
        val btnMostrarNombre: Button = findViewById(R.id.btnMostrarNombre)
        val editText: EditText = findViewById(R.id.edit_text)
        val tvNombre: TextView = findViewById(R.id.tvNombre)

        // Ejercicio 7: Cambiar entre temas claros y oscuros
        val swTema: Switch = findViewById(R.id.swTema)

        // Ejercicio 9: Guardar datos con SharedPreferences
        val editTextSharedPreferences: EditText = findViewById(R.id.editTxt)
        val tvName: TextView = findViewById(R.id.tvNameShared)
        val btnGuardarNombre: Button = findViewById(R.id.btnGuardarNombre)

        // SharedPreferences
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Ejercicio 4: Navegación entre pantallas (Intents)
        btnIrSegundaPantalla.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Ejercicio 2: Interacción con botones (Cambiar texto)
        btnCambiarTexto.setOnClickListener {
            tvTitle.text = "Texto cambiado!"
        }

        // Ejercicio 3: Usar Toasts (Mostrar mensaje)
        btnMostrarToast.setOnClickListener {
            Toast.makeText(this, "Mensaje Mostrado con éxito", Toast.LENGTH_SHORT).show()
        }

        // Ejercicio 5: Cambiar color de fondo
        btnRojo.setOnClickListener {
            mainLayout.setBackgroundColor(Color.RED)
        }
        btnAzul.setOnClickListener {
            mainLayout.setBackgroundColor(Color.BLUE)
        }
        btnVerde.setOnClickListener {
            mainLayout.setBackgroundColor(Color.GREEN)
        }

        // Ejercicio 6: Captura de datos con EditText
        btnMostrarNombre.setOnClickListener {
            val texto = editText.text.toString()
            tvNombre.text = texto
        }

        // Ejercicio 7: Cambiar entre temas claros y oscuros
        swTema.setOnCheckedChangeListener { _, estaEncendido ->
            if (estaEncendido) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // Ejercicio 9: Guardar datos con SharedPreferences
        val nombreGuardado = sharedPreferences.getString(KEY_NAME, null)
        if (nombreGuardado != null) {
            tvName.text = "$nombreGuardado"
        }

        btnGuardarNombre.setOnClickListener {
            val nombre = editTextSharedPreferences.text.toString()
            if (nombre.isNotEmpty()) {
                val editor = sharedPreferences.edit()
                editor.putString(KEY_NAME, nombre)
                editor.apply()
                tvName.text = "$nombre"
            }
        }
    }

    // Menú de opciones (Ejercicio 10)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Método para manejar las selecciones del menú (Ejercicio 10)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.configuraciones -> {
                Toast.makeText(this, "Seleccionaste Configuraciones", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.acercaDe -> {
                Toast.makeText(this, "Seleccionaste Acerca de", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
