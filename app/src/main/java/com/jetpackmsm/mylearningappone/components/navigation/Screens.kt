package com.jetpackmsm.mylearningappone.components.navigation

import com.jetpackmsm.mylearningappone.components.navigation.examples.model.SettingsModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: Boolean)

@Serializable
data class Settings(val settingsModel: SettingsModel)
