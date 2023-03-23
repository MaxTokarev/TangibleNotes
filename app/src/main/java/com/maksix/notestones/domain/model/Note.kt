package com.maksix.notestones.domain.model

class Note(
    val id: Int = 0,
    val createdAt: String = "",
    val title: String,
    val description: String,
    val backgroundColor: Int
)
