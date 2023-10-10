package com.fahmi.belajardoadandzikirapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.belajardoadandzikirapp.adapter.DzikirDoaAdapter
import com.fahmi.belajardoadandzikirapp.databinding.ActivityDzikirPetangBinding
import com.fahmi.belajardoadandzikirapp.model.DataDzikirDoa
import com.fahmi.belajardoadandzikirapp.model.DzikirDoaModel

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDzikirPetangBinding
    private val listDzikirPetang: ArrayList<DzikirDoaModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Petang"

        with(binding.rvDzikirPetang) {
            layoutManager = LinearLayoutManager(this@DzikirPetangActivity)
            adapter = DzikirDoaAdapter(listDzikirPetang)
        }

        initData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initData() {
        val dzikirPetangList = DataDzikirDoa.listDzikirPetang
        listDzikirPetang.addAll(dzikirPetangList)
    }
}