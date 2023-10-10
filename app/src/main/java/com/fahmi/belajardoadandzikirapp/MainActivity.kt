package com.fahmi.belajardoadandzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.fahmi.belajardoadandzikirapp.databinding.ActivityMainBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.fahmi.belajardoadandzikirapp.adapter.ArtikelAdapter
import com.fahmi.belajardoadandzikirapp.model.ArtikelModel
import com.fahmi.belajardoadandzikirapp.ui.DzikirDanDoaHarianActivity
import com.fahmi.belajardoadandzikirapp.ui.DzikirPagiDanPetangActivity
import com.fahmi.belajardoadandzikirapp.ui.DzikirSetiapSaatActivity
import com.fahmi.belajardoadandzikirapp.ui.SunnahQouliyahActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var slideIndicator: Array<ImageView?>
    private lateinit var sunnahQouliyah: LinearLayout
    private lateinit var dzikirSetiapSaat: LinearLayout
    private lateinit var dzikirDoaHarian: LinearLayout
    private lateinit var dzikirPagiPetang: LinearLayout
    private val listArtikel: ArrayList<ArtikelModel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }


            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        setDataArtikel()
        setUpViewPagerArtikel()
        setView()

        sunnahQouliyah = findViewById(R.id.ll_dzikir_doa_shalat)

        sunnahQouliyah.setOnClickListener{
            val intent = Intent(this@MainActivity, SunnahQouliyahActivity::class.java)
            startActivity(intent)
        }

        dzikirSetiapSaat = findViewById(R.id.ll_dzikir_setiap_saat)

        dzikirSetiapSaat.setOnClickListener{
            val intent = Intent(this@MainActivity, DzikirSetiapSaatActivity::class.java)
            startActivity(intent)
        }

        dzikirDoaHarian = findViewById(R.id.ll_dzikir_doa_harian)

        dzikirDoaHarian.setOnClickListener{
            val intent = Intent(this@MainActivity, DzikirDanDoaHarianActivity::class.java)
            startActivity(intent)
        }

        dzikirPagiPetang = findViewById(R.id.ll_dzikir_pagi_petang)

        dzikirPagiPetang.setOnClickListener{
            val intent = Intent(this@MainActivity, DzikirPagiDanPetangActivity::class.java)
            startActivity(intent)
        }



    }

    private fun setView() {
        // setup view artikel
        binding.apply {
            vpArtikel.adapter = ArtikelAdapter(listArtikel)
            vpArtikel.registerOnPageChangeCallback(slidingCallback)
        }

    }

    private fun setDataArtikel() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (data in titleArtikel.indices) {
            val artikel = ArtikelModel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.llSliderDots

        slideIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )


            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}