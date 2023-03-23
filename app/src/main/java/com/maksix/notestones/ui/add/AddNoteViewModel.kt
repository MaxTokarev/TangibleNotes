package com.maksix.notestones.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksix.notestones.R
import com.maksix.notestones.domain.usecases.notes.add.AddNoteUseCase
import com.maksix.notestones.domain.usecases.notes.get.GetNoteUseCase
import com.maksix.notestones.domain.usecases.notes.update.UpdateNoteUseCase
import com.maksix.notestones.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
) : ViewModel() {

    private val _uiEvents = Channel<Event>(Channel.BUFFERED)
    val uiEvent get() = _uiEvents.receiveAsFlow()

    fun onSaveClicked(title: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (title.isBlank() || description.isBlank()) {
                _uiEvents.send(Event.Error("Please fill one of the fields"))
            } else {
                val note = Note(
                    title = title,
                    description = description,
                    backgroundColor = getRandomColor()
                )
                addNoteUseCase.execute(note)
                _uiEvents.send(Event.SuccessfullyAdded)
            }
        }
    }

    private fun getRandomColor(): Int {
        return listOf(
            R.color.carissma,
            R.color.primrose,
            R.color.petite_orchid,
            R.color.spray,
            R.color.light_wisteria
        ).random()
    }


    sealed class Event {
        object SuccessfullyAdded : Event()
        data class Error(val message: String) : Event()
    }

}
