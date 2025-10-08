package com.example.tirangulo4b.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tirangulo4b.R

class MenuFiguras : AppCompatActivity() {

    private lateinit var spinnerFiguras: Spinner
    private lateinit var btnAceptar: Button
    private var figuraSeleccionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_figuras)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerFiguras = findViewById(R.id.spinnerFiguras)
        btnAceptar = findViewById(R.id.btnAceptar)

        configurarSpinner()

        configurarBoton()
    }

    private fun configurarSpinner() {
        val figuras = arrayOf("Triángulo", "Rectángulo", "Círculo", "Pentágono")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, figuras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFiguras.adapter = adapter

        spinnerFiguras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                figuraSeleccionada = figuras[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                figuraSeleccionada = ""
            }
        }
    }

    private fun configurarBoton() {
        btnAceptar.setOnClickListener {
            when (figuraSeleccionada) {
                "Triángulo" -> {
                    val intent = Intent(this, TrianguloVista::class.java)
                    startActivity(intent)
                    finish()
                }
                "Rectángulo" -> {
                    val intent = Intent(this, RectanguloVista::class.java)
                    startActivity(intent)
                    finish()
                }
                "Círculo" -> {
                    val intent = Intent(this, CirculoVista::class.java)
                    startActivity(intent)
                    finish()
                }
                "Pentágono" -> {
                    val intent = Intent(this, PentagonoVista::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}