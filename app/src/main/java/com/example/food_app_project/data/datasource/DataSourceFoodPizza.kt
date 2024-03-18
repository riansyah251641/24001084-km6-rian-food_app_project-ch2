package com.example.food_app_project.data.datasource

import com.example.food_app_project.R
import com.example.food_app_project.data.model.Catalog


class DataSourceFoodPizza(): DataSourceFoodCatalog{
    override fun getFoodCatalogItem(): List<Catalog> {
        return mutableListOf(
            Catalog(
                name = "Caprize Pizza",
                category = "pizza",
                description = "Pizza lezat dengan saus tomat segar, keju mozarella, dan topping pilihan.",
                price = 250000.0,
                location = "Jl. Raya Darmo No.79 A, Keputran, Kec. Tegalsari, Surabaya, Jawa Timur 60265",
                image = R.drawable.item_pizza_caprize,
            ),
            Catalog(
                category = "pizza",
                name = "Delano Pizza",
                description = "Pizza premium dengan saus tomat khas, keju mozarella, dan topping segar",
                price = 300000.0,
                location = "Jl. Jenderal Basuki Rachmat No.25-31, Embong Kaliasin, Kec. Genteng, Surabaya, Jawa Timur 60271",
                image = R.drawable.item_pizza_delano,
            ),
            Catalog(
                category = "pizza",
                name = "Drougno Pizza",
                description = "Pizza premium dengan saus tomat spesial, keju mozarella impor, dan topping unik.",
                price = 150000.0,
                location = "Jl. Raya Jemursari No.136, Kendangsari, Kec. Tenggilis Mejoyo, Surabaya, Jawa Timur 60292",
                image = R.drawable.item_pizza_drougno,
            ),
            Catalog(
                category = "pizza",
                name = "Mantappo Pizza",
                description = "Pizza premium dengan saus tomat spesial, keju mozarella impor, dan topping unik.",
                price = 150000.0,
                location = "Jl. Dr. Ir. H. Soekarno No.Kel, Kedung Baruk, Kec. Rungkut, Surabaya, Jawa Timur 60298",
                image = R.drawable.item_pizza_drougno,
            ),
            Catalog(
                category = "pizza",
                name = "Melerno Pizza",
                description = "Pizza premium dengan saus tomat khas, keju mozzarella, dan daging sapi panggang",
                price = 200000.0,
                location = "Jl. Kenjeran No.455, Gading, Kec. Tambaksari, Surabaya, Jawa Timur 60134",
                image = R.drawable.item_pizza_melerlo,
            ),
            Catalog(
                category = "pizza",
                name = "Pedaso Pizza",
                description = "Pizza lezat dengan saus tomat segar, keju cheddar, dan potongan sosis.",
                price = 220000.0,
                location = "Jl. Raya Dharma Husada Indah No.115 E, Mojo, Kec. Gubeng, Surabaya, Jawa Timur 60285",
                image =  R.drawable.item_pizza_pedaso,
            ),
            Catalog(
                category = "pizza",
                name = "Mediterranean Pizza",
                description = "Pizza eksotis dengan saus pesto, keju feta, dan olive kalamata.",
                price = 180000.0,
                location = "Jl. Raya Darmo No.79 A, Keputran, Kec. Tegalsari, Surabaya, Jawa Timur 60265 ",
                image =  R.drawable.item_pizza_mediterranean,
            ),
        )
    }
}