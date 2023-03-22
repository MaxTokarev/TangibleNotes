package com.maksix.notestones.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.maksix.notestones.R
import com.maksix.notestones.databinding.FragmentAddNoteBinding
import com.maksix.notestones.other.delegates.viewBinding
import com.maksix.notestones.other.extension.hideKeyboard
import com.maksix.notestones.other.extension.onBackPressed
import com.maksix.notestones.other.extension.showToast
import com.maksix.notestones.ui.add.AddNoteViewModel.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import ru.datumgroup.smartlighting.other.extension.launchWhenStarted
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteFragment : Fragment(R.layout.fragment_add_note) {

    private val viewModel: AddNoteViewModel by viewModels()

    private val binding by viewBinding(FragmentAddNoteBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnSave.setOnClickListener {
                viewModel.onSaveClicked(
                    getTitle(),
                    getDescription()
                )
            }
            ibBack.setOnClickListener { requireActivity().onBackPressed() }
        }

        viewModel.uiEvent
            .onEach(::handleEvents)
            .launchWhenStarted(viewLifecycleOwner.lifecycleScope)
    }

    private fun handleEvents(event: Event) {
        when (event) {
            Event.SuccessfullyAdded -> onBackPressed()
            is Event.Error -> showToast(event.message)
        }
        hideKeyboard()
    }

    private fun getTitle(): String = binding.etTitle.text.toString()
    private fun getDescription(): String = binding.etDescription.text.toString()

}