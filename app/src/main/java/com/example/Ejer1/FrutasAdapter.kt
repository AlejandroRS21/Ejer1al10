package com.example.Ejer1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejer1.R

class FrutasAdapter(private val frutasList: List<String>) :
    RecyclerView.Adapter<FrutasAdapter.FrutasViewHolder>() {

    class FrutasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvFruta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrutasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FrutasViewHolder(view)
    }

    override fun onBindViewHolder(holder: FrutasViewHolder, position: Int) {
        holder.textView.text = frutasList[position]
    }

    override fun getItemCount() = frutasList.size
}
