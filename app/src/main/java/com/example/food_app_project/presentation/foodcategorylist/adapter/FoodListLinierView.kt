package com.example.food_app_project.presentation.foodcategorylist.adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.base.ViewHolderBinder
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.databinding.ItemFoodLinierBinding
import java.text.NumberFormat
import java.util.Locale

class FoodListLinierView(
    private val binding: ItemFoodLinierBinding,
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
