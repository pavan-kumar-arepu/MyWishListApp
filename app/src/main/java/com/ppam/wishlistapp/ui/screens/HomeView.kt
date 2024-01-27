package com.ppam.wishlistapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ppam.wishlistapp.ui.components.AppBarView
import com.ppam.wishlistapp.ui.Screen
import com.ppam.wishlistapp.viewModel.WishViewModel
import com.ppam.wishlistapp.data.DummyWish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
    ) {
    val context = LocalContext.current
    Scaffold(
        topBar = { AppBarView("WishList", {

        })
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = { // TODO Add Navigation to Add WishList to the Screen }) {
                    navController.navigate(Screen.AddScreen.route)
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            items(DummyWish.wishList) {
                wish -> WishItem(wish = wish) {
                
            }
            }
        }
    }
}

