package com.example.food_app_project.presentation.foodcategorylist.adapter

import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.base.ViewHolderBinder
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.databinding.ItemFoodGridBinding
import java.text.NumberFormat
import java.util.Locale

class FoodListGridView(
    private val binding: ItemFoodGridBinding,
    private val listener: OnItemClickedListener<Catalog>
): RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Catalog>{

    fun Double.formatToIDRCurrency(): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        return formatter.format(this)
    }
    override fun bind(item: Catalog) {
        item.let {
            binding.ivFoodPhoto.setImageResource(it.image)
            binding.tvFoodName.text = it.name
            binding.tvFoodPrice.text = it.price.formatToIDRCurrency()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }


}
