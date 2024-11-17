package com.example.agrieyes.ui.screens.DiseaseRecord


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.KeyboardDoubleArrowRight
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.agrieyes.R
import com.example.agrieyes.ui.components.LoadingContent
import com.example.agrieyes.ui.components.SpacerCustom
import com.example.agrieyes.ui.components.TextBold20
import com.example.agrieyes.ui.screens.home.components.Card
import com.example.agrieyes.ui.screens.home.components.FastStatus
import com.example.agrieyes.ui.theme.BackGroundPrimary
import com.example.agrieyes.ui.theme.GreenishColor
import com.example.agrieyes.ui.theme.TextPrimary


@Composable
fun DiseaseRecordScreen(
    id: String,
    modifier: Modifier = Modifier,
    viewModel: DiseaseRecordViewModel = hiltViewModel(),
) {

    val uiState by viewModel.diseaseRecordUiState.collectAsStateWithLifecycle()

    val loading = uiState.isLoading
    val record = uiState.diseaseRecord
    val deseases = uiState.deseases
    val onRefresh = viewModel::refresh

    val diseases = listOf(null)
    val map = mapOf(
        "yellow Leaf" to "98%",
        "others" to "12%",
        "other" to "1%",
        "yellow Leafư" to "98%",
        "othersư" to "12%",
        "otherư" to "1%"
    )
    val diseasePercent = record?.desease

    LoadingContent(
        loading = loading,
        empty = !diseases.isEmpty() && !loading,
        emptyContent = {},
        onRefresh = { },
    ) {
        Column(
            modifier = modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = BackGroundPrimary)

        ) {
            // Hình ảnh
            val image = painterResource(id = R.drawable.bando) // Thay 'bando' bằng tên file ảnh của bạn
            Image(
                painter = image,
                contentDescription = "Bản đồ",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp) // Chiều cao tối đa là 200 dp
                    .clip(shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
                contentScale = ContentScale.Crop // Cắt ảnh để phù hợp với kích thước
            )

            // Container hình tròn với icon
            Column (
                modifier = Modifier.padding(horizontal = 30.dp)
            ) {
                Box(
                    modifier = Modifier
                        .offset(y = (-30).dp) // Dịch lên 50dp
                        .size(70.dp) // Kích thước của container
                        .clip(CircleShape) // Để tạo hình tròn
                        .background(GreenishColor)
                        .border(BorderStroke(width = 4.dp, color = Color.White), CircleShape)                    // Màu nền cho container

                ) {
                    Icon(
                        imageVector = Icons.Default.Star, // Thay bằng icon bạn muốn
                        contentDescription = "Icon",
                        tint = BackGroundPrimary,
                        modifier = Modifier
                            .size(40.dp) // Kích thước icon
                            .align(Alignment.Center) // Căn giữa icon trong container
                    )
                }

                LazyColumn (
                    modifier = Modifier
                        .heightIn(max = 400.dp)
                ) {
                    items(map.toList()) { (key, value) -> // Chuyển đổi Map thành danh sách
                        // Hiển thị từng cặp key-value
                        FastStatus(
                            title = key,
                            value = value
                        )
                        SpacerCustom(10)
                    }
                }
                SpacerCustom(20)
                Row(
                    modifier = Modifier
                        .background(color = GreenishColor, shape = RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextBold20("See solutions", TextPrimary)
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .padding(10.dp),

                        ) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardDoubleArrowRight,
                            contentDescription = "Arrow Icon",
                            tint = TextPrimary
                        )
                    }
                }
            }

        }
    }
}



