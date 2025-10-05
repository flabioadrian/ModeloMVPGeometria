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
import com.example.tirangulo4b.Contrato.RectanguloContract
import com.example.tirangulo4b.Presentador.RectanguloPresentador
import com.example.tirangulo4b.R

class RectanguloVista : AppCompatActivity(), RectanguloContract.Vista {

    private lateinit var txvRes: TextView
    private lateinit var rectanguloPresentador: RectanguloContract.Presentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_campos_rectangulo)

        // Elementos del triángulo
        val txtl1 = findViewById<EditText>(R.id.baseRectangulo)
        val txtl2 = findViewById<EditText>(R.id.alturaRectangulo)

        val btnPentagono = findViewById<Button>(R.id.btnPentagono)
        val btnCirculo = findViewById<Button>(R.id.btnCirculo)
        val btnTriangulo = findViewById<Button>(R.id.btnTriangulo)

        val btnArea = findViewById<Button>(R.id.btnAreaCuadrado)
        val btnPerimetro = findViewById<Button>(R.id.btnPerimetroCuadrado)
        val btnTipo = findViewById<Button>(R.id.btnVerificar)


        txvRes = findViewById<TextView>(R.id.txtResultado)

        // Inicializar presentadores
        rectanguloPresentador = RectanguloPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rectangulo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnTipo.setOnClickListener {
            val l1 = txtl1.text.toString().toFloatOrNull() ?: 0f
            val l2 = txtl2.text.toString().toFloatOrNull() ?: 0f
            rectanguloPresentador.esUnCuadrado(l1, l2)
        }

        // Listeners del cuadrado
        btnArea.setOnClickListener {
            val base = txtl1.text.toString().toFloatOrNull() ?: 0f
            val altura = txtl2.text.toString().toFloatOrNull() ?: 0f
            rectanguloPresentador.calcularAreaRectangulo(base, altura)
        }

        btnPerimetro.setOnClickListener {
            val base = txtl2.text.toString().toFloatOrNull() ?: 0f
            val altura = txtl2.text.toString().toFloatOrNull() ?: 0f
            rectanguloPresentador.calcularPerimetroRectangulo(base, altura)
        }

        btnCirculo.setOnClickListener {
            val intent = Intent(this@RectanguloVista, CirculoVista::class.java)

            startActivity(intent)
            finish()
        }

        btnTriangulo.setOnClickListener {
            val intent = Intent(this@RectanguloVista, MainActivity::class.java)

            startActivity(intent)
            finish()
        }

        btnPentagono.setOnClickListener {
            val intent = Intent(this@RectanguloVista, PentagonoVista::class.java)

            startActivity(intent)
            finish()
        }
    }

    override fun showTipo(tipo: String) {
        txvRes.text = "La figura es un: ${tipo}"
    }

    override fun showAreaRectangulo(area: Float) {
        txvRes.text = "El área del Rectangulo es: ${area}"
    }

    override fun showPerimetroRectangulo(perimetro: Float) {
        txvRes.text = "El área del Perimetro es: ${perimetro}"
    }

    override fun showError(smg: String) {
        txvRes.text = "Error: ${smg}"
    }
}