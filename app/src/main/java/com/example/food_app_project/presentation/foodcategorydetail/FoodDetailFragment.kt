package com.example.food_app_project.presentation.foodcategorydetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.food_app_project.R
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.databinding.FragmentFoodDetailBinding
import java.text.NumberFormat
import java.util.Locale

class FoodDetailFragment : Fragment() {

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
        fun startActivity(context: Context, foodData: Catalog) {
            val intent = Intent(context, FoodDetailFragment::class.java)
            intent.putExtra(EXTRAS_ITEM, foodData)
            context.startActivity((intent))
        }
    }
    private lateinit var binding: FragmentFoodDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentData()
    }

    private fun getArgumentData() {
        val item = arguments?.getParcelable<Catalog>(EXTRAS_ITEM)
        if (item != null) {
            setProfileData(item)
            setProfileImage(item.image)
        }
        Toast.makeText(requireContext(), item?.name, Toast.LENGTH_SHORT).show()
    }


    private fun setProfileData(item: Catalog) {
        binding.tvName.text = item.name
        binding.tvDeskripsi.text = item.description
        binding.tvPrice.text=item.price.toString()
        binding.tvIsiLokasi.text=item.location
    }

    private fun setProfileImage(imgUrl: Int?) {
        imgUrl?.let { binding.ivBannerDetail.setImageResource(it)}
    }

}





