package com.fahmi.belajardoadandzikirapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.fahmi.belajardoadandzikirapp.R
import com.fahmi.belajardoadandzikirapp.ui.detail.DzikirPagiActivity
import com.fahmi.belajardoadandzikirapp.ui.detail.DzikirPetangActivity

class DzikirPagiDanPetangActivity : AppCompatActivity() {

    private lateinit var btnMovePagi: ImageButton
    private lateinit var btnMovePetang: ImageButton
    private lateinit var dzikirPagi: CardView
    private lateinit var dzikirPetang: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dzikir_pagi_dan_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Pagi & Petang"

        btnMovePagi = findViewById(R.id.img_btn_dzikir_pagi)

        btnMovePagi.setOnClickListener{
            val intent = Intent(this@DzikirPagiDanPetangActivity, DzikirPagiActivity::class.java)
            startActivity(intent)
        }

        btnMovePetang = findViewById(R.id.img_btn_dzikir_petang)

        btnMovePetang.setOnClickListener{
            val intent = Intent(this@DzikirPagiDanPetangActivity, DzikirPetangActivity::class.java)
            startActivity(intent)
        }

        dzikirPagi = findViewById(R.id.cv_dzikir_pagi)

        dzikirPagi.setOnClickListener{
            val intent = Intent(this@DzikirPagiDanPetangActivity, DzikirPagiActivity::class.java)
            startActivity(intent)
        }

        dzikirPetang = findViewById(R.id.cv_dzikir_petang)

        dzikirPetang.setOnClickListener{
            val intent = Intent(this@DzikirPagiDanPetangActivity, DzikirPetangActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}