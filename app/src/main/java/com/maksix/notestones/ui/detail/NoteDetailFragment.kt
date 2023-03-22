package com.maksix.notestones.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.maksix.notestones.R
import com.maksix.notestones.databinding.FragmentNoteDetailBinding
import com.maksix.notestones.di.viewModels
import com.maksix.notestones.other.Navigator
import com.maksix.notestones.other.delegates.argument
import com.maksix.notestones.other.delegates.viewBinding
import com.maksix.notestones.other.extension.onBackPressed
import com.maksix.notestones.ui.add.AddNoteFragment
import com.maksix.notestones.ui.edit.EditNoteFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import ru.datumgroup.smartlighting.other.extension.launchWhenStarted
import javax.inject.Inject

@AndroidEntryPoint
class NoteDetailFragment : Fragment(R.layout.fragment_note_detail) {

    @Inject
    lateinit var viewModelFactory: NoteDetailViewModel.Factory
    private val viewModel: NoteDetailViewModel by viewModels { viewModelFactory.create(noteId) }

    private val binding by viewBinding(FragmentNoteDetailBinding::bind)

    private val noteId: Int by argument(ARG_NOTE_ID, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ibBack.setOnClickListener { onBackPressed() }
        binding.ibEdit.setOnClickListener {
            val fragment = EditNoteFragment.newInstance(noteId)
            Navigator(parentFragmentManager).addFragment(fragment)
        }

        viewModel.note
            .onEach { note ->
                with(binding) {
                    tvDateCreated.text = note.createdAt
                    tvDescription.text = note.description
                    tvTittle.text = note.title
                }
            }
            .launchWhenStarted(viewLifecycleOwner.lifecycleScope)
    }

    companion object {
        const val ARG_NOTE_ID = "note_id"
        fun newInstance(noteId: Int) = NoteDetailFragment().apply {
            arguments = bundleOf(ARG_NOTE_ID to noteId)
        }
    }
}