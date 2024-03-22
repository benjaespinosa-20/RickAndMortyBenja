package com.example.rickandmortybenja.ui.detail

import com.example.rickandmortybenja.domain.model.DetailCharacter

data class DetailState(
    val character: DetailCharacter? = null,
    val isLoading: Boolean = false
)