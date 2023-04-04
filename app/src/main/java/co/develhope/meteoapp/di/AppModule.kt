package co.develhope.meteoapp.di

import android.content.Context
import co.develhope.meteoapp.data.ApplicationPreferences
import co.develhope.meteoapp.data.repository.PreferencesRepository
import co.develhope.meteoapp.data.repository.PreferencesRepositoryImpl
import co.develhope.meteoapp.network.NetworkProvider
import co.develhope.meteoapp.network.repository.NetworkRepository
import co.develhope.meteoapp.network.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideNetworkProvider(): NetworkProvider {
        return NetworkProvider()
    }

    @Singleton
    @Provides
    fun provideNetworkRepository(): NetworkRepository {
        return NetworkRepositoryImpl(provideNetworkProvider())
    }

    @Singleton
    @Provides
    fun provideAppPreferences(@ApplicationContext context : Context) : ApplicationPreferences {
        return ApplicationPreferences((context))
    }

    @Singleton
    @Provides
    fun providePreferencesRepository(@ApplicationContext context : Context) : PreferencesRepository{
        return PreferencesRepositoryImpl(provideAppPreferences(context))
    }


}