package com.example.food_app_project.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food_app_project.R
import com.example.food_app_project.presentation.adapter.CategoryAdapter
import com.example.food_app_project.databinding.ActivityMainBinding
import com.example.food_app_project.data.model.Category

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCategoryList()

    }

    private fun setCategoryList() {
        val data = listOf(
            Category(
                image = R.drawable.category_pizza,
                name = "Pizza"
            ),
            Category(
                image = R.drawable.category_hamburger,
                name = "Hamburger"
            ),
            Category(
                image = R.drawable.category_hotdog,
                name = "Hot Dog"
            ),
            Category(
                image = R.drawable.category_ramen,
                name = "Ramen"
            ),
            Category(
                image = R.drawable.category_salad,
                name = "Salad"
            ),
            Category(
                image = R.drawable.category_pizza,
                name = "Pizza"
            ),
            Category(
                image = R.drawable.category_hamburger,
                name = "Hamburger"
            ),
            Category(
                image = R.drawable.category_hotdog,
                name = "Hot Dog"
            ),
        )
        binding.rvListOfCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }
}


