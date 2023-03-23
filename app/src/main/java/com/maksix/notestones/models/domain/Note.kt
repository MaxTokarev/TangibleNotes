package com.maksix.notestones.models.domain

class Note(
    val id: Int = 0,
    val createdAt: String = "",
    val title: String,
    val description: String,
    val backgroundColor: Int
)
