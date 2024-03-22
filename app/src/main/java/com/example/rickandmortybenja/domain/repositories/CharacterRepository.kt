package com.example.rickandmortybenja.domain.repositories

import com.example.rickandmortybenja.data.Result
import com.example.rickandmortybenja.domain.model.Characters
import com.example.rickandmortybenja.domain.model.DetailCharacter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacter(page: Int): Flow<Result<List<Characters>>>

    suspend fun getDetailCharacter(id: Int): Result<DetailCharacter>
}