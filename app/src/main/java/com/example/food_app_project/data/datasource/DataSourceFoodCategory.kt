package com.example.food_app_project.data.datasource

import com.example.food_app_project.R
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.data.model.Category

interface DataSourceFoodCategory {
    fun getFoodCategoryItem(): List<Category>
}
class DataSourceFoodCategoryImpl(): DataSourceFoodCategory {
    override fun getFoodCategoryItem(): List<Category> {
        return mutableListOf(
            Category(
              name = "Pizza",
                image = R.drawable.category_pizza,
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
    }
}

