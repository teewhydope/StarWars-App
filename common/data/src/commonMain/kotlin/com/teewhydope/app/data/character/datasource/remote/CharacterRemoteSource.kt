package com.teewhydope.app.data.character.datasource.remote

import com.teewhydope.app.data.character.model.PeopleDataModel
import com.teewhydope.app.data.character.model.PersonDetailDataModel
import com.teewhydope.app.data.character.model.PersonImageDataModel

interface CharacterRemoteSource {
    suspend fun people(): PeopleDataModel

    suspend fun personDetail(id: Int): PersonDetailDataModel

    suspend fun personImageData(id: String): PersonImageDataModel

}