package com.example.food_app_project.presentation.foodcategorydetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.databinding.ActivityFoodDetailBinding
import java.text.NumberFormat
import java.util.Locale

class FoodDetailActivity : AppCompatActivity() {


    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
        fun startActivity(context: Context, foodData: Catalog) {
            val intent = Intent(context, FoodDetailActivity::class.java)
            intent.putExtra(EXTRAS_ITEM, foodData)
            context.startActivity((intent))
        }
    }
    private var count = 0
    private var priceItem: Double = 0.00
    private var linkToMaps: String = ""
    private val binding: ActivityFoodDetailBinding by lazy {
        ActivityFoodDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getArgumentData()
        clickCountOrder()
        clickToMaps()
    }

    private fun getArgumentData() {
        intent.extras?.getParcelable <Catalog>(EXTRAS_ITEM)?. let{
            setProfileData(it)
            setProfileImage(it.image)
        }
    }

    private fun setProfileData(item: Catalog) {
        binding.tvName.text = item.name
        binding.tvDeskripsi.text = item.description
        binding.tvPrice.text=item.price.formatToIDRCurrency()
        binding.tvIsiLokasi.text=item.location
        binding.btnDetailOrder.text= "Tambah ke Kerangjang ->" +item.price.formatToIDRCurrency()
        priceItem = item.price
        linkToMaps = item.location
    }
    private fun setProfileImage(imgUrl: Int?) {
        imgUrl?.let { binding.ivBannerDetail.setImageResource(it)}
    }

    private fun clickCountOrder(){
        binding.ivOrderUp.setOnClickListener {
            count += 1
            binding.tvCountOrder.text = count.toString()
            updateBtnDetailOrderText(priceItem)
        }
        binding.ivOrderDown.setOnClickListener {
            if (count > 0){
                binding.tvCountOrder.text = count.toString()
                updateBtnDetailOrderText(priceItem)
                count -= 1
            }else{
                Toast.makeText(this, "minimal pemesanan", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun clickToMaps(){
        binding.tvIsiLokasi.setOnClickListener {
            val location =  linkToMaps
            val intentUri = Uri.parse("geo:0,0?q=$location")
            val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
            mapIntent.setPackage("com.google.android.apps.maps") // Pastikan aplikasi Google Maps terinstall
            startActivity(mapIntent)
        }

    }





    fun Double.formatToIDRCurrency(): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        return formatter.format(this)
    }

    private fun updateBtnDetailOrderText(price: Double) {
        val totalPrice = price * count
        binding.btnDetailOrder.text = "Tambah ke Keranjang -> ${totalPrice.formatToIDRCurrency()}"
    }

}