package com.teewhydope.app.ios.data.dependencyinjection.authentication

import com.teewhydope.app.data.character.datasource.remote.CharacterRemoteDataSource
import com.teewhydope.app.data.character.datasource.remote.CharacterService
import com.teewhydope.app.data.character.mapper.CharacterDataToDomainExceptionMapper
import com.teewhydope.app.data.character.mapper.LoginDataToDomainModelMapper
import com.teewhydope.app.data.character.mapper.LoginRequestDataToApiModelMapper
import com.teewhydope.app.data.character.mapper.LoginRequestDomainToDataModelMapper
import com.teewhydope.app.data.character.mapper.LoginResponseApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.SmartSaverTransactionApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.SmartSaverTransactionDataToDomainModelMapper
import com.teewhydope.app.data.character.mapper.UserDataApiToDataModelMapper
import com.teewhydope.app.data.character.mapper.UserDataToDomainModelMapper
import com.teewhydope.app.data.character.repository.CharacterDataRepository
import com.teewhydope.app.domain.character.repository.CharacterRepository
import io.ktor.client.HttpClient

class AuthenticationRepositoryProvider(
    private val networkClient: HttpClient,
) {

    val characterRepository: CharacterRepository = CharacterDataRepository(
        characterRemoteSource = makeAuthenticationRemoteSource(),
        loginRequestDomainToDataModelMapper = makeLoginRequestDomainToDataModelMapper(),
        loginDataToDomainModelMapper = makeLoginDataToDomainModelMapper(),
        characterDataToDomainExceptionMapper = makeAuthenticationDataToDomainExceptionMapper()

    )

    private fun makeAuthenticationRemoteSource() =
        CharacterRemoteDataSource(
            characterService = makeAuthenticationService(),
            loginRequestDataToApiModelMapper = makeLoginRequestDataToApiModelMapper(),
            loginResponseApiToDataModelMapper = makeLoginResponseApiToDataModelMapper()
        )

    private fun makeAuthenticationService() =
        CharacterService(httpClient = networkClient)

    private fun makeAuthenticationDataToDomainExceptionMapper() =
        CharacterDataToDomainExceptionMapper()

    private fun makeSmartSaverTransactionApiToDataModelMapper() =
        SmartSaverTransactionApiToDataModelMapper()

    private fun makeUserDataApiToDataModelMapper() =
        UserDataApiToDataModelMapper()

    private fun makeLoginResponseApiToDataModelMapper() =
        LoginResponseApiToDataModelMapper(
            makeUserDataApiToDataModelMapper(),
            makeSmartSaverTransactionApiToDataModelMapper()
        )

    private fun makeSmartSaverTransactionDataToDomainModelMapper() =
        SmartSaverTransactionDataToDomainModelMapper()

    private fun makeUserDataToDomainModelMapper() =
        UserDataToDomainModelMapper()

    private fun makeLoginDataToDomainModelMapper() =
        LoginDataToDomainModelMapper(
            makeUserDataToDomainModelMapper(),
            makeSmartSaverTransactionDataToDomainModelMapper()
        )

    private fun makeLoginRequestDataToApiModelMapper() =
        LoginRequestDataToApiModelMapper()

    private fun makeLoginRequestDomainToDataModelMapper() = LoginRequestDomainToDataModelMapper()
}