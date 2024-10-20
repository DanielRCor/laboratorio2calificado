package com.rivera.daniel.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroPedido : AppCompatActivity() {

    private lateinit var etNombreCliente: EditText
    private lateinit var etNumeroCliente: EditText
    private lateinit var etProductos: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etDireccion: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pedido) // Asegúrate de que el nombre del layout es correcto

        // Inicializar las vistas
        etNombreCliente = findViewById(R.id.etNombreCliente)
        etNumeroCliente = findViewById(R.id.etNumeroCliente)
        etProductos = findViewById(R.id.etProductos)
        etCiudad = findViewById(R.id.etCiudad)
        etDireccion = findViewById(R.id.etDireccion)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        // Configurar el listener del botón
        btnRegistrar.setOnClickListener {
            registrarPedido()
        }
    }

    private fun registrarPedido() {
        // Obtener los valores de los campos
        val nombreCliente = etNombreCliente.text.toString().trim()
        val numeroCliente = etNumeroCliente.text.toString().trim()
        val productos = etProductos.text.toString().trim()
        val ciudad = etCiudad.text.toString().trim()
        val direccion = etDireccion.text.toString().trim()

        // Validar los campos
        if (nombreCliente.isEmpty() || numeroCliente.isEmpty() || productos.isEmpty() ||
            ciudad.isEmpty() || direccion.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Aquí puedes agregar la lógica para guardar el pedido en tu base de datos o backend
        // Por ejemplo:
        // guardarPedidoEnBaseDeDatos(nombreCliente, numeroCliente, productos, ciudad, direccion)

        // Mostrar mensaje de éxito
        Toast.makeText(this, "Pedido registrado con éxito.", Toast.LENGTH_SHORT).show()

        // Limpiar los campos
        limpiarCampos()

        // Intentar llevar al usuario a la actividad Pedido
        val intent = Intent(this, Pedido::class.java).apply {
            putExtra("nombreCliente", nombreCliente)
            putExtra("numeroCliente", numeroCliente)
            putExtra("productos", productos)
            putExtra("direccion", direccion)
        }
        startActivity(intent)
        finish() // Finaliza esta actividad si no se necesita volver a ella
    }

    private fun limpiarCampos() {
        etNombreCliente.text.clear()
        etNumeroCliente.text.clear()
        etProductos.text.clear()
        etCiudad.text.clear()
        etDireccion.text.clear()
    }
}
