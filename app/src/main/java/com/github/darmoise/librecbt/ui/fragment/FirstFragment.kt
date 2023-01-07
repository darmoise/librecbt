package com.github.darmoise.librecbt.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.darmoise.librecbt.R
import com.github.darmoise.librecbt.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {
    private val binding: FragmentFirstBinding by viewBinding()

    private val vm: FirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        buttonFirst.setOnClickListener {
            vm.start()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        onObserversCreate()
    }

    private fun onObserversCreate() {
        vm.liveDate.observe(viewLifecycleOwner) {
            Log.d(TAG, "$it");
        }
    }

    companion object {
        const val TAG: String = "FirstFragment"
    }
}