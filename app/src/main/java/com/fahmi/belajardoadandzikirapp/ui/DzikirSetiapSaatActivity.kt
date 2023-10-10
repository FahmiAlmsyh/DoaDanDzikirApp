package com.fahmi.belajardoadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.belajardoadandzikirapp.adapter.DzikirDoaAdapter
import com.fahmi.belajardoadandzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import com.fahmi.belajardoadandzikirapp.model.DataDzikirDoa
import com.fahmi.belajardoadandzikirapp.model.DzikirDoaModel

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirSetiapSaatBinding
    private val listDzikirSetiapSaat: ArrayList<DzikirDoaModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Setiap Saat"

        with(binding.rvDzikirSetiapSaat){
            layoutManager = LinearLayoutManager(this@DzikirSetiapSaatActivity)
            adapter = DzikirDoaAdapter(listDzikirSetiapSaat)
        }


        initData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }



    private fun initData() {
        val dzikirSetiapSaat = DataDzikirDoa.listDzikir
        listDzikirSetiapSaat.addAll(dzikirSetiapSaat)
    }
}