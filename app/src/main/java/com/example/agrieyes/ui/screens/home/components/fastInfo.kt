package com.example.agrieyes.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.agrieyes.R
import com.example.agrieyes.data.News.News
import com.example.agrieyes.ui.components.Text15
import com.example.agrieyes.ui.components.TextBold20
import com.example.agrieyes.ui.theme.BackGroundInput
import com.example.agrieyes.ui.theme.BackGroundSecondary
import com.example.agrieyes.ui.theme.GreenishColor
import com.example.agrieyes.ui.theme.TextPrimary

data class Card(
    val icon: ImageVector,
    val title: String,
    val value: String,
)

@Composable
fun FastCard(
    card: Card
) {
    Box(
        modifier = Modifier
            .shadow(5.dp, shape = RoundedCornerShape(10.dp)) // Thêm bóng cho Card
            .width(85.dp)
            .height(100.dp)
            .background(color = GreenishColor, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), // Đảm bảo Column chiếm toàn bộ không gian của Box
            verticalArrangement = Arrangement.Center, // Căn giữa theo chiều dọc
            horizontalAlignment = Alignment.CenterHorizontally // Căn giữa theo chiều ngang
        ) {
            Icon(
                imageVector = card.icon,
                tint = TextPrimary,
                contentDescription = null, // Đáp ứng yêu cầu accessibility
                modifier = Modifier.size(24.dp) // Đặt kích thước cho icon
            )
            Text(
                text = card.value,
                color = TextPrimary,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Căn giữa
            )

            // Tiêu đề của Card
            Text(
                text = card.title,
                color = TextPrimary,
                modifier = Modifier.padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally), // Căn giữa
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Preview
@Composable
fun FastCardPreview() {
    val card = Card(icon = Icons.Outlined.Cloud, "Weather", "Cloudy")
    FastCard(card)
}

@Composable
fun FastStatus(
    title: String,
    value: String,
) {
    Row(
        modifier = Modifier
            .background(color = BackGroundSecondary, shape = RoundedCornerShape(20.dp))  // Màu nền và bo góc
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextBold20(title, GreenishColor)
        TextBold20(value, GreenishColor)
    }
}

@Preview
@Composable
fun FastStatusPreview() {
    FastStatus(
        "Running",
        "True"
    )
}

@Composable
fun FastNews(
    news : News
) {
    Box(
        modifier = Modifier
            .height(200.dp) // Đặt chiều cao của Box
            .fillMaxWidth() // Đảm bảo chiếm toàn bộ chiều rộng
            .clip(RoundedCornerShape(10.dp)) // Bo góc cho Box
    ) {
        // Thiết lập ảnh nền với opacity giảm
        Image(
            painter = painterResource(id = news.img),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop, // Cắt ảnh để phủ đầy Box
            modifier = Modifier
                .fillMaxSize() // Lấp đầy Box cả chiều rộng và chiều cao
                .align(Alignment.Center) // Căn giữa nếu cần
                .clip(RoundedCornerShape(10.dp)) // Bo góc cho ảnh
        )

        // Lớp phủ mờ (opacity) cho ảnh nền
        Box(
            modifier = Modifier
                .matchParentSize() // Đảm bảo lớp phủ bao phủ toàn bộ Box
                .background(Color.Black.copy(alpha = 0.5f)) // Đặt màu nền với alpha để tạo hiệu ứng opacity
                .clip(RoundedCornerShape(10.dp)) // Bo góc cho lớp phủ
        )

        // Nội dung ở trên ảnh nền
        Column(
            modifier = Modifier
                .fillMaxSize() // Đảm bảo Column lấp đầy Box
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text15(news.date, Color.White)
                TextBold20(news.title, GreenishColor)
            }

            Text(
                text = news.content,
                color = Color.White,
                maxLines = 3
            )
        }
    }
}

@Preview
@Composable
fun FastNewsPreview() {
    val news = News("3", "Sầu riêng tăng giá gấp đôi", "Tiền GiangSầu riêng nghịch vụ giá cao gấp đôi lúc bình thường, song nhiều nhà vườn vẫn thất thu do thời tiết cực đoan, tỷ lệ cho trái đạt khoảng 30%.\n" +
            "\n" +
            "Giữa tháng 11, thủ phủ sầu riêng hơn 21.000 ha tại Tiền Giang vào mùa thu hoạch trái vụ, tập trung chủ yếu tại huyện Cái Bè, Cai Lậy. Dọc các tuyến đường từ xã Phú Quý (thị xã Cai Lậy) đến xã Mỹ Lợi A (huyện Cái Bè) thay vì cảnh từng đoàn xe tải của thương lái tấp nập đến vườn thu mua sầu riêng như mọi năm, nay vắng vẻ.", "", R.drawable.bando, "10/10/2024")

    FastNews(news)
}
