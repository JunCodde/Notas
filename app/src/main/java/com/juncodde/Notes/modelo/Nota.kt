package com.juncodde.Notes.modelo

import java.util.ArrayList

class Nota(var nombre: String?, var fecha: String?) {
    var owner: String = ""
    var content: String = ""
    var notas: ArrayList<Nota>? = null

    fun addNota(nota: Nota) {
        this.notas!!.add(nota)
    }
}
