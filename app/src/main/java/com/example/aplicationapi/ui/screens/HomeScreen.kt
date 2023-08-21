package com.example.aplicationapi.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.aplicationapi.domain.items.PromosItem
import com.example.aplicationapi.ui.nav.Screens
import com.example.aplicationapi.ui.vm.PromoViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(promoViewModel: PromoViewModel, navController: NavController) {

    val promos = promoViewModel.promos.observeAsState(listOf()).value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Promos App", fontWeight = FontWeight.Bold) }
            )
        }
    ){
        LazyColumn{
            items(promos){promo ->
                PromoCard(promo = promo, navController = navController)
            }
        }
    }
}

@Composable
fun PromoCard(promo : PromosItem, navController: NavController){

    Card(

        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${promo.id}")
            }

    ) {

        Row {

            Image(painter = rememberImagePainter(promo.img.formats.medium.url) ,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(175.dp)
                    .height(115.dp)
            )

            Column(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)) {

                Text(text = promo.nama, fontWeight = FontWeight.Bold )
                Text(text = promo.desc, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}