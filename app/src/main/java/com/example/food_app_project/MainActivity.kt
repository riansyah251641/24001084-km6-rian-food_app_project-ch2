package com.example.food_app_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuAdapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.food_app_project.adapter.CatalogAdapter
import com.example.food_app_project.adapter.CategoryAdapter
import com.example.food_app_project.databinding.ActivityMainBinding
import com.example.food_app_project.model.Catalog
import com.example.food_app_project.model.Category

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = CategoryAdapter()
    private val catalogAdapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCategoryList()
        setMenuList()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setMenuList() {
        val data = listOf(
            Catalog(
                image = R.drawable.item_pizza_caprize,
                name = "Caprize Pizza",
                price = 250000.0
            ),
            Catalog(
                image = R.drawable.item_pizza_delano,
                name = "Delano Pizza",
                price = 300000.0
            ),
            Catalog(
                image = R.drawable.item_pizza_drougno,
                name = "Drougno Pizza",
                price = 100000.0
            ),
            Catalog(
                image = R.drawable.item_pizza_melerlo,
                name = "Melerno Pizza",
                price = 50000.0
            ),
            Catalog(
                image = R.drawable.item_pizza_pedaso,
                name = "Pedaso Pizza",
                price = 450000.0
            ),
            Catalog(
                image = R.drawable.item_pizza_mediterranean,
                name = "Mediterranean Pizza",
                price = 500000.0
            ),
        )
        binding.rvListOfPizza.apply {
            adapter = this@MainActivity.catalogAdapter
        }
        catalogAdapter.submitData(data)
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


