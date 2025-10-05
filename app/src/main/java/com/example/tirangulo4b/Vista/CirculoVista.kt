package com.example.tirangulo4b.Vista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tirangulo4b.Contrato.CirculoContract
import com.example.tirangulo4b.Presentador.CirculoPresentador
import com.example.tirangulo4b.R

class CirculoVista : AppCompatActivity(), CirculoContract.Vista {

    private lateinit var txvRes: TextView
    private lateinit var circuloPresentador: CirculoContract.Presentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_campos_circulo)

        // Elementos del triángulo
        val txtl1 = findViewById<EditText>(R.id.radioCirculo)

        val btnRectangulo = findViewById<Button>(R.id.btnRectangulo)
        val btnPentagono = findViewById<Button>(R.id.btnPentagono)
        val btnTriangulo = findViewById<Button>(R.id.btnTriangulo)

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnPerimetro = findViewById<Button>(R.id.btnPerimetro)


        txvRes = findViewById<TextView>(R.id.txtResultado)

        // Inicializar presentadores
        circuloPresentador = CirculoPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frmCirculo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listeners
        btnArea.setOnClickListener {
            val radio = txtl1.text.toString().toFloatOrNull() ?: 0f
            circuloPresentador.calcularAreaCirculo(radio)
        }

        btnPerimetro.setOnClickListener {
            val radio = txtl1.text.toString().toFloatOrNull() ?: 0f
            circuloPresentador.calcularPerimetroCirculo(radio)
        }

        btnRectangulo.setOnClickListener {
            val intent = Intent(this@CirculoVista, RectanguloVista::class.java)

            startActivity(intent)
            finish()
        }

        btnTriangulo.setOnClickListener {
            val intent = Intent(this@CirculoVista, MainActivity::class.java)

            startActivity(intent)
            finish()
        }

        btnPentagono.setOnClickListener {
            val intent = Intent(this@CirculoVista, PentagonoVista::class.java)

            startActivity(intent)
            finish()
        }
    }

    override fun showAreaCirculo(area: Float) {
        txvRes.text = "El área del Rectangulo es: ${area}"
    }

    override fun showPerimetroCirculo(perimetro: Float) {
        txvRes.text = "El área del Perimetro es: ${perimetro}"
    }

    override fun showError(smg: String) {
        txvRes.text = "Error: ${smg}"
    }
}