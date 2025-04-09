package com.teewhydope.app.di.character

import com.teewhydope.app.data.character.datasource.remote.CharacterRemoteDataSource
import com.teewhydope.app.data.character.datasource.remote.CharacterRemoteSource
import com.teewhydope.app.data.character.datasource.remote.CharacterService
import com.teewhydope.app.data.character.mapper.CharacterDataToDomainExceptionMapper
import com.teewhydope.app.data.character.mapper.PeopleDataToDomainModelMapper
import com.teewhydope.app.data.character.mapper.PeopleResponseApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.PersonDetailDataToDomainModelMapper
import com.teewhydope.app.data.character.mapper.PersonDetailResponseApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.PersonImageResponseApiToDataModelMapper
import com.teewhydope.app.data.character.repository.CharacterDataRepository
import com.teewhydope.app.domain.character.repository.CharacterRepository
import org.koin.dsl.module


val providedCharacterDataModule = module {
    includes(
        providesCharacterService(),
        providesCharacterRemoteSource(),
        providesCharacterRepository(),
        providesCharacterDataToDomainExceptionMapper(),
        providesPeopleDataToDomainModelMapper(),
        providesPeopleResponseApiToDataModelMapper(),
        providesPersonDetailDataToDomainModelMapper(),
        providesPersonDetailResponseApiToDataModelMapper(),
        providesPersonImageResponseApiToDataModelMapper()
    )
}

fun providesCharacterService() = module {
    single { CharacterService(get()) }
}


fun providesCharacterRemoteSource() = module {
    single<CharacterRemoteSource> { CharacterRemoteDataSource(get(), get(), get(), get()) }
}

fun providesCharacterRepository() = module {
    single<CharacterRepository> { CharacterDataRepository(get(), get(), get()) }
}


fun providesCharacterDataToDomainExceptionMapper() = module {
    single { CharacterDataToDomainExceptionMapper() }
}


fun providesPersonImageResponseApiToDataModelMapper() =
    module { single { PersonImageResponseApiToDataModelMapper() } }


fun providesPeopleDataToDomainModelMapper() =
    module { single { PeopleDataToDomainModelMapper(get()) } }


fun providesPeopleResponseApiToDataModelMapper() =
    module {
        single { PeopleResponseApiToDataModelMapper(get()) }
    }


fun providesPersonDetailDataToDomainModelMapper() = module {
    single { PersonDetailDataToDomainModelMapper() }
}


fun providesPersonDetailResponseApiToDataModelMapper() = module {
    single { PersonDetailResponseApiToDataModelMapper() }
}