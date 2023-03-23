package com.maksix.notestones.ui.edit

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.maksix.notestones.R
import com.maksix.notestones.databinding.FragmentAddNoteBinding
import com.maksix.notestones.di.viewModels
import com.maksix.notestones.other.delegates.argument
import com.maksix.notestones.other.delegates.viewBinding
import com.maksix.notestones.other.extension.hideKeyboard
import com.maksix.notestones.other.extension.onBackPressed
import com.maksix.notestones.other.extension.showToast
import com.maksix.notestones.ui.add.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import com.maksix.notestones.other.extension.launchWhenStarted
import javax.inject.Inject

@AndroidEntryPoint
class EditNoteFragment : Fragment(R.layout.fragment_add_note) {

    @Inject
    lateinit var viewModelFactory: EditNoteViewModel.Factory
    private val viewModel: EditNoteViewModel by viewModels {
        viewModelFactory.create(noteId)
    }

    private val binding by viewBinding(FragmentAddNoteBinding::bind)
    private val noteId by argument(ARG_NOTE_ID, -1)

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

        viewModel.note
            .onEach {
                binding.etTitle.setText(it.title)
                binding.etDescription.setText(it.description)
            }
            .launchWhenStarted(viewLifecycleOwner.lifecycleScope)

        viewModel.uiEvent
            .onEach(::handleEvents)
            .launchWhenStarted(viewLifecycleOwner.lifecycleScope)
    }

    private fun handleEvents(event: AddNoteViewModel.Event) {
        when (event) {
            AddNoteViewModel.Event.SuccessfullyAdded -> onBackPressed()
            is AddNoteViewModel.Event.Error -> showToast(event.message)
        }
        hideKeyboard()
    }

    private fun getTitle(): String = binding.etTitle.text.toString()
    private fun getDescription(): String = binding.etDescription.text.toString()

    companion object {
        const val ARG_NOTE_ID = "note_id"

        fun newInstance(noteId: Int) = EditNoteFragment().apply {
            arguments = bundleOf(ARG_NOTE_ID to noteId)
        }
    }
}
