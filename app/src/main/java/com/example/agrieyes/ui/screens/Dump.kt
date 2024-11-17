package com.example.agrieyes.ui.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.KeyboardDoubleArrowRight
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.agrieyes.R
import com.example.agrieyes.data.Desease.Desease
import com.example.agrieyes.data.Drone.Drone
import com.example.agrieyes.data.News.News
import com.example.agrieyes.ui.components.LoadingContent
import com.example.agrieyes.ui.components.SpacerCustom
import com.example.agrieyes.ui.components.TextBold20
import com.example.agrieyes.ui.components.Title1
import com.example.agrieyes.ui.components.Title2
import com.example.agrieyes.ui.screens.home.components.Card
import com.example.agrieyes.ui.screens.home.components.FastCard
import com.example.agrieyes.ui.screens.home.components.FastNews
import com.example.agrieyes.ui.screens.home.components.FastStatus
import com.example.agrieyes.ui.theme.BackGroundPrimary
import com.example.agrieyes.ui.theme.GreenishColor
import com.example.agrieyes.ui.theme.TextPrimary


@Composable
fun HomeContent(
    cards : List<Card>,
    loading: Boolean,
    deseases: List<Desease>,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val user = "User"
    val drone = Drone("1", "running", "95%", " ")
    val news = listOf(
        News("1", "Sầu riêng tăng giá gấp đôi, nhiều nhà vườn vẫn thua lỗ", "Tiền GiangSầu riêng nghịch vụ giá cao gấp đôi lúc bình thường, song nhiều nhà vườn vẫn thất thu do thời tiết cực đoan, tỷ lệ cho trái đạt khoảng 30%.\n" +
                "\n" +
                "Giữa tháng 11, thủ phủ sầu riêng hơn 21.000 ha tại Tiền Giang vào mùa thu hoạch trái vụ, tập trung chủ yếu tại huyện Cái Bè, Cai Lậy. Dọc các tuyến đường từ xã Phú Quý (thị xã Cai Lậy) đến xã Mỹ Lợi A (huyện Cái Bè) thay vì cảnh từng đoàn xe tải của thương lái tấp nập đến vườn thu mua sầu riêng như mọi năm, nay vắng vẻ.", "", R.drawable.bando, "20/11/2024"),
        News("2", "Tám thị trường tăng mua sầu riêng Việt", "Tiền GiangSầu riêng nghịch vụ giá cao gấp đôi lúc bình thường, song nhiều nhà vườn vẫn thất thu do thời tiết cực đoan, tỷ lệ cho trái đạt khoảng 30%.\n" +
                "\n" +
                "Giữa tháng 11, thủ phủ sầu riêng hơn 21.000 ha tại Tiền Giang vào mùa thu hoạch trái vụ, tập trung chủ yếu tại huyện Cái Bè, Cai Lậy. Dọc các tuyến đường từ xã Phú Quý (thị xã Cai Lậy) đến xã Mỹ Lợi A (huyện Cái Bè) thay vì cảnh từng đoàn xe tải của thương lái tấp nập đến vườn thu mua sầu riêng như mọi năm, nay vắng vẻ.", "", R.drawable.bando, "30/10/2024"),
        News("3", "Sầu riêng tăng giá gấp đôi", "Tiền GiangSầu riêng nghịch vụ giá cao gấp đôi lúc bình thường, song nhiều nhà vườn vẫn thất thu do thời tiết cực đoan, tỷ lệ cho trái đạt khoảng 30%.\n" +
                "\n" +
                "Giữa tháng 11, thủ phủ sầu riêng hơn 21.000 ha tại Tiền Giang vào mùa thu hoạch trái vụ, tập trung chủ yếu tại huyện Cái Bè, Cai Lậy. Dọc các tuyến đường từ xã Phú Quý (thị xã Cai Lậy) đến xã Mỹ Lợi A (huyện Cái Bè) thay vì cảnh từng đoàn xe tải của thương lái tấp nập đến vườn thu mua sầu riêng như mọi năm, nay vắng vẻ.", "", R.drawable.bando, "10/10/2024"),

        )
    LoadingContent(
        loading = loading,
        empty = deseases.isEmpty() && !loading,
        emptyContent = {  },
        onRefresh = onRefresh,

    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 20.dp)
        ) {
            Title1("Hello, " + user)
            SpacerCustom(20)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween, // Tự động chia không gian đều giữa các thẻ
                modifier = Modifier.fillMaxWidth() // Đảm bảo LazyRow chiếm toàn bộ chiều rộng màn hình
            ) {
                items(cards) { card ->
                    FastCard(card = card)
                }
            }
            SpacerCustom(30)

            Title2("Drone Status")
            SpacerCustom(10)
            FastStatus("ID", drone.id)
            SpacerCustom(10)
            FastStatus("Status", drone.status)
            SpacerCustom(10)
            FastStatus("Battery", drone.battery)
            SpacerCustom(10)

            val image = painterResource(id = R.drawable.bando) // Thay 'sample_image' bằng tên file ảnh của bạn
            Image(
                painter = image,
                contentDescription = "Bản đồ",  // Mô tả ảnh
                modifier = Modifier.fillMaxWidth() // Điều chỉnh kích thước ảnh
            )
            SpacerCustom(30)

            Title2("News")
            SpacerCustom(10)
            LazyColumn(
                modifier = Modifier.fillMaxWidth() // Đảm bảo LazyRow chiếm toàn bộ chiều rộng màn hình
            ) {
                items(news) { new ->
                    FastNews(news = new)
                }
            }

        }
    }
}


@Composable
fun DiseaseRecordContent(
    id: String,
    loading: Boolean,
    modifier: Modifier = Modifier
) {
    val diseases = listOf(null)
    val map = mapOf(
        "yellow Leaf" to "98%",
        "others" to "12%",
        "other" to "1%",
        "yellow Leafư" to "98%",
        "othersư" to "12%",
        "otherư" to "1%"
    )
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



@Preview
@Composable
private fun ContentPreview() {
//    val cards = listOf(
//        Card(icon = Icons.Outlined.Cloud, "Weather", "Cloudy"),
//        Card(icon = Icons.Outlined.WaterDrop, "Humidity", "212"),
//        Card(icon = Icons.Outlined.Thermostat, "Temp", "31")
//    )


    DiseaseRecordContent("df", false)

//    HomeContent(
//        cards, false, listOf(), { }
//    )
}