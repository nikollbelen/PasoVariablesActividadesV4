package com.miempresa.pasovariablesactividadesv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cerrar.*
import android.content.Intent
import  android.view.View
import  android.app.AlertDialog
import android.content.DialogInterface


class cerrar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerrar)
        regresarmenu.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        exit.setOnClickListener(){
            var closeButton = findViewById(R.id.exit) as Button
            var builder = AlertDialog.Builder(this)
            closeButton.setOnClickListener(View.OnClickListener {
                builder.setTitle("Salida")
                builder.setMessage("¿Quieres salir?")
                    .setCancelable(false)
                    .setPositiveButton("Si", DialogInterface.OnClickListener { dialog, id -> finish() })
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                val alert: AlertDialog = builder.create()
                alert.show()
            })
        }


    }

}