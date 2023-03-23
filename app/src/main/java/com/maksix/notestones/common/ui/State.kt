package com.maksix.notestones.common.ui

import com.maksix.notestones.ui.list.NoteListSmallItem

sealed class State {
    object Loading : State()
    class Content(val items: List<NoteListSmallItem>) : State()
    object Empty : State()
}
