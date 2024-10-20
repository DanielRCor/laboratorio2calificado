package com.rivera.daniel.myapplication2
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rivera.daniel.myapplication2.databinding.ActivityEjercicio01Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuramos el listener para el botón Mostrar
        binding.showButton.setOnClickListener {
            // Mostrar la caja verde
            binding.greenBox.visibility = View.VISIBLE
        }

        // Configuramos el listener para el botón Ocultar
        binding.hideButton.setOnClickListener {
            // Ocultar la caja verde
            binding.greenBox.visibility = View.GONE
        }
    }
}

