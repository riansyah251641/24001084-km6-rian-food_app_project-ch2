package com.example.food_app_project.presentation.foodcategorylist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.food_app_project.R.id
import com.example.food_app_project.R
import com.example.food_app_project.data.datasource.DataSourceFoodCatalog
import com.example.food_app_project.data.datasource.DataSourceFoodCategory
import com.example.food_app_project.data.datasource.DataSourceFoodCategoryImpl
import com.example.food_app_project.data.datasource.DataSourceFoodPizza
import com.example.food_app_project.data.model.Catalog
import com.example.food_app_project.databinding.FragmentFoodCategoryListBinding
import com.example.food_app_project.presentation.adapter.CategoryAdapter
import com.example.food_app_project.presentation.foodcategorydetail.FoodDetailActivity
import com.example.food_app_project.presentation.foodcategorydetail.FoodDetailFragment
import com.example.food_app_project.presentation.foodcategorylist.adapter.FoodListAdapter
import com.example.food_app_project.presentation.foodcategorylist.adapter.OnItemClickedListener
import java.text.NumberFormat
import java.util.Locale

class FoodCategoryListFragment : Fragment() {
    private lateinit var binding: FragmentFoodCategoryListBinding
    private var adapter: FoodListAdapter? = null
    private val dataSource: DataSourceFoodCatalog by lazy { DataSourceFoodPizza() }
    private val dataSourceCatalog: DataSourceFoodCategory by lazy { DataSourceFoodCategoryImpl() }
    private var isUsingGridMode: Boolean = false
    private val categoryAdapter = CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodCategoryListBinding.inflate(layoutInflater,container,false)
        return binding.root
        return inflater.inflate(R.layout.fragment_food_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindFoodList(isUsingGridMode)
        setClickAction()
    }
    private fun setClickAction(){
        binding.ivChangeMode.setOnClickListener {
            isUsingGridMode =!isUsingGridMode
            setIconMode(isUsingGridMode)
            bindFoodList(isUsingGridMode)
        }

    }

    private fun setIconMode(typeMode: Boolean){
        binding.ivChangeMode.setImageResource(if (typeMode) R.drawable.iv_icon_list else R.drawable.ic_window)
    }
    private  fun bindFoodList(typeMode: Boolean){
        val listMode = if (typeMode) FoodListAdapter.MODE_GRID else FoodListAdapter.MODE_LIST
        adapter = FoodListAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Catalog>{
                override fun onItemClicked(item: Catalog){
                    navigateToDetail(item)
                }
            }
        )
        binding.rvListFood.apply {
            adapter = this@FoodCategoryListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if(typeMode) 2 else 1)
        }
        adapter?.submitData(dataSource.getFoodCatalogItem())

        binding.rvListOfCategory.apply {
            adapter = this@FoodCategoryListFragment.categoryAdapter
        }
        categoryAdapter.submitData(dataSourceCatalog.getFoodCategoryItem())
    }



// using navigation
   /* private fun navigateToDetail(item: Catalog) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(FoodDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_foodCategoryListFragment_to_foodDetailFragment, bundle)
    }*/

//    using intents for activity
private fun navigateToDetail(item: Catalog) {
    FoodDetailActivity.startActivity(
        requireContext(), Catalog(
            item.category,
            item.name,
            item.description,
            item.price,
            item.location,
            item.image,
        )
    )
}
}
