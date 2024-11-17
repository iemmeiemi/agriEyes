package com.example.agrieyes.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.agrieyes.R
import com.example.agrieyes.ui.components.LoadingContent
import com.example.agrieyes.ui.components.SpacerCustom
import com.example.agrieyes.ui.components.Title1
import com.example.agrieyes.ui.components.Title2
import com.example.agrieyes.ui.screens.home.components.Card
import com.example.agrieyes.ui.screens.home.components.FastCard
import com.example.agrieyes.ui.screens.home.components.FastNews
import com.example.agrieyes.ui.screens.home.components.FastStatus


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val cards = listOf(
        Card(icon = Icons.Outlined.Cloud, "Weather", "Cloudy"),
        Card(icon = Icons.Outlined.WaterDrop, "Humidity", "212"),
        Card(icon = Icons.Outlined.Thermostat, "Temperature", "31")
    )
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val loading = uiState.isLoading
    val deseases = uiState.deseases
    val onRefresh = viewModel::refresh

    val user = "User"
    val drone = uiState.drone
    val news = uiState.news

    LoadingContent(
        loading = loading,
        empty = deseases.isEmpty() && !loading,
        emptyContent = {},
        onRefresh = onRefresh,
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            item {
                Title1("Hello, $user")
                SpacerCustom(20)
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(cards) { card ->
                        FastCard(card = card)
                    }
                }
                SpacerCustom(30)
            }
            item {
                Title2("Drone Status")
                SpacerCustom(10)
                FastStatus("ID", drone.id)
                SpacerCustom(10)
                FastStatus("Status", drone.status)
                SpacerCustom(10)
                FastStatus("Battery", drone.battery)
                SpacerCustom(10)
            }
            item {
                val image = painterResource(id = R.drawable.bando) // Thay 'sample_image' bằng tên file ảnh của bạn
                Image(
                    painter = image,
                    contentDescription = "Bản đồ",
                    modifier = Modifier.fillMaxWidth()
                )
                SpacerCustom(30)
            }
            item {
                Title2("News")
                SpacerCustom(10)
            }
            items(news) { new ->
                FastNews(news = new)
            }
        }
    }
}



