package com.fahmi.belajardoadandzikirapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.belajardoadandzikirapp.adapter.DzikirDoaAdapter
import com.fahmi.belajardoadandzikirapp.databinding.ActivityDzikirPagiBinding
import com.fahmi.belajardoadandzikirapp.model.DataDzikirDoa
import com.fahmi.belajardoadandzikirapp.model.DzikirDoaModel


class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPagiBinding
    private val listDzikirPagi: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Pagi"

        with(binding.rvDzikirPagi){
            layoutManager = LinearLayoutManager(this@DzikirPagiActivity)
            adapter = DzikirDoaAdapter(listDzikirPagi)
        }

        initdata()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initdata() {
        val dzikirPagiList = DataDzikirDoa.listDzikirPagi
        listDzikirPagi.addAll(dzikirPagiList)
    }



}