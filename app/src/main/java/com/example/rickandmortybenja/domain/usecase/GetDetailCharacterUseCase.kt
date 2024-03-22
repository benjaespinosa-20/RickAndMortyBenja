package com.example.rickandmortybenja.domain.usecase

import com.example.rickandmortybenja.data.Result
import com.example.rickandmortybenja.domain.model.DetailCharacter
import com.example.rickandmortybenja.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetDetailCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<DetailCharacter> {
        return repository.getDetailCharacter(id)
    }
}