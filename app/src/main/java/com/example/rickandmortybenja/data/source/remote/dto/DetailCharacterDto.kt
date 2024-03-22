package com.example.rickandmortybenja.data.source.remote.dto

import com.example.rickandmortybenja.domain.model.DetailCharacter

data class DetailCharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun DetailCharacterDto.toDetailCharacter(): DetailCharacter {
    return DetailCharacter(
        gender = gender,
        location = location,
        origin = origin,
        species = species,
        status = status,
        type = type
    )
}
