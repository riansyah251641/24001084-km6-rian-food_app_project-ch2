package com.example.food_app_project.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.databinding.ItemListOfPizzaBinding
import com.example.food_app_project.model.Catalog
import java.text.NumberFormat
import java.util.Locale

fun Double.formatToIDRCurrency(): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    return formatter.format(this)
}


class CatalogAdapter() : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>(), Parcelable {
    private val data = mutableListOf<Catalog>()

    constructor(parcel: Parcel) : this() {
    }

    fun submitData(items : List<Catalog>){
        data.addAll(items)
    }

    class CatalogViewHolder(private val binding: ItemListOfPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Catalog) {
            binding.tvMenuName.text = item.name
            binding.ivMenuImage.setImageResource(item.image)
            binding.tvMenuPrice.text = item.price.formatToIDRCurrency()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            ItemListOfPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CatalogAdapter> {
        override fun createFromParcel(parcel: Parcel): CatalogAdapter {
            return CatalogAdapter(parcel)
        }

        override fun newArray(size: Int): Array<CatalogAdapter?> {
            return arrayOfNulls(size)
        }
    }
}