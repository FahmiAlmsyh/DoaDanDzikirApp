package com.fahmi.belajardoadandzikirapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fahmi.belajardoadandzikirapp.databinding.ActivityDetailArtikelBinding

class DetailArtikelActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailArtikelBinding

    companion object {
        const val DETAIL_DESC = "detail_desc"
        const val DETAIL_TITLE = "detail_title"
        const val DETAIL_IMAGE = "detail_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Artikel"

        val title = intent.getStringExtra(DETAIL_TITLE)
        val description = intent.getStringExtra(DETAIL_DESC)
        val image = intent.getIntExtra(DETAIL_IMAGE, 0)
        binding.apply {
            tvDetailTitle.text = title
            tvDetailDesc.text = description
            Glide.with(this@DetailArtikelActivity)
                .load(image)
                .into(imgDetail)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}