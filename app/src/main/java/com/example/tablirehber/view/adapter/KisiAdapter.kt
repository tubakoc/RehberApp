package com.example.tablirehber.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablirehber.R
import com.example.tablirehber.model.Kisi
import com.example.tablirehber.view.viewholder.KisiViewHolder

class KisiAdapter(val context : Context, var liste : ArrayList<Kisi>, val itemClick : ((position : Int)->Unit)?, val itemLongClick : ((position : Int)->Unit)?) : RecyclerView.Adapter<KisiViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisiViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.rvc_kisi, parent, false)

        return KisiViewHolder(v, itemClick, itemLongClick)
    }

    override fun onBindViewHolder(holder: KisiViewHolder, position: Int) {
        holder.bindData(liste.get(position))
    }

    override fun getItemCount(): Int {
        return liste.size
    }
}