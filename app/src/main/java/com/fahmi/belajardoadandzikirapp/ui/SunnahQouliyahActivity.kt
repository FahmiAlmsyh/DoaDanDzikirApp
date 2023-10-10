package com.fahmi.belajardoadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.belajardoadandzikirapp.adapter.DzikirDoaAdapter
import com.fahmi.belajardoadandzikirapp.databinding.ActivitySunnahQouliyahBinding
import com.fahmi.belajardoadandzikirapp.model.DataDzikirDoa
import com.fahmi.belajardoadandzikirapp.model.DzikirDoaModel

class SunnahQouliyahActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySunnahQouliyahBinding
    private val listQouliyah: ArrayList<DzikirDoaModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunnahQouliyahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sunnah - Sunnah Qouliyah"

        with(binding.rvQauliyahShalat){
            layoutManager = LinearLayoutManager(this@SunnahQouliyahActivity)
            adapter = DzikirDoaAdapter(listQouliyah)
        }

        initData()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initData() {
        val dzikirQouliyah = DataDzikirDoa.listQauliyah
        listQouliyah.addAll(dzikirQouliyah)
    }
}