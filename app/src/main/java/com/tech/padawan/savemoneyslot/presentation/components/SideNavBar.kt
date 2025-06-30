package com.tech.padawan.savemoneyslot.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tech.padawan.savemoneyslot.R
import com.tech.padawan.savemoneyslot.presentation.navigation.Screen
import com.tech.padawan.savemoneyslot.ui.theme.BlueBg
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SideNavMenu(
    screenName: String,
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = BlueBg
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    SideNavBarHeader({scope.launch { drawerState.close() }})
                    HorizontalDivider()

                    NavigationDrawerItem(
                        label = { Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Home", style = MaterialTheme.typography.titleSmall)
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.home_icon),
                                contentDescription = "Home Icon",
                                modifier = Modifier.size(20.dp)
                            )
                        } },
                        selected = false,
                        onClick = { navController.navigate(Screen.Home.route) }
                    )
                    NavigationDrawerItem(
                        label = { Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Transactions", style = MaterialTheme.typography.titleSmall)
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.transaction_icon),
                                contentDescription = "Transaction Icon",
                                modifier = Modifier.size(25.dp)
                            )
                        } },
                        selected = false,
                        onClick = { navController.navigate(Screen.Transactions.route) }
                    )
                    NavigationDrawerItem(
                        label = { Row (modifier = Modifier.padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically){
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "Categories", style = MaterialTheme.typography.titleSmall)
                        } },
                        selected = false,
                        onClick = { /* Handle click */ }
                    )
                    NavigationDrawerItem(
                        label = { Row (verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Goals", style = MaterialTheme.typography.titleSmall)
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                painter = painterResource(id = R.drawable.pixel_star),
                                contentDescription = "Pixel Star",
                                modifier = Modifier.size(20.dp)
                            )
                        } },
                        selected = false,
                        onClick = { /* Handle click */ }
                    )


                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    NavigationDrawerItem(
                        label = { Text("Help and feedback") },
                        selected = false,
                        icon = { Icon(Icons.Rounded.Info, contentDescription = null, tint = Color.White) },
                        onClick = { /* Handle click */ },
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                Header(
                    screenName = screenName,
                    onMenuClick = {
                        scope.launch {
                            if (drawerState.isClosed) {
                                drawerState.open()
                            } else {
                                drawerState.close()
                            }
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                content(innerPadding)
            }
        }
    }
}
