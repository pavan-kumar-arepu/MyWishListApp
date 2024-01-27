package com.ppam.wishlistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ppam.wishlistapp.ui.components.AppBarView
import com.ppam.wishlistapp.R
import com.ppam.wishlistapp.viewModel.WishViewModel
import com.ppam.wishlistapp.ui.components.WishTextField

@Composable
 fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
 ) {
     Scaffold(
         topBar = {
             AppBarView (title =
             if(id != 0L) stringResource(id = R.string.update_wish)
             else stringResource(id = R.string.add_wish)
             ) {
                 navController.navigateUp()
             }
         }) {
         Column(
             modifier = Modifier
                 .padding(it)
                 .wrapContentSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
             ) {
             Spacer(modifier = Modifier.height(10.dp))
             
             WishTextField(label = "Title",
                 value = viewModel.wishTitleState, 
                 onValueChanged = {
                     viewModel.onWishTitleChanged(it)
                 })

             Spacer(modifier = Modifier.height(10.dp))

             WishTextField(label = "Description",
                 value = viewModel.wishDescriptionState,
                 onValueChanged = {
                     viewModel.onWishDescriptionChanged(it)
                 })

             Spacer(modifier = Modifier.height(10.dp))
             Button(onClick = {
                 if(viewModel.wishTitleState.isNotEmpty() &&
                     viewModel.wishDescriptionState.isNotEmpty()){
                     // TODO Update Wish
                 } else {
                     // TODO Add Wish
                 }
             },
                 colors = ButtonDefaults.buttonColors(
                     backgroundColor = colorResource(id = R.color.teal_200),
                     contentColor = Color.White
                 )
             ) {
                 Text(
                     text = if(id != 0L) stringResource(id = R.string.update_wish)
                     else stringResource(id = R.string.add_wish),
                     style = TextStyle(
                         fontSize = 18.sp
                     )

                 )
             }

         }
     }
 }