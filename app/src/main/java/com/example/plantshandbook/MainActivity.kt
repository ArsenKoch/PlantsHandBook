package com.example.plantshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.img, R.drawable.img_1,
        R.drawable.img_2, R.drawable.img_3, R.drawable.img_4,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcVeiw.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcVeiw.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 4) index = 0
                val plant = Plant(imageIdList[index],"Plant $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}