package com.maksix.notestones.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maksix.notestones.R
import com.maksix.notestones.databinding.ItemNoteListSmallBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NoteListSmallItem(
    var id: Int = 0,
    var text: String,
    var createdAt: String,
    var backgroundColor: Int
) : AbstractBindingItem<ItemNoteListSmallBinding>() {

    override val type: Int
        get() = R.id.fastadapter_item_adapter

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ItemNoteListSmallBinding {
        return ItemNoteListSmallBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: ItemNoteListSmallBinding, payloads: List<Any>) {
        binding.tvDateCreated.text = createdAt
        Log.d("TAG", "bindView: $text")
        binding.tvDescription.text = text
        binding.conte.setCardBackgroundColor(backgroundColor)
    }

}