package com.fahmi.belajardoadandzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.belajardoadandzikirapp.R
import com.fahmi.belajardoadandzikirapp.adapter.DzikirDoaAdapter
import com.fahmi.belajardoadandzikirapp.databinding.ActivityDzikirDanDoaHarianBinding
import com.fahmi.belajardoadandzikirapp.model.DzikirDoaModel

class DzikirDanDoaHarianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirDanDoaHarianBinding
    private val listDzikir: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirDanDoaHarianBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir & Doa Harian"
        setContentView(binding.root)

        with(binding.rvDzikirSetiapSaat){
            layoutManager = LinearLayoutManager(this@DzikirDanDoaHarianActivity)
            adapter = DzikirDoaAdapter(listDzikir)
        }


        getData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }



    private fun getData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (i in desc.indices){
            val dzikir = DzikirDoaModel(
                desc[i],
                lafaz[i],
                terjemah[i],
            )
            listDzikir.add(dzikir)
        }
    }
}