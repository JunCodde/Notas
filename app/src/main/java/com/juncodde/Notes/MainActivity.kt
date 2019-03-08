package com.juncodde.Notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.EditText
import android.widget.TextView
import com.juncodde.Notes.modelo.Nota
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_nuevaNota = findViewById<EditText>(R.id.et_nuevaNota)
        val cv_addNota = findViewById<CardView>(R.id.cv_addNota)
        val rv_notas = findViewById<RecyclerView>(R.id.rv_notas)
        val tv_sinNotas = findViewById<TextView>(R.id.tv_sinNotas)


        et_nuevaNota.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0!!.length==4){
                    mostrarBotonGuardar(cv_addNota, false)
                }else if(p0.length<4){
                    mostrarBotonGuardar(cv_addNota, true)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        cv_addNota.setOnClickListener {
            var nota = Nota(getDate(), et_nuevaNota.text.toString())
            //TODO send to firebase data base and add to RV!!
        }

    }


    fun mostrarBotonGuardar(btn:CardView, ocultar:Boolean){
        Log.d("LOL", "my Message")
        if(!ocultar){
            btn.visibility = View.VISIBLE

            ViewCompat.animate(btn)
                    .translationX(0f)
                    .translationY(100f)
                    .setDuration(500)
                    .interpolator = AccelerateDecelerateInterpolator()
        }else{

            ViewCompat.animate(btn)
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(500)
                    .interpolator = AccelerateDecelerateInterpolator()
        }
    }

    fun getDate():String{
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        return currentDate
    }

}
