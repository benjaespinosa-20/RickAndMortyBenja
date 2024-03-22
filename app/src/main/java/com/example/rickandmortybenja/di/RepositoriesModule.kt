package com.example.rickandmortybenja.di

import com.example.rickandmortybenja.data.repositories.CharacterRepositoryImpl
import com.example.rickandmortybenja.domain.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}