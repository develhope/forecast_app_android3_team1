package co.develhope.meteoapp.di

import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.repository.NetworkRepository
import co.develhope.meteoapp.network.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNetworkProvider() : NetworkProvider {
        return NetworkProvider()
    }

    @Singleton
    @Provides
    fun provideNetworkRepository(): NetworkRepository {
        return NetworkRepositoryImpl(provideNetworkProvider())
    }
}