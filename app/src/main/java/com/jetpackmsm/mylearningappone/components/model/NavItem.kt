package com.jetpackmsm.mylearningappone.components.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val name: String, val icon: ImageVector)

data class NavItemPR(val name: String, val iconPR: Painter)
