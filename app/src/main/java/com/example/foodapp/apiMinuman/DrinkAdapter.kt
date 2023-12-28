package com.example.foodapp.apiMinuman

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.ItemMealBinding

class DrinkAdapter(private val dataSet: ArrayList<Drink>) :
    RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMealBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(drink: Drink) {
            Glide.with(itemView.context)
                .load(drink.strDrinkThumb)
                .into(binding.imgMeal)
            binding.tvMealName.text=drink.strDrink
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        var binding=ItemMealBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.textView.text = dataSet[position]
        var drink=dataSet[position]
        if (drink!=null){
            viewHolder.bind(drink)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setList(newList:List<Drink>){
        dataSet.clear()
        dataSet.addAll(newList)
        notifyDataSetChanged()
    }

}