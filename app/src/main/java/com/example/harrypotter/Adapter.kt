package com.example.harrypotter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.harrypotter.databinding.ItemCharacterBinding
import com.example.harrypotter.model.Magician
import java.text.FieldPosition

class Adapter(val context: Context, val data: ArrayList<Magician>) {

}

/*
class Adapter(val context: Context, val data: ArrayList<Magician>): BaseAdapter() {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    //Retorna el tamaño del arraylist de magos.
    override fun getCount(): Int = data.size

    //Se obtiene el ítem por medio de su posición en el arreglo.
    override fun getItem(position: Int): Any = data[position]

    //Se obtiene el identificador del elemento.
    override fun getItemId(position: Int): Long = data[position].id

    //Se manda a llamar cada vez que se utilice una vista.
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ItemCharacterBinding.inflate(inflater)

        binding.tvMagician.text = data[position].name
        binding.tvActor.text = data[position].actor


        return binding.root
    }

}*/