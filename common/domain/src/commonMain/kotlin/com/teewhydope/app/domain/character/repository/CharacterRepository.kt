package com.teewhydope.app.domain.character.repository

import com.teewhydope.app.domain.character.model.PeopleDomainModel
import com.teewhydope.app.domain.character.model.PersonDetailDomainModel

interface CharacterRepository {
    suspend fun people(): PeopleDomainModel

    suspend fun personDetail(id: Int): PersonDetailDomainModel
}