package com.github.darmoise.librecbt.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.darmoise.librecbt.R
import com.github.darmoise.librecbt.databinding.FragmentDiaryBinding
import com.github.darmoise.librecbt.domain.state.DiaryState
import com.github.darmoise.librecbt.ui.adapter.DiaryRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryFragment : Fragment(R.layout.fragment_diary) {
    private val binding: FragmentDiaryBinding by viewBinding()

    private val vm: DiaryViewModel by viewModels()

    private val adapter = DiaryRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        vm.state.observe(viewLifecycleOwner, ::setState)
    }

    private fun setRecyclerView() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun setListeners() = with(binding) {
        swipeRefreshLayout.setOnRefreshListener {
            vm.updateDiary()
        }
    }

    private fun setState(state: DiaryState) = with(binding) {
        recyclerView.isVisible = (state is DiaryState.Content)
        errorView.isVisible = (state is DiaryState.Error || state is DiaryState.Empty)
        swipeRefreshLayout.isRefreshing = (state is DiaryState.Loading)

        when (state) {
            is DiaryState.Content -> {
                adapter.addAll(state.items)
            }
            DiaryState.Empty -> {
                setError(R.string.no_diary_entries)
            }
            is DiaryState.Error -> {
                setError(R.string.diary_error)
            }
            else -> Unit
        }
    }

    private fun setError(resId: Int) = with(binding) {
        errorView.text = getString(resId)
    }

    companion object {
        const val TAG: String = "DiaryFragment"
    }
}