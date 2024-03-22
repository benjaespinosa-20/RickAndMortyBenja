package com.example.rickandmortybenja.domain.model

import com.example.rickandmortybenja.data.source.remote.dto.Location
import com.example.rickandmortybenja.data.source.remote.dto.Origin

data class DetailCharacter(
    val gender: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
)
