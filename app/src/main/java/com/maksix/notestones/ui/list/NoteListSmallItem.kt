package com.maksix.notestones.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.maksix.notestones.R
import com.maksix.notestones.databinding.ItemNoteListSmallBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NoteListSmallItem(
    var id: Int = 0,
    var text: String,
    var createdAt: String,
    @ColorRes var backgroundColor: Int
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
        binding.tvDescription.text = text
        binding.conte.setCardBackgroundColor(
            ContextCompat.getColor(binding.root.context, backgroundColor)
        )
    }

}
