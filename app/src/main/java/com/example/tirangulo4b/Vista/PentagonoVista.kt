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
import com.example.tirangulo4b.Contrato.PentagonoContract
import com.example.tirangulo4b.Vista.MenuFiguras
import com.example.tirangulo4b.Presentador.PentagonoPresentador
import com.example.tirangulo4b.R

class PentagonoVista : AppCompatActivity(), PentagonoContract.Vista {

    private lateinit var txvRes: TextView
    private lateinit var pentagonoPresentador: PentagonoContract.Presentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout_campos_pentagono)

        // Elementos del triángulo
        val txtl1 = findViewById<EditText>(R.id.ladoPentagono)
        val txtl2 = findViewById<EditText>(R.id.apotemaPentagono)

        val btnArea = findViewById<Button>(R.id.btnArea)
        val btnPerimetro = findViewById<Button>(R.id.btnPerimetro)
        val btnregresar = findViewById<Button>(R.id.regresar)


        txvRes = findViewById<TextView>(R.id.txtResultado)

        // Inicializar presentadores
        pentagonoPresentador = PentagonoPresentador(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frmPentagono)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listeners
        btnArea.setOnClickListener {
            val base = txtl1.text.toString().toFloatOrNull() ?: 0f
            val altura = txtl2.text.toString().toFloatOrNull() ?: 0f
            pentagonoPresentador.calcularAreaPentagono(base, altura)
        }

        btnPerimetro.setOnClickListener {
            val base = txtl2.text.toString().toFloatOrNull() ?: 0f
            val altura = txtl2.text.toString().toFloatOrNull() ?: 0f
            pentagonoPresentador.calcularPerimetroPentagono(base)
        }

        btnregresar.setOnClickListener {
            val intent = Intent(this, MenuFiguras::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun showAreaPentagono(area: Float) {
        txvRes.text = "El área del Pentagono es: ${area}"
    }

    override fun showPerimetroPentagono(perimetro: Float) {
        txvRes.text = "El Perimetro del pentagono es: ${perimetro}"
    }

    override fun showError(smg: String) {
        txvRes.text = "Error: ${smg}"
    }
}