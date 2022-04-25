package com.example.tablirehber.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tablirehber.bll.Bll
import com.example.tablirehber.databinding.FragmentListeBinding
import com.example.tablirehber.model.Kisi
import com.example.tablirehber.view.adapter.KisiAdapter

class FragmentKaraListe : Fragment() {
    lateinit var binding : FragmentListeBinding
    lateinit var Liste : ArrayList<Kisi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        Liste = Bll.karaListeGetir()
        binding.rvList.adapter = KisiAdapter(requireActivity(), Liste, null, ::itemLongClick)

    }

    fun itemLongClick(position : Int)
    {
        Bll.uyariGoster(requireContext(), "Uyarı", "Kişiyi kara listeden çıkarmak istiyor musunuz", "Evet", "Hayır", ::karaListeCikar, null, position)
    }

    fun karaListeCikar(position : Int?)
    {
        Bll.karaListeCikar(Liste.get(position!!))

        Liste = Bll.karaListeGetir()
        binding.rvList.adapter = KisiAdapter(requireActivity(), Liste, null, ::itemLongClick)
    }
}