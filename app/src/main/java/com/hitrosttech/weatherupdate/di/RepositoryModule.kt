package com.hitrosttech.weatherupdate.di

import com.hitrosttech.weatherupdate.data.repository.WeatherRepositoryImpl
import com.hitrosttech.weatherupdate.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
	
	@Binds
	@Singleton
	abstract fun bindWeatherRepository(
		weatherRepositoryImpl: WeatherRepositoryImpl
	): WeatherRepository
	
}