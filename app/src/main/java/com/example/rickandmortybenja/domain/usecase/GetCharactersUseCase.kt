package com.example.rickandmortybenja.domain.usecase

import com.example.rickandmortybenja.data.Result
import com.example.rickandmortybenja.domain.model.Characters
import com.example.rickandmortybenja.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacter(page)
    }
}