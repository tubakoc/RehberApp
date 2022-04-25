package com.example.tablirehber.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tablirehber.bll.Bll
import com.example.tablirehber.databinding.FragmentListeBinding
import com.example.tablirehber.model.Kisi
import com.example.tablirehber.view.adapter.KisiAdapter

class FragmentHizli : Fragment() {

    lateinit var binding : FragmentListeBinding
    lateinit var Liste : ArrayList<Kisi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListeBinding.inflate(inflater)

        val lm = LinearLayoutManager(requireActivity())
        lm.orientation = LinearLayoutManager.VERTICAL
        binding.rvList.layoutManager = lm

        return binding.root
    }
    override fun onResume() {
        super.onResume()
        Liste = Bll.hizliListeGetir()
        binding.rvList.adapter = KisiAdapter(requireActivity(), Liste, ::itemClick, ::itemLongClick)
    }
    fun itemClick(position : Int)
    {
        Toast.makeText(requireActivity(), "${Liste.get(position).Telefon} Aranıyor ...", Toast.LENGTH_SHORT).show()
    }

    fun itemLongClick(position : Int)
    {
        Bll.uyariGoster(requireContext(), "Uyarı", "Kişiyi hızlı aramadan çıkarmak istiyor musunuz", "Evet", "Hayır", ::hizliAramaCikar, null, position)
    }

    fun hizliAramaCikar(position : Int?)
    {
        Bll.hizliAramaCikar(Liste.get(position!!))
        Liste = Bll.hizliListeGetir()
        binding.rvList.adapter = KisiAdapter(requireActivity(), Liste, ::itemClick, ::itemLongClick)
    }
}