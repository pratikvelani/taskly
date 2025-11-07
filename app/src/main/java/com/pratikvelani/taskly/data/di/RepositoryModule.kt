package com.pratikvelani.taskly.data.di

import com.pratikvelani.taskly.data.repository.TaskRepository
import com.pratikvelani.taskly.data.repository.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsRepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository
}
