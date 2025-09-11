package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jetpackmsm.mylearningappone.R
import com.jetpackmsm.mylearningappone.components.model.NavItem
import com.jetpackmsm.mylearningappone.components.model.NavItemPR

@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Info", Icons.Default.Info),
        NavItem("Settings", Icons.Default.Settings)
    )
    val itemList2 = listOf(
        NavItemPR("Home", painterResource(R.drawable.ic_add_24))
    ) // Solo de Ejemplo para ver si se podia usar painterResource

    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = Color.Red,
        tonalElevation = 10.dp
    ) {
        itemList.forEachIndexed { index, item ->
            EnterpriseNavigationBar(item, isSelected = index == selectedIndex) {
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.EnterpriseNavigationBar(
    navItem: NavItem,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = {
            onItemClick()
        },
        icon = {
            Icon(
                imageVector = navItem.icon,
                contentDescription = null
            )
        },
        label = { Text(navItem.name) },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.DarkGray,
            selectedIconColor = Color.White,
            selectedTextColor = Color.Black,
            indicatorColor = Color.Gray
        )
    )
}

@Composable
fun MyFirstNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_add_24),
                    contentDescription = null
                )
            },
            label = { Text("Home") },
            alwaysShowLabel = false
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_add_24),
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = Color.DarkGray,
                selectedIconColor = Color.White,
                selectedTextColor = Color.Black,
                indicatorColor = Color.Gray
            )
        )
        NavigationBarItem(
            selected = false,
            enabled = false,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_add_24),
                    contentDescription = null
                )
            },
            label = { Text("Premium") })
    }
}