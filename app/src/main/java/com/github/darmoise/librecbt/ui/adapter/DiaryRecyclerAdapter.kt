package com.github.darmoise.librecbt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.darmoise.librecbt.R
import com.github.darmoise.librecbt.databinding.RecyclerviewDiaryItemBinding
import com.github.darmoise.librecbt.domain.ui.DiaryUiItem

class DiaryRecyclerAdapter : RecyclerView.Adapter<DiaryRecyclerAdapter.ViewHolder>() {
    private var dataSet: List<DiaryUiItem> = listOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecyclerviewDiaryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview_diary_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = with(viewHolder.binding) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val item = dataSet[position]
        textViewLarge.text = item.rationalAnswer
        textViewSmall.text = item.reaction
    }

    fun addAll(list: List<DiaryUiItem>) {
        dataSet = list
        notifyDataSetChanged()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}