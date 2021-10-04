package com.miempresa.pasovariablesactividadesv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtseleccionados.isFocusable = false
        val values = arrayOf(
            "Juegos",
            "Aplicaciones",
            "Cursos",
            "Profesores",
            "Cerrar"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,android.R.id.text1,
            values
        )
        listadejuegos.adapter = adapter

        listadejuegos.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                if(position == 0){
                    var seleccionados = txtseleccionados.text.toString()
                    var intent = Intent(this,juegos::class.java)
                    intent.putExtra("seleccionados",seleccionados)
                    this.finish()
                    startActivity(intent)
                }
                if(position == 1){
                    var seleccionados = txtseleccionados.text.toString()
                    var intent = Intent(this,aplicaciones::class.java)
                    intent.putExtra("seleccionados",seleccionados)
                    this.finish()
                    startActivity(intent)
                }
                if(position == 2){
                    var seleccionados = txtseleccionados.text.toString()
                    var intent = Intent(this,cursos::class.java)
                    intent.putExtra("seleccionados",seleccionados)
                    this.finish()
                    startActivity(intent)
                }
                if(position == 3){
                    var seleccionados = txtseleccionados.text.toString()
                    var intent = Intent(this,profesores::class.java)
                    intent.putExtra("seleccionados",seleccionados)
                    this.finish()
                    startActivity(intent)
                }
                if(position == 4){
                   var intent = Intent(this,cerrar::class.java)
                    this.finish()
                    startActivity(intent)
                }

            }

        val bundle: Bundle ?=intent.extras
        if(bundle!=null){
            val recibidos = bundle.getString("parametro").toString()
            val datosactividad01 = bundle.getString("datosactividad01").toString()

            txtseleccionados.setText(datosactividad01+recibidos+"\n")
        }
    }
}