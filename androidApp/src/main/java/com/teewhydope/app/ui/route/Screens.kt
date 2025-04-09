package com.teewhydope.app.ui.route

import kotlinx.serialization.Serializable


@Serializable
object People

@Serializable
data class PersonDetail(val id: Int?)

@Serializable
object Starships


@Serializable
data class StarshipDetail(val highlightedIpAddress: String?)

