package com.fahmi.belajardoadandzikirapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahmi.belajardoadandzikirapp.databinding.FragmenArtikelBinding
import com.fahmi.belajardoadandzikirapp.model.ArtikelModel
import com.fahmi.belajardoadandzikirapp.ui.detail.DetailArtikelActivity

class ArtikelAdapter(private val listArtikel: ArrayList<ArtikelModel>)
    : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>(){
    class ViewHolder(val binding: FragmenArtikelBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmenArtikelBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listArtikel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listArtikel[position]

        Glide.with(holder.itemView.context)
            .load(data.imageArtikel)
            .into(holder.binding.imgFragment)

        holder.binding.imgFragment.setOnClickListener{
            val intenDetail = Intent(holder.itemView.context, DetailArtikelActivity::class.java)
            intenDetail.putExtra(DetailArtikelActivity.DETAIL_DESC, data.descriptionArtikel)
            intenDetail.putExtra(DetailArtikelActivity.DETAIL_TITLE, data.titleArtikel)
            intenDetail.putExtra(DetailArtikelActivity.DETAIL_IMAGE, data.imageArtikel)
            holder.itemView.context.startActivity(intenDetail)
        }
    }

}