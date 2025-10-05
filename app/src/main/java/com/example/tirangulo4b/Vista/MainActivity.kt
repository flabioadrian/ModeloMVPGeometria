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
import com.example.tirangulo4b.Contrato.TrianguloContract
import com.example.tirangulo4b.Presentador.TrianguloPresentador
import com.example.tirangulo4b.R

class MainActivity : AppCompatActivity(), TrianguloContract.Vista {

    private lateinit var txvRes: TextView
    private lateinit var trianguloPresentador: TrianguloContract.Presentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Elementos del triángulo
        val txtl1 = findViewById<EditText>(R.id.lado1)
        val txtl2 = findViewById<EditText>(R.id.lado2)
        val txtl3 = findViewById<EditText>(R.id.lado3)

        val btnRectangulo = findViewById<Button>(R.id.btnRectangulo)
        val btnCirculo = findViewById<Button>(R.id.btnCirculo)
        val btnPentagono = findViewById<Button>(R.id.btnPentagono)

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnPerimetro = findViewById<Button>(R.id.btnPerimetro)
        val btnTipo = findViewById<Button>(R.id.btnTipo)

        txvRes = findViewById<TextView>(R.id.txtResultado)

        // Inicializar presentadores
        trianguloPresentador = TrianguloPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listeners
        btnPerimetro.setOnClickListener {
            val l1 = txtl1.text.toString().toFloatOrNull() ?: 0f
            val l2 = txtl2.text.toString().toFloatOrNull() ?: 0f
            val l3 = txtl3.text.toString().toFloatOrNull() ?: 0f
            trianguloPresentador.perimetro(l1, l2, l3)
        }

        btnArea.setOnClickListener {
            val l1 = txtl1.text.toString().toFloatOrNull() ?: 0f
            val l2 = txtl2.text.toString().toFloatOrNull() ?: 0f
            val l3 = txtl3.text.toString().toFloatOrNull() ?: 0f
            trianguloPresentador.area(l1, l2, l3)
        }

        btnTipo.setOnClickListener {
            val l1 = txtl1.text.toString().toFloatOrNull() ?: 0f
            val l2 = txtl2.text.toString().toFloatOrNull() ?: 0f
            val l3 = txtl3.text.toString().toFloatOrNull() ?: 0f
            trianguloPresentador.tipo(l1, l2, l3)
        }

        btnRectangulo.setOnClickListener {
            val intent = Intent(this@MainActivity, RectanguloVista::class.java)

            startActivity(intent)
            finish()
        }

        btnCirculo.setOnClickListener {
            val intent = Intent(this@MainActivity, CirculoVista::class.java)

            startActivity(intent)
            finish()
        }

        btnPentagono.setOnClickListener {
            val intent = Intent(this@MainActivity, PentagonoVista::class.java)

            startActivity(intent)
            finish()
        }
    }

    // Métodos del triángulo
    override fun showArea(area: Float) {
        txvRes.text = "El área del triángulo es: ${area}"
    }

    override fun showPerimetro(perimetro: Float) {
        txvRes.text = "El perímetro del triángulo es: ${perimetro}"
    }

    override fun showTipo(tipo: String) {
        txvRes.text = "El triángulo es: ${tipo}"
    }

    override fun showError(smg: String) {
        txvRes.text = "Error: ${smg}"
    }
}