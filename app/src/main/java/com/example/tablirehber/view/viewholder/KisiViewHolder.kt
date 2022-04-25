package com.example.tablirehber.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tablirehber.R
import com.example.tablirehber.model.Kisi


class KisiViewHolder(itemView : View, itemClick : ((position : Int)->Unit)?, itemLongClick : ((position : Int)->Unit)?) : RecyclerView.ViewHolder(itemView)
{
    var tvAdSoyad : TextView
    var tvTelefon : TextView
    var ivHizli : ImageView

    init {
        tvAdSoyad = itemView.findViewById(R.id.tvAdSoyad)
        tvTelefon = itemView.findViewById(R.id.tvTelefon)
        ivHizli = itemView.findViewById(R.id.ivHizli)

        if (itemClick != null)
            itemView.setOnClickListener { itemClick!!(adapterPosition) }

        if (itemLongClick != null)
            itemView.setOnLongClickListener {
                itemLongClick!!(adapterPosition)
                return@setOnLongClickListener false
            }
    }

    fun bindData(kisi : Kisi)
    {
        tvAdSoyad.text = kisi.Ad + " " + kisi.Soyad
        tvTelefon.text = kisi.Telefon

        ivHizli.visibility = if (kisi.Hizli) View.VISIBLE else View.INVISIBLE

    }
}