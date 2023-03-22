package com.maksix.notestones.domain.repositories

import com.maksix.notestones.R
import com.maksix.notestones.data.local.INotesLocalDataSource
import com.maksix.notestones.models.domain.Note
import com.maksix.notestones.models.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class NoteRepository @Inject constructor(
    override val localDataSource: INotesLocalDataSource
) : INoteRepository {
    override fun observeNotes(): Flow<List<Note>> {
        return localDataSource.observeNotes().map { noteList ->
            noteList.map { note ->
                Note(
                    note.id,
                    note.createdAt.formatToString(),
                    note.title,
                    note.description,
                    note.backgroundColor
                )
            }
        }
    }

    override suspend fun addNote(note: Note) {
        val noteEntity = NoteEntity(
            createdAt = OffsetDateTime.now(),
            title = note.title,
            description = note.description,
            backgroundColor = getRandomColor()
        )
        localDataSource.addNote(noteEntity)
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


    override suspend fun getNoteById(noteId: Int): Flow<Note> {
        return localDataSource.getNoteById(noteId).map { note ->
            Note(
                note.id,
                note.createdAt.formatToString(),
                note.title,
                note.description,
                note.backgroundColor
            )
        }
    }

    override suspend fun updateNote(note: NoteEntity) {
        localDataSource.updateNote(note)
    }

    private fun OffsetDateTime.formatToString(): String {
        return "${month.name} $dayOfMonth, $year"
    }
}