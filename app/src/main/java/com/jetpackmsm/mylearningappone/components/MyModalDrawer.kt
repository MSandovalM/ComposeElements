package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetpackmsm.mylearningappone.components.model.DrawerItem

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {
    val scope = rememberCoroutineScope()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val myItems = listOf(
        DrawerItem(title = "Home", icon = Icons.Default.Home, notification = 3),
        DrawerItem(title = "Favorite", icon = Icons.Default.Favorite, notification = 4),
        DrawerItem(title = "Build", icon = Icons.Default.Build, notification = 0)
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 3.dp),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.White,
                drawerTonalElevation = 10.dp
            ) {
                //Text("Ejemplo 1", modifier = Modifier.clickable { scope.launch { drawerState.close() } })
                //Text("Ejemplo 2")
                //Text("Ejemplo 3")
                Spacer(Modifier.height(40.dp))
                myItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(item.title) },
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        badge = {
                            if (item.notification > 0) {
                                Badge(
                                    containerColor = if (selectedIndex == index) Color.White else Color.Red,
                                    contentColor = if (selectedIndex == index) Color.Red else Color.White
                                ) {
                                    Text(item.notification.toString())
                                }
                            }
                        },
                        shape = RoundedCornerShape(0),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            unselectedContainerColor = Color.White,
                            selectedTextColor = Color.Black
                        )
                    )
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.5f) // Para cambiar el alpha del color
    ) {
        content()
    }
}