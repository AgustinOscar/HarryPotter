package com.example.harrypotter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.harrypotter.databinding.ItemCharacterBinding

import com.example.harrypotter.model.Magician

class MagicianAdapter(private var context: Context, private var magicians: ArrayList<Magician>):
    RecyclerView.Adapter<MagicianAdapter.ViewHolder> (){

        //Clase para vincular el layout con la información de la API.
        class ViewHolder (view: ItemCharacterBinding): RecyclerView.ViewHolder(view.root) {
            val iv_image = view.ivCharacter
            val tv_magician = view.tvMagician
            val tv_actor = view.tvActor
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = magicians.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_magician.text = magicians[position].name
        holder.tv_actor.text = magicians[position].actor
        Glide.with(context).load(magicians[position].image).into(holder.iv_image)

        holder.itemView.setOnClickListener {
            //Para programar los elementos click del elemento del ViewHolder completo.
        }
    }


}