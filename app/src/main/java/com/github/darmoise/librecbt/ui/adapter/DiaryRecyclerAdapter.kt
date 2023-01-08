package com.github.darmoise.librecbt.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.darmoise.librecbt.R
import com.github.darmoise.librecbt.databinding.RecyclerviewDiaryItemBinding
import com.github.darmoise.librecbt.domain.ui.DiaryUiItem
import org.threeten.bp.format.DateTimeFormatter

class DiaryRecyclerAdapter : RecyclerView.Adapter<DiaryRecyclerAdapter.ViewHolder>() {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm")

    private var dataSet: List<DiaryUiItem> = listOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecyclerviewDiaryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview_diary_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = with(viewHolder.binding) {
        val item = dataSet[position]
        diaryEvent.text = item.event
        diaryThoughts.text = item.thoughts
        diaryEmotions.text = item.emotions
        diaryReaction.text = item.reaction
        diaryCognitiveDistortion.text = item.cognitiveDistortion
        diaryIntensity.text = item.intensity.toString()
        diaryRationalAnswer.text = item.rationalAnswer
        diaryTime.text = formatter.format(item.time)
    }

    fun addAll(list: List<DiaryUiItem>) {
        dataSet = list
        notifyDataSetChanged()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}