package com.maksix.notestones.ui.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.maksix.notestones.R
import com.maksix.notestones.common.ui.State
import com.maksix.notestones.databinding.FragmentNoteListBinding
import com.maksix.notestones.other.Navigator
import com.maksix.notestones.other.delegates.viewBinding
import com.maksix.notestones.other.extension.launchWhenStarted
import com.maksix.notestones.ui.add.AddNoteFragment
import com.maksix.notestones.ui.detail.NoteDetailFragment
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NotesListFragment : Fragment(R.layout.fragment_note_list) {

    private val viewModel: NoteListViewModel by viewModels()

    private val binding by viewBinding(FragmentNoteListBinding::bind)

    private val itemAdapter = ItemAdapter<NoteListSmallItem>()
    private val fastAdapter = FastAdapter.Companion.with(itemAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNotes.adapter = fastAdapter
        binding.rvNotes.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        fastAdapter.onClickListener = { _, _, noteListSmallItem, _ ->
            val fragment = NoteDetailFragment.newInstance(noteListSmallItem.id)
            Navigator(parentFragmentManager).routeTo(fragment)
            false
        }

        binding.fabAddNote.setOnClickListener {
            val fragment = AddNoteFragment()
            Navigator(parentFragmentManager).routeTo(fragment)
        }

        viewModel.uiState
            .onEach { handleStates(it) }
            .launchWhenStarted(viewLifecycleOwner.lifecycleScope)
    }

    private fun handleStates(state: State) {
        when (state) {
            State.Empty -> {
                hideLoading()
                binding.rvNotes.isVisible = false
                binding.tvEmptyNotes.isVisible = true
            }

            State.Loading -> showLoading()
            is State.Content -> {
                hideLoading()
                binding.rvNotes.isVisible = true
                binding.tvEmptyNotes.isVisible = false
                FastAdapterDiffUtil.calculateDiff(itemAdapter, state.items).apply {
                    FastAdapterDiffUtil[itemAdapter] = this
                }
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            rvNotes.isVisible = false
            tvEmptyNotes.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun hideLoading() {
        with(binding) {
            rvNotes.isVisible = true
            progressBar.isVisible = false
        }
    }
}
