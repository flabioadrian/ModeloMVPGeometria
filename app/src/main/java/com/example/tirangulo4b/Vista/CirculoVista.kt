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
import com.example.tirangulo4b.Vista.MenuFiguras
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

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnPerimetro = findViewById<Button>(R.id.btnPerimetro)

        val btnregresar = findViewById<Button>(R.id.regresar)


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

        btnregresar.setOnClickListener {
            val intent = Intent(this, MenuFiguras::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun showAreaCirculo(area: Float) {
        txvRes.text = "El área del circulo es: ${area}"
    }

    override fun showPerimetroCirculo(perimetro: Float) {
        txvRes.text = "El Perimetro del circulo es: ${perimetro}"
    }

    override fun showError(smg: String) {
        txvRes.text = "Error: ${smg}"
    }
}