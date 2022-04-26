package com.example.tablirehber.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablirehber.R
import com.example.tablirehber.bll.Bll
import com.example.tablirehber.databinding.ActivityMainBinding
import com.example.tablirehber.databinding.CustomTabBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Bll.kisilerOlustur()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerOlustur()

        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())

        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        {
                tab, position ->

        }.attach()


        tabOlustur()
    }

    private fun tabOlustur() {
        var tab = CustomTabBinding.inflate(layoutInflater)
        tab.tvBaslik.text = "Hızlı"
        binding.tabLayout.getTabAt(0)!!.setCustomView(tab.root)

        tab = CustomTabBinding.inflate(layoutInflater)
        tab.tvBaslik.text = "Tüm"
        binding.tabLayout.getTabAt(1)!!.setCustomView(tab.root)

        tab = CustomTabBinding.inflate(layoutInflater)
        tab.tvBaslik.text = "Kara Liste"
        binding.tabLayout.getTabAt(2)!!.setCustomView(tab.root)

    }
    private fun viewPagerOlustur() {
        val adapter = ViewPagerAdapter(this)

        adapter.fragmentEkle(FragmentHizli())
        adapter.fragmentEkle(FragmentTum())
        adapter.fragmentEkle(FragmentKaraListe())

        binding.viewPager.adapter = adapter
    }

    internal class ViewPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity)
    {
        private val fragmentList = ArrayList<Fragment>()

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList.get(position)
        }

        fun fragmentEkle(fragment : Fragment)
        {
            fragmentList.add(fragment)
        }
    }
}