package com.teewhydope.app.data.character.datasource.remote

import com.teewhydope.app.data.character.model.PeopleResponseApiModel
import com.teewhydope.app.data.character.model.PersonDetailResponseApiModel
import com.teewhydope.app.data.character.model.PersonImageResponseApiModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType.Application
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path

class CharacterService(private val httpClient: HttpClient) {
    suspend fun people(): PeopleResponseApiModel {

        val response = httpClient.get {
            contentType(Application.Json)

            url {
                protocol = URLProtocol.HTTPS
                host = "swapi.dev"
                path("api/people")
            }
        }

        return response.body<PeopleResponseApiModel>()
    }


    suspend fun personDetail(id: Int): PersonDetailResponseApiModel {

        val response = httpClient.get {
            contentType(Application.Json)

            url {
                protocol = URLProtocol.HTTPS
                host = "swapi.dev"
                path("api/people/$id")
            }
        }
        return response.body()
    }

    suspend fun personImageData(id: String): PersonImageResponseApiModel {
        val response = httpClient.get {
            contentType(Application.Json)

            url {
                protocol = URLProtocol.HTTPS
                host = "rawcdn.githack.com"
                path("akabab/starwars-api/0.2.1/api/id/$id.json")
            }
        }
        return response.body()
    }
}