package com.example.rickandmortybenja.data.repositories

import com.example.rickandmortybenja.data.Result
import com.example.rickandmortybenja.data.source.remote.ApiRickAndMorty
import com.example.rickandmortybenja.data.source.remote.dto.toDetailCharacter
import com.example.rickandmortybenja.data.source.remote.dto.toListCharacters
import com.example.rickandmortybenja.domain.model.Characters
import com.example.rickandmortybenja.domain.model.DetailCharacter
import com.example.rickandmortybenja.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiRickAndMorty
): CharacterRepository {
    override fun getCharacter(page: Int): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(
                message = "Error",
                data = null
            ))
        } catch (e: IOException) {
            emit(Result.Error(
                message = "Error Internet",
                data = null
            ))
        }
    }

    override suspend fun getDetailCharacter(id: Int): Result<DetailCharacter> {
        val response = try {
            api.getDetailCharacter(id)
        } catch (e: Exception) {
            return Result.Error("error")
        }
        return Result.Success(response.toDetailCharacter())
    }
}