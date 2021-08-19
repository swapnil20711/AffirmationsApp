package com.example.affirmationsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.affirmationsapp.adapter.ItemsAdapter
import com.example.affirmationsapp.databinding.ActivityMainBinding
import com.example.affirmationsapp.models.Affirmation

lateinit var binding: ActivityMainBinding
lateinit var list: List<Affirmation>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        setAdapter()
    }

    private fun setAdapter() {
        binding.rv.adapter = ItemsAdapter(this, list)
        binding.rv.layoutManager = LinearLayoutManager(this)
    }

    private fun initData() {
        list = DataSrc().loadAffirmations()
    }
}