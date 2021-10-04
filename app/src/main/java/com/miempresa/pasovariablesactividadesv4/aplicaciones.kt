package com.miempresa.pasovariablesactividadesv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_aplicaciones.*

class aplicaciones : AppCompatActivity() {
    var datosactividad02:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aplicaciones)
        val values = arrayOf(
            "TikTok",
            "Instagram",
            "Snapchat",
            "WhatsApp Messenger",
            "Messenger",
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,android.R.id.text1,
            values
        )
        listadeaplicaciones.adapter = adapter

        listadeaplicaciones.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemValue = listadeaplicaciones.getItemAtPosition(position) as String
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("parametro",itemValue)
                intent.putExtra("datosactividad01",datosactividad02)
                this.finish()
                startActivity(intent)
            }
        val bundle :Bundle ?=intent.extras
        if(bundle!=null){
            datosactividad02 = bundle.getString("seleccionados").toString()
        }
    }
}