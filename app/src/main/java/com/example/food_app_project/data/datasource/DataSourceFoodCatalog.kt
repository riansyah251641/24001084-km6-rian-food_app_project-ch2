package com.example.food_app_project.data.datasource

import com.example.food_app_project.R
import com.example.food_app_project.data.model.Catalog

interface DataSourceFoodCatalog {
    fun getFoodCatalogItem(): List<Catalog>
}