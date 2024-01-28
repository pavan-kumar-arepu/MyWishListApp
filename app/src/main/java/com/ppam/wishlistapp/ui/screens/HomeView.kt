package com.ppam.wishlistapp.ui.screens

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.ui.draw.scale
import androidx.navigation.NavController
import com.ppam.wishlistapp.data.Wish
import com.ppam.wishlistapp.ui.Screen
import com.ppam.wishlistapp.ui.components.AppBarView
import com.ppam.wishlistapp.viewModel.WishViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {AppBarView(title= "WishList")},
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {
                    navController.navigate(Screen.AddScreen.route + "/0L")
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        val wishlist = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            items(wishlist.value, key={wish-> wish.id} ){
                    wish ->
                val dismissState = rememberDismissState(
                    confirmStateChange = {
                        if(it == DismissValue.DismissedToEnd || it== DismissValue.DismissedToStart){
                            viewModel.deleteWish(wish)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    background = {
                        val color by animateColorAsState(
                            if(dismissState.dismissDirection
                                == DismissDirection.EndToStart) Color.Red else Color.Transparent
                            ,label = ""
                        )
                        val alignment = Alignment.CenterEnd
                        Box(
                            Modifier.fillMaxSize().background(color).padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ){
                            Icon(Icons.Default.Delete,
                                contentDescription = "Delete Icon",
                                tint = Color.White)
                        }
                    },
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = {FractionalThreshold(1f)},
                    dismissContent = {
                        WishItem(wish = wish) {
                            val id = wish.id
                            navController.navigate(Screen.AddScreen.route + "/$id")
                        }
                    }
                )
            }
        }
    }

}

