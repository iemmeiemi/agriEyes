package com.example.agrieyes.ui.components

import androidx.compose.material.Colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.agrieyes.ui.theme.TextSecondary

@Composable
fun Title1(
    text: String,

) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = TextSecondary
    )
}

@Composable
fun Title2(
    text: String,

    ) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    )
}

@Composable
fun TextBold20(
    text: String,
    color: Color,  // Changed 'Color' to 'color' for better naming conventions
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = color // Properly use 'color' here
    )
}

@Composable
fun Text15(
    text: String,
    color: Color,  // Changed 'Color' to 'color' for better naming conventions
) {
    Text(
        text = text,
        fontSize = 15.sp,
        color = color // Properly use 'color' here
    )
}