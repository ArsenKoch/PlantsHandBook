package com.example.plantshandbook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantshandbook.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantViewHolder>() {

    private val plantList = ArrayList<Plant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PlantItemBinding.inflate(inflater, parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plantList[position]
        with(holder.binding) {
            ivPlants.setImageResource(plant.imageId)
            tvTitle.text = plant.title
        }
    }

    override fun getItemCount(): Int = plantList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}