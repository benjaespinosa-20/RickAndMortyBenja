package com.example.rickandmortybenja.data.source.remote

import com.example.rickandmortybenja.data.source.remote.dto.CharactersDto
import com.example.rickandmortybenja.data.source.remote.dto.DetailCharacterDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRickAndMorty {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharactersDto

    @GET("character/{id}")
    suspend fun getDetailCharacter(@Path("id") id: Int): DetailCharacterDto
}