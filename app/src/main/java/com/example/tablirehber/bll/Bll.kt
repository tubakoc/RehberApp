package com.example.tablirehber.bll

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.tablirehber.model.Kisi

object Bll {

    private var TumKisiler = ArrayList<Kisi>()

    fun kisilerOlustur()
    {
        TumKisiler.add(Kisi(1,"a 1","s 1","23224"))
        TumKisiler.add(Kisi(2,"a 2","s 2","23224"))
        TumKisiler.add(Kisi(3,"a 3","s 3","23224"))
        TumKisiler.add(Kisi(4,"a 4","s 4","23224"))
        TumKisiler.add(Kisi(5,"a 5","s 5","23224"))
        TumKisiler.add(Kisi(6,"a 6","s 6","23224"))
        TumKisiler.add(Kisi(7,"a 7","s 7","23224"))
        TumKisiler.add(Kisi(8,"a 8","s 8","23224"))
    }

    fun hizliListeGetir() : ArrayList<Kisi>
    {
        return TumKisiler.filter {kisi -> kisi.Hizli} as ArrayList<Kisi>
    }

    fun tumListeGetir() : ArrayList<Kisi>
    {
        return TumKisiler.filter {kisi -> !kisi.KaraListe} as ArrayList<Kisi>
    }
    fun karaListeGetir() : ArrayList<Kisi>
    {
        return TumKisiler.filter {kisi -> kisi.KaraListe} as ArrayList<Kisi>
    }

    fun uyariGoster(context : Context, title : String, message : String, possitiveButtonText : String, negativeButtonText : String, possitiveAction : ((position : Int?)->Unit)?, negativeAction : ((position : Int?)->Unit)?, position : Int? )
    {
        val adb = AlertDialog.Builder(context)
        adb.setTitle(title)
            .setMessage(message)
            .setPositiveButton(possitiveButtonText, {dialog, which ->
                possitiveAction?.invoke(position)
            })
            .setNegativeButton(negativeButtonText, {dialog, which ->
                negativeAction?.invoke(position)
            })
            .show()
    }

    fun hizliAramaEkle(kisi: Kisi)
    {
        kisi.Hizli= true
    }

    fun karaListeEkle(kisi: Kisi)
    {
        kisi.KaraListe = true
    }

    fun hizliAramaCikar(kisi: Kisi)
    {
        kisi.Hizli= false
    }

    fun karaListeCikar(kisi: Kisi)
    {
        kisi.KaraListe = false
    }
}