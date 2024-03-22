package com.example.rickandmortybenja.ui.home

import com.example.rickandmortybenja.domain.model.Characters

data class HomeState(
    val characters: List<Characters> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)